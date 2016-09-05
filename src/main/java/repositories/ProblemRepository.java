package main.java.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import main.java.Problem;

import java.util.List;

@Repository
public interface ProblemRepository extends CrudRepository<Problem, Long> {

    List<Problem> findByName(String name);

    @Override
    List<Problem> findAll();
}