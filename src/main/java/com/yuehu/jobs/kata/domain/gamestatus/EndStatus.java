package com.yuehu.jobs.kata.domain.gamestatus;

import com.yuehu.jobs.kata.domain.Game;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
public final class EndStatus extends Status {

    private final String winner;

    public EndStatus(Game game, String winner) {
        super(game);
        this.winner = winner;
    }

    public static Status ofInstance(final Game game, final String winner) {
        return new EndStatus(game, winner);
    }

    @Override
    public void winBall(String winnerId) {
        throw new UnsupportedOperationException("No more ball won when game ended.");
    }

    @Override
    public String statusMessage() {
        return "Player " + winner + " wins the game";
    }
}
