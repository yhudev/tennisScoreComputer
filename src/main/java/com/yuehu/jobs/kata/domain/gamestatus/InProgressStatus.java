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
import com.yuehu.jobs.kata.enums.Score;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
public final class InProgressStatus extends Status {

    public InProgressStatus(Game game) {
        super(game);
    }

    public static Status ofInstance(Game game) {
        return new InProgressStatus(game);
    }

    @Override
    public void winBall(String winnerId) {
        Player ballWinner = findById(winnerId, game.getPlayerA(), game.getPlayerB());
        if (Score.FORTY.equals(game.getPlayerA().getScore()) && Score.FORTY.equals(game.getPlayerB().getScore())) {
            ballWinner.winAdvantaged();
            game.changeStatus(DeuceStatus.ofInstance(game));
        } else if (Score.FORTY.equals(ballWinner.getScore())) {
            game.changeStatus(EndStatus.ofInstance(game, ballWinner.getId()));
        } else {
            ballWinner.increaseScore();
            game.changeStatus(InProgressStatus.ofInstance(game));
        }
    }
}
