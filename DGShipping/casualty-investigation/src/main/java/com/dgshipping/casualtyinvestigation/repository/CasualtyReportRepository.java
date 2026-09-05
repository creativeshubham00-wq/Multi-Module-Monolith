package com.dgshipping.casualtyinvestigation.repository;

import com.dgshipping.casualtyinvestigation.entity.CasualtyReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CasualtyReportRepository extends JpaRepository<CasualtyReport, Long> {
}
