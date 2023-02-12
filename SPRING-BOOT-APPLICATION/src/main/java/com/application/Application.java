package com.application;

import com.application.entities.User;
import com.application.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner run(
            UserRepository userRepositoryBean
    ) {

        return args -> {
            Stream.of("hassan", "imane", "mohammed").forEach((name) -> {
                User user = new User();
                user.setName(name);
                user.setEmail(name + "@gmail.com");
                user.setPassword("123456");
                userRepositoryBean.save(user);
            });
        };
    }
}