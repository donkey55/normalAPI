package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@MapperScan("com.neo.mapper")
public class DemoApplication {

    public static void main(String[] args) {
        Map<String, Integer> words = new HashMap<>();
        words.put("hello", 3);
        words.put("world", 4);
        words.merge("hello", 1, Integer::sum);
        System.out.println(words.get("hello"));
        SpringApplication.run(DemoApplication.class, args);
    }

}
