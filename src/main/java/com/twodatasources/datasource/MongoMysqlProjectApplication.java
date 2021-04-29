package com.twodatasources.datasource;

import com.twodatasources.datasource.repositories.SqlRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableJpaRepositories
@EnableMongoRepositories
public class MongoMysqlProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoMysqlProjectApplication.class, args);
    }

}
