package br.com.cinq.spring.data.sample.repository;

import br.com.cinq.spring.data.sample.entity.Country;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Country Repository using Spring Data.
 * @author Jean
 */
public interface CountryRepository extends CrudRepository<Country, Integer> {
    /**
     * Retrieves all country by its name in a like query ignoring the characters case
     * @param name name of country.
     * @return lista of countries.
     */
    List<Country> findCountriesByNameIgnoreCaseContaining(String name);

    /**
     * Retrieves all country by its name ignoring the characters case
     * @param countryName name of country.
     * @return lista of countries.
     */
    Country findFirstByNameIgnoreCaseContaining(String countryName);
}
