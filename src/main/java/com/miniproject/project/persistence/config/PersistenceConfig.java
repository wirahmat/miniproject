package com.miniproject.project.persistence.config;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.FluentConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceConfig {

	@Bean
	public FluentConfiguration reimbursementFlywayMigrationConfig() {
		return Flyway.configure().table("flyway_history")
				.locations("classpath:db/migration");
	}
}
