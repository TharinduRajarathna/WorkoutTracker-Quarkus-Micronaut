package io.tharindu.workouttracker.user.web.rest;

import io.tharindu.workouttracker.user.domain.User;
import io.tharindu.workouttracker.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/user")
public class UserResource {

    @Autowired
    UserService userService;

    @PostConstruct
    public void init() {
        User user1 = new User("Tharindu", "Rajarathna", 35);
        userService.createUser(user1);
        User user2 = new User("Dumindu", "Rajarathna", 35);
        userService.createUser(user2);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user, @PathVariable(name = "id") long id) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable(name = "id") long id) {
        userService.deleteUser(id);
    }

}
