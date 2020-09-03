package com.blockchain.goldenblock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GoldenblockApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoldenblockApplication.class, args);
    }

}