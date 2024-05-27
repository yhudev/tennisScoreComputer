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

package com.yuehu.jobs.kata.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Score {
    ZERO(0),
    FIFTEEN(15),
    THIRTY(30),
    FORTY(40);

    private final int points;

    public Score increase() {
        switch (this) {
            case ZERO -> {
                return FIFTEEN;
            }
            case FIFTEEN -> {
                return THIRTY;
            }
            case THIRTY -> {
                return FORTY;
            }
            default -> {
                return this;
            }
        }
    }

    @Override
    public String toString() {
        return String.valueOf(points);
    }
}
