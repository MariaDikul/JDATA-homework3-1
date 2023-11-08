package ru.netology.jdatahomework31;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration;

@SpringBootApplication(exclude = SqlInitializationAutoConfiguration.class)
public class JdataHomework31Application {

    public static void main(String[] args) {
        SpringApplication.run(JdataHomework31Application.class, args);
    }
}
