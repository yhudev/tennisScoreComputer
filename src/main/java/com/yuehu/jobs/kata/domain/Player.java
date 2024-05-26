package com.yuehu.jobs.kata.domain;

import com.yuehu.jobs.kata.enums.Score;
import lombok.Getter;

@Getter
public class Player {

    private final String id;

    private boolean advantaged;

    private Score score;

    public Player(String id) {
        this.id = id;
        this.score = Score.ZERO;
        this.advantaged = false;
    }

    protected Player(String id, boolean advantaged, Score score) {
        this.id = id;
        this.advantaged = advantaged;
        this.score = score;
    }

    public void increaseScore() {
        this.score = score.increase();
    }

    public void winAdvantaged() {
        this.advantaged = true;
    }

    public void loseAdvantaged() {
        this.advantaged = false;
    }
}
