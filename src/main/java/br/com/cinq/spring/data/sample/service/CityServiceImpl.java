package br.com.cinq.spring.data.sample.service;

import br.com.cinq.spring.data.sample.entity.City;
import br.com.cinq.spring.data.sample.entity.Country;
import br.com.cinq.spring.data.sample.repository.CityRepository;
import br.com.cinq.spring.data.sample.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            return cityRepository.findAll();
        } else {
            List<City> cities= new ArrayList<>();
            List<Country> countries = countryRepository.findCountriesByNameIgnoreCaseContaining(countryName);
            countries.forEach(c -> cities.addAll(cityRepository.findAllByCountry(c)));
            return cities;
        }
    }

}
