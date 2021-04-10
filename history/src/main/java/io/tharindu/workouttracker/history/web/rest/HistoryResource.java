package io.tharindu.workouttracker.history.web.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HistoryResource {

    @GetMapping("hello")
    public String sayHello() {
        return "Hello Spring Native";
    }
}
