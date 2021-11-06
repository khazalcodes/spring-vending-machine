package com.khazalcodes.exceptions;

/**
 * If the user does not have enough money when the code tries to vend an item, this exception will be thrown.
 * */
public class InsufficientFundsException extends Exception{
    public InsufficientFundsException(String message) { super(message); }
}
