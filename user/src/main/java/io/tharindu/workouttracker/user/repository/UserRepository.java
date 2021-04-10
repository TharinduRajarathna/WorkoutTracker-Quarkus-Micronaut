package io.tharindu.workouttracker.user.repository;

import io.tharindu.workouttracker.user.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    //public User findById(long id);
}
