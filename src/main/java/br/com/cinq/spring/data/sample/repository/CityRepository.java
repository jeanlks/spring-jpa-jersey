package br.com.cinq.spring.data.sample.repository;

import br.com.cinq.spring.data.sample.entity.City;
import br.com.cinq.spring.data.sample.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import javax.validation.constraints.Null;
import java.util.List;

/**
 * City Repository using Spring Data.
 * @author Jean
 */
public interface CityRepository  extends CrudRepository<City, Integer> {
    List<City> findAllByCountry(Country country);
}
