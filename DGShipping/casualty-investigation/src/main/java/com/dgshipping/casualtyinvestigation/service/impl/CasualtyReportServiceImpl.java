package com.dgshipping.casualtyinvestigation.service.impl;

import com.dgshipping.casualtyinvestigation.dto.CasualtyReportRequest;
import com.dgshipping.casualtyinvestigation.dto.CasualtyReportResponse;
import com.dgshipping.casualtyinvestigation.entity.CasualtyReport;
import com.dgshipping.casualtyinvestigation.mapper.CasualtyReportMapper;
import com.dgshipping.casualtyinvestigation.repository.CasualtyReportRepository;
import com.dgshipping.casualtyinvestigation.service.CasualtyReportService;
import com.dgshipping.common.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CasualtyReportServiceImpl implements CasualtyReportService {

    private final CasualtyReportRepository repository;
    private final CasualtyReportMapper mapper;

    public CasualtyReportServiceImpl(CasualtyReportRepository repository, CasualtyReportMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public CasualtyReportResponse create(CasualtyReportRequest request) {
        CasualtyReport saved = repository.save(mapper.toEntity(request));
        return mapper.toResponse(saved);
    }

    @Override
    public List<CasualtyReportResponse> getAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    @Override
    public CasualtyReportResponse getById(Long id) {
        return mapper.toResponse(findEntityOrThrow(id));
    }

    @Override
    public CasualtyReportResponse update(Long id, CasualtyReportRequest request) {
        CasualtyReport existing = findEntityOrThrow(id);
        existing.setVesselName(request.getVesselName());
        existing.setIncidentDate(request.getIncidentDate());
        existing.setDescription(request.getDescription());
        return mapper.toResponse(repository.save(existing));
    }

    @Override
    public void delete(Long id) {
        repository.delete(findEntityOrThrow(id));
    }

    private CasualtyReport findEntityOrThrow(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Casualty report not found with id: " + id));
    }
}
