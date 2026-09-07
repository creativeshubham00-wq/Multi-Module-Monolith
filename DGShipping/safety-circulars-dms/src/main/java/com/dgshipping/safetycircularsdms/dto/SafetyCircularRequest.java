package com.dgshipping.safetycircularsdms.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

import lombok.Data;

@Data
public class SafetyCircularRequest {

    @NotBlank(message = "circularNumber is required")
    private String circularNumber;

    @NotBlank(message = "title is required")
    private String title;

    @NotNull(message = "issueDate is required")
    private LocalDate issueDate;

    @NotBlank(message = "category is required")
    private String category;

}