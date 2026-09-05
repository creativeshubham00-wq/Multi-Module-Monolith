package com.dgshipping.safetycircularsdms.service.impl;

import com.dgshipping.common.exception.ResourceNotFoundException;
import com.dgshipping.safetycircularsdms.dto.SafetyCircularRequest;
import com.dgshipping.safetycircularsdms.dto.SafetyCircularResponse;
import com.dgshipping.safetycircularsdms.entity.SafetyCircular;
import com.dgshipping.safetycircularsdms.mapper.SafetyCircularMapper;
import com.dgshipping.safetycircularsdms.repository.SafetyCircularRepository;
import com.dgshipping.safetycircularsdms.service.SafetyCircularService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SafetyCircularServiceImpl implements SafetyCircularService {

    private final SafetyCircularRepository repository;
    private final SafetyCircularMapper mapper;

    public SafetyCircularServiceImpl(SafetyCircularRepository repository, SafetyCircularMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public SafetyCircularResponse create(SafetyCircularRequest request) {
        SafetyCircular saved = repository.save(mapper.toEntity(request));
        return mapper.toResponse(saved);
    }

    @Override
    public List<SafetyCircularResponse> getAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    @Override
    public SafetyCircularResponse getById(Long id) {
        return mapper.toResponse(findEntityOrThrow(id));
    }

    @Override
    public SafetyCircularResponse update(Long id, SafetyCircularRequest request) {
        SafetyCircular existing = findEntityOrThrow(id);
        existing.setCircularNumber(request.getCircularNumber());
        existing.setTitle(request.getTitle());
        existing.setIssueDate(request.getIssueDate());
        existing.setCategory(request.getCategory());
        return mapper.toResponse(repository.save(existing));
    }

    @Override
    public void delete(Long id) {
        repository.delete(findEntityOrThrow(id));
    }

    private SafetyCircular findEntityOrThrow(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Safety circular not found with id: " + id));
    }
}
