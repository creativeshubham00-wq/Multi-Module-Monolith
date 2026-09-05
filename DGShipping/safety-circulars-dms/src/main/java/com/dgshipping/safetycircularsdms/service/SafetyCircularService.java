package com.dgshipping.safetycircularsdms.service;

import com.dgshipping.safetycircularsdms.dto.SafetyCircularRequest;
import com.dgshipping.safetycircularsdms.dto.SafetyCircularResponse;

import java.util.List;

public interface SafetyCircularService {

    SafetyCircularResponse create(SafetyCircularRequest request);

    List<SafetyCircularResponse> getAll();

    SafetyCircularResponse getById(Long id);

    SafetyCircularResponse update(Long id, SafetyCircularRequest request);

    void delete(Long id);
}
