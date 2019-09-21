package com.bigpoint.dbtool;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.integration.spring.SpringLiquibase;

@Configuration
public class LiquibaseConfiguration {
	 @Autowired
	    private DataSource dataSource;

	    //define this property in your embedded properties file or use spring's default
	    @Value("${liquibase.change-log}")
	    private String defaultLiquibaseChangelog;

	    @Bean
	    public SpringLiquibase liquibase() {
	        SpringLiquibase liquibase = new SpringLiquibase();
	        liquibase.setDataSource(dataSource);
	        liquibase.setChangeLog(defaultLiquibaseChangelog);
	        // Configure rest of liquibase here...
	        // ...
	        liquibase.setShouldRun(false);
	        return liquibase;
	    }

}
