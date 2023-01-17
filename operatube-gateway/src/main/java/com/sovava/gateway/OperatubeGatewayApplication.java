package com.sovava.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class OperatubeGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(OperatubeGatewayApplication.class, args);
    }

}
