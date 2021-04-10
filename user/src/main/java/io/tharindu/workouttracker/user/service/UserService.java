package io.tharindu.workouttracker.user.service;

import io.tharindu.workouttracker.user.domain.User;
import io.tharindu.workouttracker.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

}
