package com.project.uber.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReviewResponseDTO {
    private Long id;
    private Double rating;
    private String content;
    private Long bookingId;
}
