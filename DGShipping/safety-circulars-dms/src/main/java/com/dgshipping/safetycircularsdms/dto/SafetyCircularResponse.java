package com.dgshipping.safetycircularsdms.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class SafetyCircularResponse {

    private Long id;
    private String circularNumber;
    private String title;
    private LocalDate issueDate;
    private String category;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}