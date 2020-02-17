package com.mxiaoy.community.mapper;

import com.mxiaoy.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
    @Insert("insert into users (user_name,account_Id,user_token,gmt_create,gmt_modified,avatar_url) values (#{user_name},#{account_Id},#{user_token},#{gmt_create},#{gmt_modified},#{avatar_url})")
    void insert(User user);

    @Select("select * from users where user_token=#{user_token}")
    User findByToken(@Param("token") String token);

    @Select("select * from users where id=#{id}")
    User findById(@Param("id") Integer creator);
}
