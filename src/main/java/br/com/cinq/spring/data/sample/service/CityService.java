package br.com.cinq.spring.data.sample.service;

import br.com.cinq.spring.data.sample.entity.City;

import java.util.List;

/**
 * Interface for the city service
 * @author Jean
 */
public interface CityService {
    /**
     * Service responsible for retrieving the cities either
     * querying by country or not.
     * @param country country name.
     * @return list of cities
     */
    List<City> getCities(String country);

    /**
     * Service responsible for uploading a list of cities to the database.
     * @return list of cities added.
     */
    List<City> addCities(List<City> cities);
}
