package com.byteclub.kdmc.controller;

import com.byteclub.kdmc.dto.LoginDTO;
import com.byteclub.kdmc.dto.SignUpDTO;
import com.byteclub.kdmc.dto.StudentResponseDTO;
import com.byteclub.kdmc.mapper.StudentMapper;
import com.byteclub.kdmc.model.Student;
import com.byteclub.kdmc.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/student/")
public class AuthorizationController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<StudentResponseDTO> signUp(@RequestBody SignUpDTO signupDTO) {
        Object user = authService.signUp(signupDTO);

        return ResponseEntity.ok(StudentMapper.mapStudentToResponse((Student) user));
    }

    @PostMapping("/login")
    public ResponseEntity<StudentResponseDTO> login(@RequestBody LoginDTO loginDTO)
    {
        return authService.login(loginDTO);
    }

    @GetMapping("/logout/{userId}")
    public ResponseEntity<Void> logout(@PathVariable String userId,@RequestHeader("token") String token)
    {
        return authService.logout(token);
    }
}
