package com.yuehu.jobs.kata.service.printer;

import com.yuehu.jobs.kata.domain.Game;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConsoleResultPrinter implements ResultPrinter {
    @Override
    public void printStatus(Game game) {
        log.info(game.getStatus().statusMessage());
    }
}
