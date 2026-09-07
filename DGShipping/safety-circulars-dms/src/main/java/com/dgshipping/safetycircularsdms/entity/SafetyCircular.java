package com.dgshipping.safetycircularsdms.entity;

import com.dgshipping.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "safety_circulars")
@Getter
@Setter
public class SafetyCircular extends BaseEntity {

    private String circularNumber;

    private String title;

    private LocalDate issueDate;

    private String category;

}