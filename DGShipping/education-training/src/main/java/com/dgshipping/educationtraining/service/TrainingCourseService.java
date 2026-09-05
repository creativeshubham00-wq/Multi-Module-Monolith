package com.dgshipping.educationtraining.service;

import com.dgshipping.educationtraining.dto.TrainingCourseRequest;
import com.dgshipping.educationtraining.dto.TrainingCourseResponse;

import java.util.List;

public interface TrainingCourseService {

    TrainingCourseResponse create(TrainingCourseRequest request);

    List<TrainingCourseResponse> getAll();

    TrainingCourseResponse getById(Long id);

    TrainingCourseResponse update(Long id, TrainingCourseRequest request);

    void delete(Long id);
}
