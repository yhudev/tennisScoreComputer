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
import lombok.EqualsAndHashCode;

/**
 * Start status.
 * - Game is started.
 * - It can change to InProgressStatus.
 *
 * @author Yue HU
 */
@EqualsAndHashCode(callSuper = true)
public final class StartStatus extends Status {

    public StartStatus(Game game) {
        super(game);
    }

    public static Status ofInstance(Game game) {
        return new StartStatus(game);
    }

    @Override
    public void winBall(String winnerId) {
        findById(winnerId, game.getPlayerA(), game.getPlayerB()).increaseScore();
        game.changeStatus(InProgressStatus.ofInstance(game));
    }
}
