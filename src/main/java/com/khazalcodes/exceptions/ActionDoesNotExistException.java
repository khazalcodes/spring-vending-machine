package com.khazalcodes.exceptions;

public class ActionDoesNotExistException extends Exception{
    public ActionDoesNotExistException(String exceptionMessage) {
        super(exceptionMessage);
    }
}
