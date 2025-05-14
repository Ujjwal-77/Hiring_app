package org.example.onboardingsystem.service;

import org.example.onboardingsystem.dto.CandidateDTO;
import org.example.onboardingsystem.entity.Candidate;
import org.example.onboardingsystem.entity.Status;
import org.example.onboardingsystem.exception.CandidateNotFoundException;
import org.example.onboardingsystem.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    public Iterable<Candidate> getHiredCandidates() {
        return candidateRepository.findAll();
    }

    public Candidate getCandidateById(Long id) {
        return candidateRepository.findById(id)
                .orElseThrow(() -> new CandidateNotFoundException("Candidate not found with id: " + id));
    }

    public Candidate updateStatus(Long id, Status status) {
        Candidate candidate = candidateRepository.findById(id)
                .orElseThrow(() -> new CandidateNotFoundException("Candidate not found with id: " + id));
        candidate.setStatus(status);
        return candidateRepository.save(candidate);
    }

    public Candidate createCandidate(CandidateDTO candidateDTO) {
        Candidate candidate = new Candidate();
        candidate.setFirstName(candidateDTO.getFirstName());
        candidate.setLastName(candidateDTO.getLastName());
        candidate.setEmail(candidateDTO.getEmail());
        candidate.setStatus(candidateDTO.getStatus());
        return candidateRepository.save(candidate);
    }
}
