package com.byteclub.kdmc.service;

import com.byteclub.kdmc.dto.StudentRequestDTO;
import com.byteclub.kdmc.dto.StudentResponseDTO;
import com.byteclub.kdmc.model.Student;
import com.byteclub.kdmc.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import static com.byteclub.kdmc.mapper.StudentMapper.mapStudentDtoToStudent;
import static com.byteclub.kdmc.mapper.StudentMapper.mapStudentToResponse;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Optional<Student> findStudentById(UUID id){
        return studentRepository.findById(id);
    }

    public StudentResponseDTO save(StudentRequestDTO studentRequestDTO) {


       Student student= studentRepository.save(mapStudentDtoToStudent(studentRequestDTO));
       return mapStudentToResponse(student);

    }
}
