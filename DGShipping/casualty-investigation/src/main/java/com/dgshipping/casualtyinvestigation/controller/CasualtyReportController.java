package com.dgshipping.casualtyinvestigation.controller;

import com.dgshipping.casualtyinvestigation.dto.CasualtyReportRequest;
import com.dgshipping.casualtyinvestigation.dto.CasualtyReportResponse;
import com.dgshipping.casualtyinvestigation.service.CasualtyReportService;
import com.dgshipping.common.dto.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/casualty-reports")
public class CasualtyReportController {

    private final CasualtyReportService service;

    public CasualtyReportController(CasualtyReportService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<CasualtyReportResponse> create(@Valid @RequestBody CasualtyReportRequest request) {
        return ApiResponse.success("Casualty report created", service.create(request));
    }

    @GetMapping
    public ApiResponse<List<CasualtyReportResponse>> getAll() {
        return ApiResponse.success(service.getAll());
    }

    @GetMapping("/{id}")
    public ApiResponse<CasualtyReportResponse> getById(@PathVariable Long id) {
        return ApiResponse.success(service.getById(id));
    }

    @PutMapping("/{id}")
    public ApiResponse<CasualtyReportResponse> update(@PathVariable Long id,
                                                       @Valid @RequestBody CasualtyReportRequest request) {
        return ApiResponse.success("Casualty report updated", service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ApiResponse.success("Casualty report deleted", null);
    }
}
