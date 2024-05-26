package com.byteclub.kdmc.dto;

import com.byteclub.kdmc.model.SessionStatus;
import com.byteclub.kdmc.model.Student;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SessionDTO {
    private String token;
    private Date expiringAt;
    private Date loginAt;
    @ManyToOne
    private Student student;
    @Enumerated(EnumType.ORDINAL)
    private SessionStatus sessionStatus;
}

