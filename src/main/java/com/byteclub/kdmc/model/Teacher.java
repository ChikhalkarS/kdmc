package com.byteclub.kdmc.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Teacher extends BaseModel{
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String dateOfBirth;
    private String gender;
    private String qualification;
    private String specialization;
    private String experience;
    private String designation;
    private String department;
    private String joiningDate;
    private String contractType;
    private String contractStartDate;
    private String contractEndDate;
    private String nationality;
    private String ethnicity;
    private String religion;
    private String language;
    private String hobbies;
    private String achievements;
    private String interests;
    private String certification;
    private String coursesTaught;
}
