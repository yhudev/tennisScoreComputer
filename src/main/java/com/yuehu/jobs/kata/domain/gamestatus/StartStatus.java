package com.yuehu.jobs.kata.domain.gamestatus;

import com.yuehu.jobs.kata.domain.Game;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public final class StartStatus extends Status {

    public StartStatus(Game game) {
        super(game);
    }

    public static Status ofInstance(Game game) {
        return new StartStatus(game);
    }

    @Override
    public void winBall(String winnerId) {
        findById(winnerId, game.getPlayerA(), game.getPlayerB()).increaseScore();
        game.changeStatus(InProgressStatus.ofInstance(game));
    }
}
