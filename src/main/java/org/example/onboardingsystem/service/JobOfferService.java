package org.example.onboardingsystem.service;

import org.example.onboardingsystem.entity.Candidate;
import org.example.onboardingsystem.util.EmailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;

@Service
public class JobOfferService {

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private EmailUtils emailUtils;

    public void sendJobOfferEmail(Long id) throws MessagingException, jakarta.mail.MessagingException {
        Candidate candidate = candidateService.getCandidateById(id);
        String emailBody = "Dear " + candidate.getFirstName() + ",\n\n" +
                "Congratulations! You have been selected for the position.\n\n" +
                "Best Regards,\nHR Team";
        emailUtils.sendEmail(candidate.getEmail(), "Job Offer", emailBody);
    }

    public void sendJobOffer(Long id) throws MessagingException, jakarta.mail.MessagingException {
        sendJobOfferEmail(id);
    }
}
