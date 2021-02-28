package io.tharindu.workouttracker.user.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UserResource {
    @RequestMapping("hello")
    public String sayHello() {
        return "Hello Spring";
    }

}
