package com.byteclub.kdmc.exception;

public class UserExistsInSystem extends RuntimeException{
    public UserExistsInSystem(String msg) {
        super(msg);
    }

}
