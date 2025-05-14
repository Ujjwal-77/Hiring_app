package org.example.onboardingsystem.controller;

import org.example.onboardingsystem.dto.CandidateDTO;
import org.example.onboardingsystem.entity.Candidate;
import org.example.onboardingsystem.entity.Status;
import org.example.onboardingsystem.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @GetMapping("/hired")
    public List<Candidate> getAllHiredCandidates() {
        return (List<Candidate>) candidateService.getHiredCandidates();
    }

    @GetMapping("/{id}")
    public Candidate getCandidate(@PathVariable Long id) {
        return candidateService.getCandidateById(id);
    }

    @PostMapping("/{id}/status")
    public String updateCandidateStatus(@PathVariable Long id, @RequestParam String status) {
        Status candidateStatus = Status.valueOf(status.toUpperCase());
        candidateService.updateStatus(id, candidateStatus);
        return "Candidate status updated to " + status;
    }

    @PostMapping
    public Candidate createCandidate(@RequestBody CandidateDTO candidateDTO) {
        return candidateService.createCandidate(candidateDTO);
    }
}
