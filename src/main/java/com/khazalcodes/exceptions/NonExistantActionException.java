package com.khazalcodes.exceptions;

/**
 * If the user inputs a number for an action that does not exist, this exception will be thrown.
 * */
public class NonExistantActionException extends Exception{
    public NonExistantActionException(String exceptionMessage) {
        super(exceptionMessage);
    }
}
