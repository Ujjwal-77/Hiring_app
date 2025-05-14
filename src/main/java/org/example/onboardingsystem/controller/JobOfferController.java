package org.example.onboardingsystem.controller;

import org.example.onboardingsystem.service.JobOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/job-offers")
public class JobOfferController {

    @Autowired
    private JobOfferService jobOfferService;

    @PostMapping("/{id}/send")
    public String sendJobOffer(@PathVariable Long id) {
        try {
            jobOfferService.sendJobOfferEmail(id); // Changed to sendJobOfferEmail
            return "Job offer sent successfully.";
        } catch (Exception e) {
            return "Error sending job offer: " + e.getMessage();
        }
    }
}