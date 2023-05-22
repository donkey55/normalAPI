package me.tools.apitools.controller;

import jakarta.annotation.Resource;
import me.tools.apitools.service.LinkService;
import me.tools.apitools.utils.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinkController {

    @Resource
    private LinkService linkService;
    @RequestMapping("/short-link")
    public Result shortLink(@RequestParam(name = "link") String link) {

        return Result.ok(linkService.kkk());
    }
}
