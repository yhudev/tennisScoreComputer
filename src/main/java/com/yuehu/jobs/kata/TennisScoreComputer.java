package com.yuehu.jobs.kata;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RequiredArgsConstructor
@SpringBootApplication
public class TennisScoreComputer {

    public static void main(String[] args) {
        SpringApplication.run(TennisScoreComputer.class, args);
    }
}