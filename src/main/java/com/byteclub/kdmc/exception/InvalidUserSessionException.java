package com.byteclub.kdmc.exception;

public class InvalidUserSessionException extends RuntimeException{
    public InvalidUserSessionException(String msg)
    {
        super(msg);
    }
}
