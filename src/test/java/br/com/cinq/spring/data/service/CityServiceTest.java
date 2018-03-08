package br.com.cinq.spring.data.service;

import br.com.cinq.spring.data.sample.application.Application;
import br.com.cinq.spring.data.sample.entity.City;
import br.com.cinq.spring.data.sample.service.CityService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(value = "server.port=9000", classes = Application.class)
@ActiveProfiles("unit")
public class CityServiceTest {
    @Autowired
    private CityService service;

    @Test
    public void shouldfindAllCities() {

        Assert.assertNotNull(service);

        service.getCities(null);

        List<City> list =  service.getCities(null);

        Assert.assertEquals(9, list.size());
    }

    @Test
    public void shouldFindCitiesByCountry() {

        Assert.assertNotNull(service);

        List<City> list = service.getCities("Unit");

        Assert.assertEquals(3, list.size());
    }
}
