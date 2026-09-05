package com.dgshipping.educationtraining.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public class TrainingCourseRequest {

    @NotBlank(message = "courseName is required")
    private String courseName;

    @NotBlank(message = "category is required")
    private String category;

    @NotNull(message = "durationDays is required")
    @Positive(message = "durationDays must be positive")
    private Integer durationDays;

    @NotNull(message = "startDate is required")
    private LocalDate startDate;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getDurationDays() {
        return durationDays;
    }

    public void setDurationDays(Integer durationDays) {
        this.durationDays = durationDays;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}
