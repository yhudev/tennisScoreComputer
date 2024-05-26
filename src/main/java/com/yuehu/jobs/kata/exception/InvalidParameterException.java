package com.yuehu.jobs.kata.exception;

public class InvalidParameterException extends Exception {
    public InvalidParameterException(String param) {
        super("Parameter is not valid: " + param);
    }
}
