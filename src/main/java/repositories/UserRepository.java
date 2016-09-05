package main.java.repositories;

import org.springframework.data.repository.CrudRepository;

import main.java.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findOneByEmail(String email);
    

    @Override
    List<User> findAll();
}