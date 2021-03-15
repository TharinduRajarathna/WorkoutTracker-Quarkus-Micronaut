package io.tharindu.workouttracker.exercise.web.rest;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/hello")
public class ExerciseResource {

    @Get(produces = MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello Micronaut";
    }
}
