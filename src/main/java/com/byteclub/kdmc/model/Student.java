package com.byteclub.kdmc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.UniqueConstraint;
import lombok.*;
import org.springframework.context.annotation.Primary;

@Entity(name = "student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Primary
public class Student extends BaseModel{
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String dateOfBirth;
    private String gender;
    private String guardianName;
    private String guardianPhoneNumber;
    private String guardianEmail;
    private String emergencyContactName;
    private String emergencyContactPhoneNumber;
    private String gradeLevel;
    private String enrollmentStatus;
    private String admissionDate;
    private String graduationDate;
    private String nationality;
    private String ethnicity;
    private String religion;
    private String language;
    private String disability;
    private String specialNeeds;
    private String medicalConditions;
    private String allergies;
    private String hobbies;
    private String achievements;
    private String interests;
    private String extracurricularActivities;
    private String transportationMethod;
    private String busRoute;
    @OneToOne
    private Address address;

}
