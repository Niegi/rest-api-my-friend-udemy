package com.example.restapimyfriendudemy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.example.restapimyfriendudemy.entity")
@EnableJpaRepositories("com.example.restapimyfriendudemy.repository")
public class RestApiMyFriendUdemyApplication {

  public static void main(String[] args) {
    SpringApplication.run(RestApiMyFriendUdemyApplication.class, args);
  }

}
