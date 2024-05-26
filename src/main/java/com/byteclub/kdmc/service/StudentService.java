package com.byteclub.kdmc.service;

import com.byteclub.kdmc.dto.StudentRequestDTO;
import com.byteclub.kdmc.dto.StudentResponseDTO;
import com.byteclub.kdmc.model.Address;
import com.byteclub.kdmc.model.Student;
import com.byteclub.kdmc.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.byteclub.kdmc.mapper.StudentMapper.*;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Optional<Student> findStudentById(UUID id) {
        return studentRepository.findById(id);
    }

    public StudentResponseDTO save(StudentRequestDTO studentRequestDTO) {

        Optional<Student> existingStudent = studentRepository.findByEmail(studentRequestDTO.getEmail());
        if (existingStudent.isPresent()) {
            Student student = existingStudent.get();
            System.out.print("Updating existing Student");
            Address address = new Address();
            address.setStreet1(studentRequestDTO.getAddress().getStreet1());
            address.setStreet2(studentRequestDTO.getAddress().getStreet2());
            address.setCity(studentRequestDTO.getAddress().getCity());
            address.setState(studentRequestDTO.getAddress().getState());
            address.setCountry(studentRequestDTO.getAddress().getCountry());
            address.setPostalCode(studentRequestDTO.getAddress().getPostalCode());
            student.setFirstName(studentRequestDTO.getFirstName());
            student.setLastName(studentRequestDTO.getLastName());
            student.setPhoneNumber(studentRequestDTO.getPhoneNumber());
            student.setGender(studentRequestDTO.getGender());
            student.setDateOfBirth(studentRequestDTO.getDateOfBirth());
            student.setAddress(address);
            return mapStudentToResponse(student);

        }

        Student student = studentRepository.save(mapStudentDtoToStudent(studentRequestDTO));
        return mapStudentToResponse(student);

    }

    public List<StudentResponseDTO> findAllStudent() {

        List<Student> studentList = studentRepository.findAll();
        return mapStudentListToStudentResponseList(studentList);


    }
}
