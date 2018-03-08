package br.com.cinq.spring.data.service;

import br.com.cinq.spring.data.sample.application.Application;
import br.com.cinq.spring.data.sample.entity.City;
import br.com.cinq.spring.data.sample.entity.Country;
import br.com.cinq.spring.data.sample.service.CityService;
import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(value = "server.port=9000", classes = Application.class)
@ActiveProfiles("unit")
public class CityServiceTest {
    @Autowired
    private CityService service;

    @Before
    public void setUp() {
        //Should add cities
        service.addCities(getMockedCities());
    }

    @Test
    public void shouldfindAllCities() {

        Assert.assertNotNull(service);

        service.getCities(null);

        List<City> list =  service.getCities(null);

        Assert.assertEquals(13, list.size());
    }

    @Test
    public void shouldFindCitiesByCountry() {

        Assert.assertNotNull(service);

        List<City> list = service.getCities("Unit");

        Assert.assertEquals(3, list.size());
    }

    public List<City> getMockedCities(){
     List<City> cities = new ArrayList<>();
     City city1 = new City();
     city1.setCountry(getMockedCountry());
     city1.setName("Toronto");
     City city2 = new City();
     city2.setCountry(getMockedCountry());
     city2.setName("Montreal");
     cities.add(city1);
     cities.add(city2);
     return  cities;
    }

    public Country getMockedCountry() {
        Country country = new Country();
        country.setName("Canada");
        return country;
    }
}
