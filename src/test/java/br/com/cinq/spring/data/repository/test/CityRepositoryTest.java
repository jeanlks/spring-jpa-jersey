package br.com.cinq.spring.data.repository.test;

import br.com.cinq.spring.data.sample.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Eye candy: implements a sample in using JpaRespositories
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(value = "server.port=9000", classes = Application.class)
@ActiveProfiles("unit")
public class CityRepositoryTest {

//    @Autowired
//    private CityRepository dao;

    @Test
    public void testQueryPerson() {

//        Assert.assertNotNull(dao);
        
//        Assert.assertTrue(dao.count()>0);

//        Country country = new Country();
//        country.setId(3); // Should be France

//        List<City> list = dao.findByCountry(country);

//        Assert.assertEquals(2, list.size());
    }
}
