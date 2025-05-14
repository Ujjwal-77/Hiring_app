package org.example.onboardingsystem.listener;

import org.example.onboardingsystem.service.JobOfferService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class JobOfferListener {

    private final JobOfferService jobOfferService;

    public JobOfferListener(JobOfferService jobOfferService) {
        this.jobOfferService = jobOfferService;
    }

    @RabbitListener(queues = "jobOfferQueue")
    public void receiveJobOfferMessage(Long candidateId) {
        try {
            jobOfferService.sendJobOfferEmail(candidateId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
