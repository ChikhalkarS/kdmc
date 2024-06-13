package com.byteclub.kdmc.mapper;

import com.byteclub.kdmc.dto.StudentRequestDTO;
import com.byteclub.kdmc.dto.StudentResponseDTO;
import com.byteclub.kdmc.model.Address;
import com.byteclub.kdmc.model.Student;
import lombok.experimental.UtilityClass;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class StudentMapper {
    public static Student mapStudentDtoToStudent(StudentRequestDTO studentRequestDTO) {
        Student student = new Student();
        Address address = new Address();
        address.setStreet1(studentRequestDTO.getAddress().getStreet1());
        address.setStreet2(studentRequestDTO.getAddress().getStreet2());
        address.setCity(studentRequestDTO.getAddress().getCity());
        address.setState(studentRequestDTO.getAddress().getState());
        address.setCountry(studentRequestDTO.getAddress().getCountry());
        address.setPostalCode(studentRequestDTO.getAddress().getPostalCode());
        student.setFirstName(studentRequestDTO.getFirstName());
        student.setLastName(studentRequestDTO.getLastName());
        student.setEmail(studentRequestDTO.getEmail());
        student.setPhoneNumber(studentRequestDTO.getPhoneNumber());
        student.setGender(studentRequestDTO.getGender());
        student.setDateOfBirth(studentRequestDTO.getDateOfBirth());
        student.setAddress(address);

        return student;
    }


    public static StudentResponseDTO mapStudentToResponse(Student student) {
        StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
        studentResponseDTO.setEmail(student.getEmail());
        studentResponseDTO.setGender(student.getGender());
        studentResponseDTO.setFirstName(student.getFirstName());
        studentResponseDTO.setLastName(student.getLastName());
        studentResponseDTO.setDateOfBirth(student.getDateOfBirth());
        studentResponseDTO.setPhoneNumber(student.getPhoneNumber());
        studentResponseDTO.setAddress(student.getAddress());
        return studentResponseDTO;

    }

    public static List<StudentResponseDTO> mapStudentListToStudentResponseList(List<Student> studentsList)
    {
      return studentsList.stream().map(StudentMapper::mapStudentToResponse).toList();
    }

}
