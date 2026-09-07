package com.dgshipping.safetycircularsdms.mapper;

import com.dgshipping.safetycircularsdms.dto.SafetyCircularRequest;
import com.dgshipping.safetycircularsdms.dto.SafetyCircularResponse;
import com.dgshipping.safetycircularsdms.entity.SafetyCircular;
import org.springframework.stereotype.Component;

@Component
public class SafetyCircularMapper {

    public SafetyCircular toEntity(SafetyCircularRequest request) {
        SafetyCircular entity = new SafetyCircular();
        entity.setCircularNumber(request.getCircularNumber());
        entity.setTitle(request.getTitle());
        entity.setIssueDate(request.getIssueDate());
        entity.setCategory(request.getCategory());
        return entity;
    }

    public SafetyCircularResponse toResponse(SafetyCircular entity) {
        SafetyCircularResponse response = new SafetyCircularResponse();
        response.setId(entity.getId());
        response.setCircularNumber(entity.getCircularNumber());
        response.setTitle(entity.getTitle());
        response.setIssueDate(entity.getIssueDate());
        response.setCategory(entity.getCategory());
        response.setCreatedAt(entity.getCreatedAt());
        response.setUpdatedAt(entity.getUpdatedAt());
        return response;
    }
}