package org.kkx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class KkxAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(KkxAdminApplication.class, args);
    }

}
