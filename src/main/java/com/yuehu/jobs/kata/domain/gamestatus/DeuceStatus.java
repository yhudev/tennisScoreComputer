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

package com.yuehu.jobs.kata.domain.gamestatus;

import com.yuehu.jobs.kata.domain.Game;
import com.yuehu.jobs.kata.domain.Player;
import lombok.EqualsAndHashCode;

/**
 * Deuce status.
 * - Game is in deuce.
 * - It can change to EndStatus.
 */
@EqualsAndHashCode(callSuper = true)
public final class DeuceStatus extends Status {

    public DeuceStatus(Game game) {
        super(game);
    }

    public static Status ofInstance(final Game game) {
        return new DeuceStatus(game);
    }

    @Override
    public void winBall(String winnerId) {
        Player ballWinner = findById(winnerId, game.getPlayerA(), game.getPlayerB());
        if (!game.getPlayerA().isAdvantaged() && !game.getPlayerB().isAdvantaged()) {
            ballWinner.winAdvantaged();
        } else if (ballWinner.isAdvantaged()) {
            game.changeStatus(EndStatus.ofInstance(game, ballWinner.getId()));
        } else {
            game.getPlayerA().loseAdvantaged();
            game.getPlayerB().loseAdvantaged();
        }
    }
}
