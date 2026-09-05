package com.dgshipping.casualtyinvestigation.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class CasualtyReportRequest {

    @NotBlank(message = "vesselName is required")
    private String vesselName;

    @NotNull(message = "incidentDate is required")
    private LocalDate incidentDate;

    @NotBlank(message = "description is required")
    private String description;

    public String getVesselName() {
        return vesselName;
    }

    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
    }

    public LocalDate getIncidentDate() {
        return incidentDate;
    }

    public void setIncidentDate(LocalDate incidentDate) {
        this.incidentDate = incidentDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
