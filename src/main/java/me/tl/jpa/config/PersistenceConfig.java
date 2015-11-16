package me.tl.jpa.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// @Configuration
@EnableTransactionManagement
@ComponentScan({ "me.tl.jpa.persistence", "me.tl.jpa.service" })
@ImportResource({ "classpath:jpaConfig.xml" })
@EnableJpaRepositories(basePackages = "me.tl.jpa.persistence.dao")
public class PersistenceConfig {

    public PersistenceConfig() {
        super();
    }

}