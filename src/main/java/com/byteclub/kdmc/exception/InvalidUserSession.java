package com.byteclub.kdmc.exception;

public class InvalidUserSession extends RuntimeException{
    public InvalidUserSession(String msg)
    {
        super(msg);
    }
}
