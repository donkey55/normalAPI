package me.tools.apitools.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("link")
public class Link implements Serializable {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String raw;

    private String redirect;
}
