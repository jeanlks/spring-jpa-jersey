package br.com.cinq.spring.data.sample.service;

import br.com.cinq.spring.data.sample.entity.City;

import java.util.List;

/**
 * Interface for the city service
 * @author Jean
 */
public interface CityService {
    List<City> getCities(String country);
}
