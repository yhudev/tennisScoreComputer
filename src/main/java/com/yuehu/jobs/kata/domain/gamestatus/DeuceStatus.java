package com.yuehu.jobs.kata.domain.gamestatus;

import com.yuehu.jobs.kata.domain.Game;
import com.yuehu.jobs.kata.domain.Player;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
public final class DeuceStatus extends Status {

    public DeuceStatus(Game game) {
        super(game);
    }

    public static Status ofInstance(final Game game) {
        return new DeuceStatus(game);
    }

    @Override
    public void winBall(String winnerId) {
        Player ballWinner = findById(winnerId, game.getPlayerA(), game.getPlayerB());
        if (!game.getPlayerA().isAdvantaged() && !game.getPlayerB().isAdvantaged()) {
            ballWinner.winAdvantaged();
        } else if (ballWinner.isAdvantaged()) {
            game.changeStatus(EndStatus.ofInstance(game, ballWinner.getId()));
        } else {
            game.getPlayerA().loseAdvantaged();
            game.getPlayerB().loseAdvantaged();
        }
    }
}
