package br.com.cinq.spring.data.sample.repository;

import br.com.cinq.spring.data.sample.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Integer>{
    List<Country> findCountriesByNameIgnoreCaseContaining(String name);
}
