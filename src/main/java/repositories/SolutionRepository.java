package main.java.repositories;

import org.springframework.data.repository.CrudRepository;

import main.java.Solution;

import java.util.List;


public interface SolutionRepository extends CrudRepository<Solution, Long> {

    @Override
    List<Solution> findAll();
}