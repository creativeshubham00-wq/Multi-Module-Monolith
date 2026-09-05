package com.dgshipping.casualtyinvestigation.service;

import com.dgshipping.casualtyinvestigation.dto.CasualtyReportRequest;
import com.dgshipping.casualtyinvestigation.dto.CasualtyReportResponse;

import java.util.List;

public interface CasualtyReportService {

    CasualtyReportResponse create(CasualtyReportRequest request);

    List<CasualtyReportResponse> getAll();

    CasualtyReportResponse getById(Long id);

    CasualtyReportResponse update(Long id, CasualtyReportRequest request);

    void delete(Long id);
}
