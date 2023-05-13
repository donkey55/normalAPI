package me.tools.apitools.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.tools.apitools.utils.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public Result hello() {
        return Result.ok().put("kkk", "result");
    }

    @RequestMapping("/date")
    public String date() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        HashMap<String, String> map = new HashMap<>();
        map.put("code", "200");
        map.put("msg", "success");
        return objectMapper.writeValueAsString(map);
    }
}
