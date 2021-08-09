package com.example.testTask.Repository;

import com.example.testTask.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
!!!!!!!!!

CRUD -> JPA
*
* */

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    boolean existsByLogin(String login);
    User findByLogin(String userName);
}
