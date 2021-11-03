package com.khazalcodes.exceptions;

public class NonExistantActionException extends Exception{
    public NonExistantActionException(String exceptionMessage) {
        super(exceptionMessage);
    }
}
