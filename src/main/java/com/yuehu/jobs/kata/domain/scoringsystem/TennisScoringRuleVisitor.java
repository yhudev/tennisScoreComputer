package com.yuehu.jobs.kata.domain.scoringsystem;

import com.yuehu.jobs.kata.domain.Game;
import com.yuehu.jobs.kata.domain.Round;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TennisScoringRuleVisitor implements ScoringRuleVisitor {

    @Override
    public void visit(Game game, Round round) {
        game.getStatus().winBall(round.ballWinnerId());
    }
}
