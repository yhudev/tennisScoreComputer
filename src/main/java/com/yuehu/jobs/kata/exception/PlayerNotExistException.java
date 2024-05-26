package com.yuehu.jobs.kata.exception;

public class PlayerNotExistException extends RuntimeException {

    public PlayerNotExistException(String playerId) {
        super("Player " + playerId + " does not exist.");
    }
}
