package com.byteclub.kdmc.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class InvalidCredentials extends RuntimeException{
    public InvalidCredentials(String msg)
    {
        super(msg);
    }
}
