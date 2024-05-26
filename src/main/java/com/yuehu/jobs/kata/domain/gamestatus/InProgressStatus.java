package com.yuehu.jobs.kata.domain.gamestatus;

import com.yuehu.jobs.kata.domain.Game;
import com.yuehu.jobs.kata.domain.Player;
import com.yuehu.jobs.kata.enums.Score;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
public final class InProgressStatus extends Status {

    public InProgressStatus(Game game) {
        super(game);
    }

    public static Status ofInstance(Game game) {
        return new InProgressStatus(game);
    }

    @Override
    public void winBall(String winnerId) {
        Player ballWinner = findById(winnerId, game.getPlayerA(), game.getPlayerB());
        if (Score.FORTY.equals(game.getPlayerA().getScore()) && Score.FORTY.equals(game.getPlayerB().getScore())) {
            ballWinner.winAdvantaged();
            game.changeStatus(DeuceStatus.ofInstance(game));
        } else if (Score.FORTY.equals(ballWinner.getScore())) {
            game.changeStatus(EndStatus.ofInstance(game, ballWinner.getId()));
        } else {
            ballWinner.increaseScore();
            game.changeStatus(InProgressStatus.ofInstance(game));
        }
    }
}
