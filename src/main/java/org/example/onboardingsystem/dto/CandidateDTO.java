package org.example.onboardingsystem.dto;

import org.example.onboardingsystem.entity.Status;
import lombok.Data;

@Data
public class CandidateDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Status status;
}
