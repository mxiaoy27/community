package com.mxiaoy.community.controller;

import com.mxiaoy.community.dto.PaginationDto;
import com.mxiaoy.community.dto.QuestionDto;
import com.mxiaoy.community.mapper.QuestionMapper;
import com.mxiaoy.community.mapper.UserMapper;
import com.mxiaoy.community.model.Question;
import com.mxiaoy.community.model.User;
import com.mxiaoy.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author zhuyushuo
 * @Date 2019/12/30 16:17
 * @Version 1.0
 * @Description
 */

@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model,
                        @RequestParam(name = "page",defaultValue = "1") Integer page,
                        @RequestParam(name = "size",defaultValue = "5") Integer size) {
        Cookie[] cookies = request.getCookies();

        if (cookies != null){
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("token")){
                    String token = cookie.getValue();
                    User user = userMapper.findByToken(token);
                    if (user != null){
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }

        PaginationDto paginationDto = questionService.list(page, size);
        model.addAttribute("paginationDto", paginationDto);
        return "index";
    }

}