package com.mxiaoy.community.controller;

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
                        Model model) {

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

        List<QuestionDto> questionList = questionService.list();
        model.addAttribute("questions", questionList);
        return "index";
    }

}