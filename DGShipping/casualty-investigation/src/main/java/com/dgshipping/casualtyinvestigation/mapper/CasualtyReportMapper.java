package com.dgshipping.casualtyinvestigation.mapper;

import com.dgshipping.casualtyinvestigation.dto.CasualtyReportRequest;
import com.dgshipping.casualtyinvestigation.dto.CasualtyReportResponse;
import com.dgshipping.casualtyinvestigation.entity.CasualtyReport;
import org.springframework.stereotype.Component;

@Component
public class CasualtyReportMapper {

    public CasualtyReport toEntity(CasualtyReportRequest request) {
        CasualtyReport entity = new CasualtyReport();
        entity.setVesselName(request.getVesselName());
        entity.setIncidentDate(request.getIncidentDate());
        entity.setDescription(request.getDescription());
        return entity;
    }

    public CasualtyReportResponse toResponse(CasualtyReport entity) {
        CasualtyReportResponse response = new CasualtyReportResponse();
        response.setId(entity.getId());
        response.setVesselName(entity.getVesselName());
        response.setIncidentDate(entity.getIncidentDate());
        response.setDescription(entity.getDescription());
        response.setStatus(entity.getStatus());
        response.setCreatedAt(entity.getCreatedAt());
        response.setUpdatedAt(entity.getUpdatedAt());
        return response;
    }
}
