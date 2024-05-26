package com.yuehu.jobs.kata.domain.scoringsystem;

import com.yuehu.jobs.kata.domain.Game;
import com.yuehu.jobs.kata.domain.Round;

public interface ScoringRuleVisitor {
    void visit(final Game game, final Round round);
}
