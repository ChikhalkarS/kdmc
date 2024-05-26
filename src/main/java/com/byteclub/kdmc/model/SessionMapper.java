package com.byteclub.kdmc.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Date;


public class SessionMapper {
    public static Session mapSessionDTOToSession(Session session){

        String token = RandomStringUtils.randomAlphabetic(40);

        return Session.builder()
                .sessionStatus(session.getSessionStatus())
                .token(token)
                .loginAt(new Date())
                .build();
    }
}
