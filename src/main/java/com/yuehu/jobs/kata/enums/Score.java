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
