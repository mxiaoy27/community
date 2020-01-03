package com.mxiaoy.community.controller;

import com.mxiaoy.community.dto.AccessTokenDto;
import com.mxiaoy.community.dto.GithubUser;
import com.mxiaoy.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author zhuyushuo
 * @Date 2020/1/2 20:13
 * @Version 1.0
 * @Description
 */

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code, @RequestParam(name="state") String state){

        AccessTokenDto accessTokenDto = new AccessTokenDto();
        accessTokenDto.setClient_id("4703f9013f3a4f1167d1");
        accessTokenDto.setClient_secret("9b560ab3ebe8e4661b45bc7011f1773c6fb7e7bd");
        accessTokenDto.setCode(code);
        accessTokenDto.setRedirect_url("http://localhost:8080/callback");
        accessTokenDto.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDto);
        GithubUser user = githubProvider.getUser(accessToken);
        System.out.println(user.getName());
        return "index";
    }
}