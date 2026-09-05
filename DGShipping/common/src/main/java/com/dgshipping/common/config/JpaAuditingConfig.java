package com.dgshipping.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Enables @CreatedDate / @LastModifiedDate handling on BaseEntity.
 * Picked up automatically by any module that component-scans com.dgshipping.common.
 */
@Configuration
@EnableJpaAuditing
public class JpaAuditingConfig {
}
