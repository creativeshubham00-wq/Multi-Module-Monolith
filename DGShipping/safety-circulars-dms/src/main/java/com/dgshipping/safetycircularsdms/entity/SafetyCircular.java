package com.dgshipping.safetycircularsdms.entity;

import com.dgshipping.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "safety_circulars")
public class SafetyCircular extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String circularNumber;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private LocalDate issueDate;

    @Column(nullable = false)
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
