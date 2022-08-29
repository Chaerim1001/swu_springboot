package com.likelion.swu_backend_01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:/env.properties")
public class SwuBackend01Application {

    public static void main(String[] args) {
        SpringApplication.run(SwuBackend01Application.class, args);
    }

}
