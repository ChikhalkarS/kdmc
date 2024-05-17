package com.byteclub.kdmc.mapper;

import com.byteclub.kdmc.dto.StudentRequestDTO;
import com.byteclub.kdmc.dto.StudentResponseDTO;
import com.byteclub.kdmc.model.Student;
import lombok.experimental.UtilityClass;
import org.springframework.stereotype.Service;

@UtilityClass
public class StudentMapper {
    public static Student mapStudentDtoToStudent(StudentRequestDTO studentRequestDTO) {
        Student student = new Student();
        student.setFirstName(studentRequestDTO.getFirstName());
        student.setLastName(studentRequestDTO.getLastName());
        student.setEmail(studentRequestDTO.getEmail());
        student.setPhoneNumber(studentRequestDTO.getPhoneNumber());
        student.setGender(studentRequestDTO.getGender());
        student.setDateOfBirth(studentRequestDTO.getDateOfBirth());
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

        return studentResponseDTO;

    }

}
