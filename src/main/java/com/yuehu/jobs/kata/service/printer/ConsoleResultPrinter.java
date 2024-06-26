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

package com.yuehu.jobs.kata.service.printer;

import com.yuehu.jobs.kata.domain.Game;
import lombok.extern.slf4j.Slf4j;

/**
 * Result printer for printing game output in console.
 *
 * @author Yue HU
 */
@Slf4j
public class ConsoleResultPrinter implements ResultPrinter {
    @Override
    public void printStatus(Game game) {
        log.info(game.getStatus().statusMessage());
    }
}
