package org.example.onboardingsystem.service;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class OtpService {
    private Map<String, String> otpMap = new HashMap<>();

    public String generateOtp(String email) {
        String otp = String.format("%06d", new Random().nextInt(999999));
        otpMap.put(email, otp);
        return otp;
    }

    public boolean verifyOtp(String email, String otp) {
        return otp.equals(otpMap.get(email));
    }
}