package com.mxiaoy.community.service;

import com.mxiaoy.community.mapper.UserMapper;
import com.mxiaoy.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author zhuyushuo
 * @Date 2020/3/24 20:20
 * @Version 1.0
 * @Description
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void createOrUpdate(User user) {
        User dbUser = userMapper.findByAccountId(user.getAccount_Id());
        if (dbUser == null){

            //插入
            user.setGmt_create(System.currentTimeMillis());
            user.setGmt_modified(user.getGmt_create());
            userMapper.insert(user);
        } else {
            //更新
            dbUser.setGmt_modified(System.currentTimeMillis());
            dbUser.setAvatar_url(user.getAvatar_url());
            dbUser.setUser_name(user.getUser_name());
            dbUser.setUser_token(user.getUser_token());
        }
    }
}