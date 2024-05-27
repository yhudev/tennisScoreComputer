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

package com.yuehu.jobs.kata.domain;

import com.yuehu.jobs.kata.domain.gamestatus.DeuceStatus;
import com.yuehu.jobs.kata.domain.gamestatus.EndStatus;
import com.yuehu.jobs.kata.domain.gamestatus.InProgressStatus;
import com.yuehu.jobs.kata.domain.scoringsystem.TennisScoringRuleVisitor;
import com.yuehu.jobs.kata.enums.Score;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.yuehu.jobs.kata.constant.PlayerConstants.A;
import static com.yuehu.jobs.kata.constant.PlayerConstants.B;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test different tennis scoring rules.
 */
class TennisScoringRuleVisitorTest {

    private TennisScoringRuleVisitor objectUnderTest;

    private static Stream<Arguments> increaseScoreCases() {
        return Stream.of(
                Arguments.of(Score.ZERO, Score.ZERO, A, Score.FIFTEEN, Score.ZERO),
                Arguments.of(Score.FIFTEEN, Score.ZERO, A, Score.THIRTY, Score.ZERO),
                Arguments.of(Score.THIRTY, Score.ZERO, A, Score.FORTY, Score.ZERO)
        );
    }

    @BeforeEach
    void init() {
        this.objectUnderTest = new TennisScoringRuleVisitor();
    }

    @ParameterizedTest
    @MethodSource("increaseScoreCases")
    void should_increase_score_when_win_the_ball(Score scoreA, Score scoreB, String winnerId, Score resultA, Score resultB) {
        // Given
        final Player playerA = new Player(A, false, scoreA);
        final Player playerB = new Player(B, false, scoreB);
        final Game game = new Game(playerA, playerB);
        game.changeStatus(InProgressStatus.ofInstance(game));
        final Round round = new Round(winnerId);
        // When
        objectUnderTest.visit(game, round);
        // Then
        assertThat(game.getStatus()).isEqualTo(InProgressStatus.ofInstance(game));
        assertThat(playerA.getScore()).isEqualTo(resultA);
        assertThat(playerB.getScore()).isEqualTo(resultB);
    }

    @Test
    void should_win_when_have_forty_and_win_the_ball() {
        // Given
        final Player playerA = new Player(A, false, Score.FORTY);
        final Player playerB = new Player(B, false, Score.THIRTY);
        final Game game = new Game(playerA, playerB);
        game.changeStatus(InProgressStatus.ofInstance(game));
        final Round round = new Round(A);
        // When
        objectUnderTest.visit(game, round);
        // Then
        assertThat(game.getStatus()).isEqualTo(EndStatus.ofInstance(game, A));
    }

    @Test
    void should_have_advantage_when_both_have_forty_and_win_the_ball() {
        // Given
        final Player playerA = new Player(A, false, Score.FORTY);
        final Player playerB = new Player(B, false, Score.FORTY);
        final Game game = new Game(playerA, playerB);
        game.changeStatus(InProgressStatus.ofInstance(game));
        final Round round = new Round(A);
        // When
        objectUnderTest.visit(game, round);
        // Then
        assertThat(game.getStatus()).isEqualTo(DeuceStatus.ofInstance(game));
        assertThat(playerA.isAdvantaged()).isTrue();
        assertThat(playerB.isAdvantaged()).isFalse();
    }

    @Test
    void should_win_when_in_deuce_and_one_with_advantage_win_the_ball() {
        // Given
        final Player playerA = new Player(A, true, Score.FORTY);
        final Player playerB = new Player(B, false, Score.FORTY);
        final Game game = new Game(playerA, playerB);
        game.changeStatus(DeuceStatus.ofInstance(game));
        final Round round = new Round(A);
        // When
        objectUnderTest.visit(game, round);
        // Then
        assertThat(game.getStatus()).isEqualTo(EndStatus.ofInstance(game, A));
    }

    @Test
    void should_back_to_deuce_when_in_deuce_and_one_without_advantage_win_the_ball() {
        // Given
        final Player playerA = new Player(A, true, Score.FORTY);
        final Player playerB = new Player(B, false, Score.FORTY);
        final Game game = new Game(playerA, playerB);
        game.changeStatus(DeuceStatus.ofInstance(game));
        final Round round = new Round(B);
        // When
        objectUnderTest.visit(game, round);
        // Then
        assertThat(game.getStatus()).isEqualTo(DeuceStatus.ofInstance(game));
        assertThat(playerA.isAdvantaged()).isFalse();
        assertThat(playerB.isAdvantaged()).isFalse();
    }
}
