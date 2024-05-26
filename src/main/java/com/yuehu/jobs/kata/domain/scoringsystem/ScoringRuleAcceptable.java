package com.yuehu.jobs.kata.domain.scoringsystem;

import com.yuehu.jobs.kata.domain.Round;

public interface ScoringRuleAcceptable {
    void accept(final Round round, final ScoringRuleVisitor scoringRuleVisitor);
}
