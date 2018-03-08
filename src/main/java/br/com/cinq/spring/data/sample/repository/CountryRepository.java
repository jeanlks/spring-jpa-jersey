package br.com.cinq.spring.data.sample.repository;

import br.com.cinq.spring.data.sample.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Country Repository using Spring Data.
 * @author Jean
 */
public interface CountryRepository extends JpaRepository<Country, Integer>{
    /**
     * Retrieves all country by its name in a like query ignoring the characters case
     * @param name name of country.
     * @return lista of countries.
     */
    List<Country> findCountriesByNameIgnoreCaseContaining(String name);
}
