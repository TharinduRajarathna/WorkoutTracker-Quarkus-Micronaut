package io.tharindu.workouttracker.measurement.web.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class MeasurementResource {

    @GET
    @Path("hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello Quarkus";
    }

}
