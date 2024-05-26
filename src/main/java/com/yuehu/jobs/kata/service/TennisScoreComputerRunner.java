package com.yuehu.jobs.kata.service;

import com.yuehu.jobs.kata.exception.InvalidParameterException;
import com.yuehu.jobs.kata.service.reader.GameReader;
import com.yuehu.jobs.kata.service.scoreservice.ScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TennisScoreComputerRunner implements CommandLineRunner {

    private final GameReader gameReader;

    private final ScoreService scoreService;

    @Override
    public void run(String... args) throws Exception {
        if (args.length != 1) {
            throw new InvalidParameterException("Expected 1 parameter.");
        }
        scoreService.process(gameReader.read(args[0]));
    }
}
