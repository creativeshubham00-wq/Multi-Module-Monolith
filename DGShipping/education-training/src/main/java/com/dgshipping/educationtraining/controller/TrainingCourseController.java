package com.dgshipping.educationtraining.controller;

import com.dgshipping.common.dto.ApiResponse;
import com.dgshipping.educationtraining.dto.TrainingCourseRequest;
import com.dgshipping.educationtraining.dto.TrainingCourseResponse;
import com.dgshipping.educationtraining.service.TrainingCourseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/training-courses")
public class TrainingCourseController {

    private final TrainingCourseService service;

    public TrainingCourseController(TrainingCourseService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<TrainingCourseResponse> create(@Valid @RequestBody TrainingCourseRequest request) {
        return ApiResponse.success("Training course created", service.create(request));
    }

    @GetMapping
    public ApiResponse<List<TrainingCourseResponse>> getAll() {
        return ApiResponse.success(service.getAll());
    }

    @GetMapping("/{id}")
    public ApiResponse<TrainingCourseResponse> getById(@PathVariable Long id) {
        return ApiResponse.success(service.getById(id));
    }

    @PutMapping("/{id}")
    public ApiResponse<TrainingCourseResponse> update(@PathVariable Long id,
                                                       @Valid @RequestBody TrainingCourseRequest request) {
        return ApiResponse.success("Training course updated", service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ApiResponse.success("Training course deleted", null);
    }
}
