package com.byteclub.kdmc.service;

import com.byteclub.kdmc.dto.LoginDTO;
import com.byteclub.kdmc.dto.SignUpDTO;
import com.byteclub.kdmc.dto.StudentResponseDTO;
import com.byteclub.kdmc.exception.InvalidCredentials;
import com.byteclub.kdmc.exception.ResourceNotFoundException;
import com.byteclub.kdmc.exception.UserExistsInSystem;
import com.byteclub.kdmc.mapper.StudentMapper;
import com.byteclub.kdmc.model.Session;
import com.byteclub.kdmc.model.SessionStatus;
import com.byteclub.kdmc.model.Student;
import com.byteclub.kdmc.repository.SessionRepository;
import com.byteclub.kdmc.repository.StudentRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMapAdapter;

import java.util.Date;
import java.util.HashMap;
import java.util.Optional;

@Service
public class AuthService {
    private final StudentRepository studentRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final SessionRepository sessionRepository;

    public AuthService(StudentRepository studentRepository, BCryptPasswordEncoder bCryptPasswordEncoder, SessionRepository sessionRepository) {
        this.studentRepository = studentRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.sessionRepository = sessionRepository;
    }

    public Object signUp(SignUpDTO signupDTO) {
        String userType = signupDTO.getUserType();

        Optional<Student> existingStudent = studentRepository.findByEmail(signupDTO.getEmail());
        if (existingStudent.isPresent()) {
            throw new UserExistsInSystem("User with email " + signupDTO.getEmail() + " already exists in system");
        } else {
            Student student = new Student();
            student.setEmail(signupDTO.getEmail());
            student.setPassword(bCryptPasswordEncoder.encode(signupDTO.getPassword()));
            return studentRepository.save(student);
        }
    }

    public ResponseEntity<StudentResponseDTO> login(LoginDTO loginDTO) {
        Optional<Student> student = studentRepository.findByEmail(loginDTO.getEmail());
        if (student.isEmpty()) {
            throw new ResourceNotFoundException(
                    "User with email" + loginDTO.getEmail() + "does not exits in system. Please login");
        }
        if (!bCryptPasswordEncoder.matches(loginDTO.getPassword(), student.get().getPassword())) {
            throw new InvalidCredentials("Invalid Credentials");
        }
        //create a session
        String token = createSession(student);

        MultiValueMapAdapter<String, String> headers = new MultiValueMapAdapter<>(new HashMap<>());
        headers.add(HttpHeaders.SET_COOKIE, token);

        StudentResponseDTO studentResponseDTO = StudentMapper.mapStudentToResponse(student.get());
        return new ResponseEntity<>(studentResponseDTO, headers, HttpStatus.OK);
    }

    private String createSession(Optional<Student> student) {
        String token = RandomStringUtils.randomAlphanumeric(40);
        Session session = new Session(token, new Date(), new Date(), student.get(), SessionStatus.ACTIVE);

        sessionRepository.save(session);

        return token;
    }

}
