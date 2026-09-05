package com.dgshipping.safetycircularsdms.repository;

import com.dgshipping.safetycircularsdms.entity.SafetyCircular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SafetyCircularRepository extends JpaRepository<SafetyCircular, Long> {
}
