package br.com.cinq.spring.data.sample.service;

import br.com.cinq.spring.data.sample.entity.City;
import br.com.cinq.spring.data.sample.entity.Country;
import br.com.cinq.spring.data.sample.repository.CityRepository;
import br.com.cinq.spring.data.sample.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * City Service implementation.
 * @author Jean
 */
@Service
public class CityServiceImpl  implements CityService {
    private CityRepository cityRepository;
    private CountryRepository countryRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository, CountryRepository countryRepository) {
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<City> getCities(String countryName) {
        if (countryName == null) {
            return (List<City>) cityRepository.findAll();
        } else {
            List<City> cities= new ArrayList<>();
            List<Country> countries = countryRepository.findCountriesByNameIgnoreCaseContaining(countryName);
            countries.forEach(c -> cities.addAll(cityRepository.findAllByCountry(c)));
            return cities;
        }
    }

    @Override
    @Transactional
    public List<City> addCities(List<City> cities) {
        List<City> savedCities = new  ArrayList<>();
        for(City city: cities) {
            Country country = countryRepository
                                        .findFirstByNameIgnoreCaseContaining(city.getCountry().getName());
            if(country==null) {
                savedCities.add(cityRepository.save(city));
            }else {
                    city.setCountry(country);
                    savedCities.add(cityRepository.save(city));
            }
        }
        return savedCities;
    }
}
