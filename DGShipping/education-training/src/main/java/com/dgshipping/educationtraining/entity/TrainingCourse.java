package com.dgshipping.educationtraining.entity;

import com.dgshipping.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "training_courses")
public class TrainingCourse extends BaseEntity {

    @Column(nullable = false)
    private String courseName;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private Integer durationDays;

    @Column(nullable = false)
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
