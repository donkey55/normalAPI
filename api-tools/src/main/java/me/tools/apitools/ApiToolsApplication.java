package me.tools.apitools;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("me.tools.apitools.mapper")
public class ApiToolsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiToolsApplication.class, args);
    }

}
