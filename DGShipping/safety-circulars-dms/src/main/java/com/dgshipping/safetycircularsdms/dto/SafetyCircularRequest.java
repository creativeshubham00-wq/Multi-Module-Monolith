package com.dgshipping.safetycircularsdms.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class SafetyCircularRequest {

    @NotBlank(message = "circularNumber is required")
    private String circularNumber;

    @NotBlank(message = "title is required")
    private String title;

    @NotNull(message = "issueDate is required")
    private LocalDate issueDate;

    @NotBlank(message = "category is required")
    private String category;

    public String getCircularNumber() {
        return circularNumber;
    }

    public void setCircularNumber(String circularNumber) {
        this.circularNumber = circularNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
