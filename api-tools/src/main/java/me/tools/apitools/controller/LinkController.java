package me.tools.apitools.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import me.tools.apitools.service.LinkService;
import me.tools.apitools.utils.Result;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;

@RestController
public class LinkController {

    @Resource
    private LinkService linkService;
    @RequestMapping("/short-link")
    public Result shortLink(@RequestParam(name = "link") String link) {
        String redirect = linkService.shortLink(link);
        if (redirect != null) {
            return Result.ok().put("redirect", redirect);
        } else {
            return Result.fail("gen error, please retry again, after several minutes");
        }
    }

    @RequestMapping("/{shortLink}")
    public void redirect(@PathVariable String shortLink, HttpServletResponse response) throws IOException {
        String originalLink = linkService.redirect(shortLink);
        if (originalLink != null) {
            response.sendRedirect(originalLink);
        } else {
            response.setStatus(502);
        }
    }
}
