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

package com.yuehu.jobs.kata.service.reader;

import com.yuehu.jobs.kata.domain.Round;

import java.util.List;

/**
 * Interface to provide a reader to read game information.
 *
 * @author Yue HU
 */
public interface GameReader {
    /**
     * Read a game input and translate to rounds information.
     *
     * @param input game input
     * @return rounds information
     */
    List<Round> read(String input);
}
