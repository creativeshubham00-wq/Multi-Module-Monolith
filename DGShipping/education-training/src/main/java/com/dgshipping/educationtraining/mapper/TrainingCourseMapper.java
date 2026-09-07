package com.dgshipping.educationtraining.mapper;

import com.dgshipping.educationtraining.dto.TrainingCourseRequest;
import com.dgshipping.educationtraining.dto.TrainingCourseResponse;
import com.dgshipping.educationtraining.entity.TrainingCourse;
import org.springframework.stereotype.Component;

@Component
public class TrainingCourseMapper {

    public TrainingCourse toEntity(TrainingCourseRequest request) {
        TrainingCourse entity = new TrainingCourse();
        entity.setCourseName(request.getCourseName());
        entity.setCategory(request.getCategory());
        entity.setDurationDays(request.getDurationDays());
        entity.setStartDate(request.getStartDate());
        return entity;
    }

    public TrainingCourseResponse toResponse(TrainingCourse entity) {
        TrainingCourseResponse response = new TrainingCourseResponse();
        response.setId(entity.getId());
        response.setCourseName(entity.getCourseName());
        response.setCategory(entity.getCategory());
        response.setDurationDays(entity.getDurationDays());
        response.setStartDate(entity.getStartDate());
        response.setCreatedAt(entity.getCreatedAt());
        response.setUpdatedAt(entity.getUpdatedAt());
        return response;
    }
}