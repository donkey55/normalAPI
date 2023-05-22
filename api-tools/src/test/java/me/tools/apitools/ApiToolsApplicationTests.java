package me.tools.apitools;

import jakarta.annotation.Resource;
import me.tools.apitools.mapper.LinkMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApiToolsApplicationTests {

    @Resource
    private LinkMapper linkMapper;
    @Test
    void contextLoads() {
    }

    @Test
    public void encrypt() {
        System.out.println(linkMapper.testMapper().get(0).toString());
    }
}
