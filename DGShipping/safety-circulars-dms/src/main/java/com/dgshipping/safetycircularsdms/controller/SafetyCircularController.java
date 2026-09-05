package com.dgshipping.safetycircularsdms.controller;

import com.dgshipping.common.dto.ApiResponse;
import com.dgshipping.safetycircularsdms.dto.SafetyCircularRequest;
import com.dgshipping.safetycircularsdms.dto.SafetyCircularResponse;
import com.dgshipping.safetycircularsdms.service.SafetyCircularService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/safety-circulars")
public class SafetyCircularController {

    private final SafetyCircularService service;

    public SafetyCircularController(SafetyCircularService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<SafetyCircularResponse> create(@Valid @RequestBody SafetyCircularRequest request) {
        return ApiResponse.success("Safety circular created", service.create(request));
    }

    @GetMapping
    public ApiResponse<List<SafetyCircularResponse>> getAll() {
        return ApiResponse.success(service.getAll());
    }

    @GetMapping("/{id}")
    public ApiResponse<SafetyCircularResponse> getById(@PathVariable Long id) {
        return ApiResponse.success(service.getById(id));
    }

    @PutMapping("/{id}")
    public ApiResponse<SafetyCircularResponse> update(@PathVariable Long id,
                                                       @Valid @RequestBody SafetyCircularRequest request) {
        return ApiResponse.success("Safety circular updated", service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ApiResponse.success("Safety circular deleted", null);
    }
}
