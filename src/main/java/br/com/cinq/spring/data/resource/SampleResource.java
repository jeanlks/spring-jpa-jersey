package br.com.cinq.spring.data.resource;

import br.com.cinq.spring.data.sample.entity.City;
import br.com.cinq.spring.data.sample.repository.CityRepository;
import br.com.cinq.spring.data.sample.service.CityService;
import br.com.cinq.spring.data.sample.service.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/cities")
public class SampleResource {

    private CityService service;

    @Autowired
    public SampleResource(CityService cityService) {
        this.service = cityService;
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({"application/json"})
    public Response getCities(@QueryParam("country") String country) {
        List<City> cities = service.getCities(country);
        return Response.ok(cities).build();
    }
}
