package me.tools.apitools.entity;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

@Data
public class User {
    @JSONField(name = "firstName")
    String name;
    String age;

    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }
}
