package com.dgshipping.educationtraining.service.impl;

import com.dgshipping.common.exception.ResourceNotFoundException;
import com.dgshipping.educationtraining.dto.TrainingCourseRequest;
import com.dgshipping.educationtraining.dto.TrainingCourseResponse;
import com.dgshipping.educationtraining.entity.TrainingCourse;
import com.dgshipping.educationtraining.mapper.TrainingCourseMapper;
import com.dgshipping.educationtraining.repository.TrainingCourseRepository;
import com.dgshipping.educationtraining.service.TrainingCourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingCourseServiceImpl implements TrainingCourseService {

    private final TrainingCourseRepository repository;
    private final TrainingCourseMapper mapper;

    public TrainingCourseServiceImpl(TrainingCourseRepository repository, TrainingCourseMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public TrainingCourseResponse create(TrainingCourseRequest request) {
        TrainingCourse saved = repository.save(mapper.toEntity(request));
        return mapper.toResponse(saved);
    }

    @Override
    public List<TrainingCourseResponse> getAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    @Override
    public TrainingCourseResponse getById(Long id) {
        return mapper.toResponse(findEntityOrThrow(id));
    }

    @Override
    public TrainingCourseResponse update(Long id, TrainingCourseRequest request) {
        TrainingCourse existing = findEntityOrThrow(id);
        existing.setCourseName(request.getCourseName());
        existing.setCategory(request.getCategory());
        existing.setDurationDays(request.getDurationDays());
        existing.setStartDate(request.getStartDate());
        return mapper.toResponse(repository.save(existing));
    }

    @Override
    public void delete(Long id) {
        repository.delete(findEntityOrThrow(id));
    }

    private TrainingCourse findEntityOrThrow(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Training course not found with id: " + id));
    }
}
