package com.yuehu.jobs.kata.domain.gamestatus;

import com.yuehu.jobs.kata.domain.Game;
import com.yuehu.jobs.kata.domain.Player;
import com.yuehu.jobs.kata.exception.PlayerNotExistException;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EqualsAndHashCode
public abstract class Status {

    protected final Game game;

    public abstract void winBall(String winnerId);

    public String statusMessage() {
        return "Player " + game.getPlayerA().getId() + " : " + game.getPlayerA().getScore() + " / Player " + game.getPlayerB().getId() + " : " + game.getPlayerB().getScore();
    }

    protected Player findById(String playerId, Player playerA, Player playerB) {
        if (playerId.equals(playerA.getId())) {
            return playerA;
        }
        if (playerId.equals(playerB.getId())) {
            return playerB;
        }
        throw new PlayerNotExistException(playerId);
    }
}
