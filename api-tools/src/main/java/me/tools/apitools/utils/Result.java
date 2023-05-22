package me.tools.apitools.utils;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
public class Result implements Serializable {
    private int code;

    private String message;

    private Map<String, Object> result;

    public static Result ok() {
        Result result = new Result();
        result.setCode(200);
        result.setMessage("success");
        result.setResult(new HashMap<>());
        return result;
    }

    public static Result ok(Object data) {
        Result result = Result.ok();
        result.result.put("data", data);
        return result;
    }

    public static Result fail(String msg) {
        Result result = new Result();
        result.setCode(400);
        result.setMessage(msg);
        return result;
    }

    public Result put(String key, Object data) {
        this.result.put(key, data);
        return this;
    }
}
