package com.yuehu.jobs.kata.config;

import com.yuehu.jobs.kata.domain.Game;
import com.yuehu.jobs.kata.domain.Player;
import com.yuehu.jobs.kata.domain.scoringsystem.TennisScoringRuleVisitor;
import com.yuehu.jobs.kata.service.printer.ConsoleResultPrinter;
import com.yuehu.jobs.kata.service.printer.ResultPrinter;
import com.yuehu.jobs.kata.service.reader.GameStringReader;
import com.yuehu.jobs.kata.service.scoreservice.TennisScoreService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.yuehu.jobs.kata.constant.PlayerConstants.A;
import static com.yuehu.jobs.kata.constant.PlayerConstants.B;

@Configuration
public class TennisScoreComputerConfig {
    @Bean
    GameStringReader gameStringReader() {
        return new GameStringReader();
    }

    @Bean
    ConsoleResultPrinter consoleResultPrinter() {
        return new ConsoleResultPrinter();
    }

    @Bean
    TennisScoringRuleVisitor tennisScoringSystemVisitor() {
        return new TennisScoringRuleVisitor();
    }

    @Bean
    Game game() {
        return new Game(new Player(A), new Player(B));
    }

    @Bean
    TennisScoreService tennisScoreService(
            final Game game,
            final TennisScoringRuleVisitor tennisScoringSystemVisitor,
            final ResultPrinter resultPrinter
    ) {
        return new TennisScoreService(game, tennisScoringSystemVisitor, resultPrinter);
    }
}
