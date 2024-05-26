package com.yuehu.jobs.kata.service.scoreservice;

import com.yuehu.jobs.kata.domain.Game;
import com.yuehu.jobs.kata.domain.Round;
import com.yuehu.jobs.kata.domain.scoringsystem.ScoringRuleVisitor;
import com.yuehu.jobs.kata.service.printer.ResultPrinter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TennisScoreService implements ScoreService {

    private final Game game;

    private final ScoringRuleVisitor scoringRuleVisitor;

    private final ResultPrinter resultPrinter;

    public void process(List<Round> rounds) {
        for (Round round : rounds) {
            game.accept(round, scoringRuleVisitor);
            resultPrinter.printStatus(game);
        }
    }

}
