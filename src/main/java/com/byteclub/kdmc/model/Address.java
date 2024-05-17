package com.byteclub.kdmc.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Address extends BaseModel{
    private String street1;
    private String street2;
    private String city;
    private String state;
    private String postalCode;
    private String country;
}
