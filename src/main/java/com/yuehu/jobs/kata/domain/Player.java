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

import com.yuehu.jobs.kata.enums.Score;
import lombok.Getter;

@Getter
public class Player {

    private final String id;

    private boolean advantaged;

    private Score score;

    public Player(String id) {
        this.id = id;
        this.score = Score.ZERO;
        this.advantaged = false;
    }

    protected Player(String id, boolean advantaged, Score score) {
        this.id = id;
        this.advantaged = advantaged;
        this.score = score;
    }

    public void increaseScore() {
        this.score = score.increase();
    }

    public void winAdvantaged() {
        this.advantaged = true;
    }

    public void loseAdvantaged() {
        this.advantaged = false;
    }
}
