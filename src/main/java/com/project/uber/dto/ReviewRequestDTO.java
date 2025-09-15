package com.project.uber.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Data;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Data
public class ReviewRequestDTO {


    private Double rating;

    @NotBlank(message = "Content cannot be blank")
    private String content;

    @NotNull(message="booking id cannot be null")
    private Long bookingId;
}
