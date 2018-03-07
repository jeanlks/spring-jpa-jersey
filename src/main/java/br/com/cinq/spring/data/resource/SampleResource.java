package br.com.cinq.spring.data.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/cities")
public class SampleResource {

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public String getCities() {
        return "rest";
    }
}
