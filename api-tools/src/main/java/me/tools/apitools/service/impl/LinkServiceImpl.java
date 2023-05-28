package me.tools.apitools.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import me.tools.apitools.entity.Link;
import me.tools.apitools.mapper.LinkMapper;
import me.tools.apitools.service.LinkService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@Service
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements LinkService {

    @Value("${short-link.domain}")
    private String domain;
    public List<Link> kkk() {
        return baseMapper.testMapper();
    }

    public String shortLink(String link) {
        List<Link> list = baseMapper.selectList(new QueryWrapper<Link>().eq("raw", link));
        if(list.size() != 0) {
            if (list.size() == 1) {
                return list.get(0).getRedirect();
            } else {
                return null;
            }
        }
        Link newLink = new Link();
        List<Link> temp = new ArrayList<>();
        newLink.setRaw(link);
        String redirect = "";
        do {
            String uniqueId = genShortLink(link);
            if (uniqueId == null) {
                return null;
            }
            redirect = domain + uniqueId.replaceAll("/", "").substring(0, 12);
            temp = baseMapper.selectList(new QueryWrapper<Link>().eq("redirect", redirect));
        } while (temp.size() != 0);
        newLink.setRedirect(redirect);
        baseMapper.insert(newLink);
        return redirect;
    }

    @Override
    public String redirect(String shortLink) {
        Link link = baseMapper.selectOne(new QueryWrapper<Link>().eq("redirect", domain + shortLink));
        if (link != null) {
            return link.getRaw();
        } else {
            return null;
        }
    }

    public String genShortLink(String raw) {
        String time = String.valueOf(new Date().getTime());
        String uuid = String.join("", UUID.randomUUID().toString().split("-"));
        String res = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest((uuid + time).getBytes());
            res = Base64.getEncoder().encodeToString(encodedHash);

        } catch (NoSuchAlgorithmException  e) {
            log.error("genShortLink Error: NoSuchAlgorithmException SHA-256");
        }
        return res;
    }

}
