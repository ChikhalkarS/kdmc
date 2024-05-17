package com.byteclub.kdmc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "employee")
@Setter
@Getter
public class Employee extends BaseModel{
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String dateOfBirth;
    private String gender;
    private String nationality;
    private String ethnicity;
    private String religion;
    private String language;
    private String hobbies;
    private String achievements;
    private String interests;
    private String certification;
    private String joiningDate;
    private String contractType;
    private String contractStartDate;
    private String contractEndDate;
    private String typeOfEmployment;

    @OneToOne
    private Address address;
}
