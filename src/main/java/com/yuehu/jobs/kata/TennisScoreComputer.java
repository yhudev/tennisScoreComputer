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

package com.yuehu.jobs.kata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * A tennis score computer which respect following simple tennis scoring rules:
 * <p>
 * - Each player starts a game with 0 point.
 * - If the player wins the 1st ball, he will have 15 points. 2nd balls won : 30 points. 3rd ball won : 40points.
 * - If a player have 40 points and wins the ball, he wins the game, however there are special rules.
 * - If both players have 40 points the players are “deuce”.
 * [x] If the game is in deuce, the winner of the ball will have advantage
 * [x] If the player with advantage wins the ball he wins the game
 * [x] If the player without advantage wins the ball they are back at “deuce”.
 * <p>
 * You can found more details about the rules here : ( <a href="http://en.wikipedia.org/wiki/Tennis#Scoring"> Tennis Scoring </a> )
 * <p>
 * The computer takes 1 parameter which is a String containing the character 'A' or 'B'.
 * The character 'A' corresponding to "player A won the ball", and 'B' corresponding to "player B won the ball".
 *
 * @author huyue
 */
@SpringBootApplication
public class TennisScoreComputer {

    public static void main(String[] args) {
        SpringApplication.run(TennisScoreComputer.class, args);
    }
}