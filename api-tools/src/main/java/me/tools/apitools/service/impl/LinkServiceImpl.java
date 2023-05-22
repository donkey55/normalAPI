package me.tools.apitools.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import me.tools.apitools.entity.Link;
import me.tools.apitools.mapper.LinkMapper;
import me.tools.apitools.service.LinkService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements LinkService {
    public List<Link> kkk() {
        return baseMapper.testMapper();
    }
}
