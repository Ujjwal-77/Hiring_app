package org.example.onboardingsystem.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody String loginRequest) {
        return ResponseEntity.ok("Login logic not yet implemented.");
    }
}