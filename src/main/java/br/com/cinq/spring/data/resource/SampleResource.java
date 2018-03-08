package br.com.cinq.spring.data.resource;

import br.com.cinq.spring.data.sample.entity.City;
import br.com.cinq.spring.data.sample.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Endpoint Sample Resource
 * @author Jean 
 */
@Path("/cities")
public class SampleResource {

    private CityService service;

    @Autowired
    public SampleResource(CityService cityService) {
        this.service = cityService;
    }

    /**
     * Endpoint responsible for retrieving cities.
     * @param country country name
     * @return lista of cities.
     */
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({"application/json"})
    public Response getCities(@QueryParam("country") String country) {
        List<City> cities = service.getCities(country);
        return Response.ok(cities).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({"application/json"})
    public Response uploadData( List<City> cities) {
        return Response.ok(service.addCities(cities)).build();
    }
}
