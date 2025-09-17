package com.project.uber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EntityScan(basePackages = {
        "com.hritik.entity_service.model",
})
public class UberApplication {

    public static void main(String[] args) {
        SpringApplication.run(UberApplication.class, args);
    }

}
