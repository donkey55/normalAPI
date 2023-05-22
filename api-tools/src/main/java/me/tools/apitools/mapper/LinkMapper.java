package me.tools.apitools.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import me.tools.apitools.entity.Link;

import java.util.List;


public interface LinkMapper extends BaseMapper<Link> {
    List<Link> testMapper();
}
