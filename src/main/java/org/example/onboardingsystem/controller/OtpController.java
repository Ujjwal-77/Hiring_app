package org.example.onboardingsystem.controller;

import jakarta.mail.MessagingException;
import org.example.onboardingsystem.service.OtpService;
import org.example.onboardingsystem.util.EmailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/otp")
public class OtpController {

    @Autowired
    private OtpService otpService;

    @Autowired
    private EmailUtils emailUtil;

    @PostMapping("/send")
    public ResponseEntity<String> sendOtp(@RequestParam String email) throws MessagingException {
        String otp = otpService.generateOtp(email);
        emailUtil.sendEmail(email, "Your OTP Code", "Your OTP is: " + otp);
        return ResponseEntity.ok("OTP sent to email.");
    }

    @PostMapping("/verify")
    public ResponseEntity<String> verifyOtp(@RequestParam String email, @RequestParam String otp) {
        if (otpService.verifyOtp(email, otp)) {
            return ResponseEntity.ok("OTP verified.");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid OTP.");
    }
}