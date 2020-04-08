package com.mxiaoy.community.controller;

import com.mxiaoy.community.dto.AccessTokenDto;
import com.mxiaoy.community.dto.GithubUser;
import com.mxiaoy.community.mapper.UserMapper;
import com.mxiaoy.community.model.User;
import com.mxiaoy.community.provider.GithubProvider;
import com.mxiaoy.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

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



    @Autowired
    private UserService userService;

    @Value("${github.Client.id}")
    private String clientId;

    @Value("${github.Client.secret}")
    private String clientSecret;

    @Value("${github.Redirect.url}")
    private String redirectUrl;

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state,
                           HttpServletResponse response) {

        AccessTokenDto accessTokenDto = new AccessTokenDto();
        accessTokenDto.setClient_id(clientId);
        accessTokenDto.setClient_secret(clientSecret);
        accessTokenDto.setCode(code);
        accessTokenDto.setRedirect_url(redirectUrl);
        accessTokenDto.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDto);
        GithubUser githubUser = githubProvider.getUser(accessToken);
        if (githubUser != null){
            User user = new User();
            String token = UUID.randomUUID().toString();
            user.setUser_token(token);
            user.setUser_name(githubUser.getName());
            user.setAccount_Id(String.valueOf(githubUser.getId()));
            user.setAvatar_url(githubUser.getAvatar_url());
            userService.createOrUpdate(user);
            response.addCookie(new Cookie("token", token));
            return "redirect:/";
        } else {
            // 登录失败
            return "redirect:/";
        }
    }
}