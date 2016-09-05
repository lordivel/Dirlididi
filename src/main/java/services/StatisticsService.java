package main.java.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.dto.StatisticDTO;
import main.java.repositories.ProblemRepository;
import main.java.repositories.UserRepository;

@Service
public class StatisticsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProblemRepository problemRepository;

    public StatisticsService() {}

    public StatisticDTO getStatistics() {
        StatisticDTO stat = new StatisticDTO();
        stat.totalProblems = getTotalProblem();
        stat.totalUsers = getTotalUsers();
        return stat;
    }

    private int getTotalUsers() {
        return (int) userRepository.count();
    }

    private int getTotalProblem() {
        return (int) problemRepository.count();
    }

}