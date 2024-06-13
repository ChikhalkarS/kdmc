package com.byteclub.kdmc.controller;

import com.byteclub.kdmc.dto.StudentRequestDTO;
import com.byteclub.kdmc.dto.StudentResponseDTO;
import com.byteclub.kdmc.exception.ResourceNotFoundException;
import com.byteclub.kdmc.model.Student;
import com.byteclub.kdmc.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/v1")
public class StudentContoller {
    private static final Logger log = LoggerFactory.getLogger(StudentContoller.class);
    private final StudentService studentService;

    public StudentContoller(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student/{Id}")
    public ResponseEntity<Student> getStudentById(@PathVariable String Id) {
        log.info("Inside getStudentby ID: {}", Id);
        UUID uuid = UUID.fromString(Id);
        Optional<Student> student = studentService.findStudentById(uuid);
       if(student.isPresent())
       {
           return new ResponseEntity<>(student.get(),HttpStatus.OK);
       }
       else {
           throw new ResourceNotFoundException("Student with Id "+uuid+" is not present in system");
       }

    }

    @PostMapping("/student")
    public ResponseEntity<StudentResponseDTO> saveStudent(@RequestBody StudentRequestDTO studentRequestDTO) {
        log.info("Inside saveStudent: {}", studentRequestDTO.toString());
        StudentResponseDTO student = studentService.save(studentRequestDTO);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/students")
    public ResponseEntity<List<StudentResponseDTO>> getAllStudents()
    {
        log.info("Inside getAllStudents");
        return ResponseEntity.ok(studentService.findAllStudent());
    }
}
