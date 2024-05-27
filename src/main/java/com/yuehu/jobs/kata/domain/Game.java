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

import com.yuehu.jobs.kata.domain.gamestatus.StartStatus;
import com.yuehu.jobs.kata.domain.gamestatus.Status;
import com.yuehu.jobs.kata.domain.scoringsystem.ScoringRuleAcceptable;
import com.yuehu.jobs.kata.domain.scoringsystem.ScoringRuleVisitor;
import lombok.Getter;

@Getter
public class Game implements ScoringRuleAcceptable {

    private final Player playerA;

    private final Player playerB;

    private Status status;

    public Game(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
        this.status = StartStatus.ofInstance(this);
    }

    @Override
    public void accept(final Round round, final ScoringRuleVisitor scoringRuleVisitor) {
        scoringRuleVisitor.visit(this, round);
    }

    public void changeStatus(final Status status) {
        this.status = status;
    }

}
