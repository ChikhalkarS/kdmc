package com.byteclub.kdmc.dto;


import com.byteclub.kdmc.model.Address;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentResponseDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String dateOfBirth;
    private String gender;
    @OneToOne
    private Address address;
}
