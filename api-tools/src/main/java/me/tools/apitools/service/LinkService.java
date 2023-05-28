package me.tools.apitools.service;

import com.baomidou.mybatisplus.extension.service.IService;
import me.tools.apitools.entity.Link;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public interface LinkService extends IService<Link> {
    List<Link> kkk();
    public String shortLink(String link);

    public String redirect(String shortLink);
}
