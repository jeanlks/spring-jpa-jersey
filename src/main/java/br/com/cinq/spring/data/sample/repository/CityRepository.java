package br.com.cinq.spring.data.sample.repository;

import br.com.cinq.spring.data.sample.entity.City;
import br.com.cinq.spring.data.sample.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.Null;
import java.util.List;

/**
 * City Repository using Spring Data.
 * @author Jean
 */
public interface CityRepository  extends JpaRepository<City, Integer> {
    List<City> findAllByCountry(Country country);
}
