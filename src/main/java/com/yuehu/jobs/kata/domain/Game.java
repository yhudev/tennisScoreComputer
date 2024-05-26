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
