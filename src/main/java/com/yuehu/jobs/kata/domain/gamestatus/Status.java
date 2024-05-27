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
import com.yuehu.jobs.kata.exception.PlayerNotExistException;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EqualsAndHashCode
public abstract class Status {

    protected final Game game;

    public abstract void winBall(String winnerId);

    public String statusMessage() {
        return "Player " + game.getPlayerA().getId() + " : " + game.getPlayerA().getScore() + " / Player " + game.getPlayerB().getId() + " : " + game.getPlayerB().getScore();
    }

    protected Player findById(String playerId, Player playerA, Player playerB) {
        if (playerId.equals(playerA.getId())) {
            return playerA;
        }
        if (playerId.equals(playerB.getId())) {
            return playerB;
        }
        throw new PlayerNotExistException(playerId);
    }
}
