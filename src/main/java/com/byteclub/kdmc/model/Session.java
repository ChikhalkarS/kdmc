package com.byteclub.kdmc.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Session extends BaseModel {
    private String token;
    private Date expiringAt;
    private Date loginAt;
    @ManyToOne
    private Student student;
    @Enumerated(EnumType.ORDINAL)
    private SessionStatus sessionStatus;
}