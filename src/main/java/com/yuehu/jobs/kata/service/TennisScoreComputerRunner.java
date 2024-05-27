/*
 * Copyright (c) 2024 the original author (Yue HU).
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.yuehu.jobs.kata.service;

import com.yuehu.jobs.kata.exception.InvalidParameterException;
import com.yuehu.jobs.kata.service.reader.GameReader;
import com.yuehu.jobs.kata.service.scoreservice.ScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Tennis score computer runner.
 * Entry point of computer.
 * <p>
 * The computer is designed using Hexagonal architecture:
 * - The interface GameReader is created for user-side, in order to isolate the interactions with users.
 * - The business logic is encapsulated in ScoreService.
 * - The interface ResultPrinter is created for server-side, in order to isolate output and inverse dependency to ScoreService.
 *
 * @author huyue
 */
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
