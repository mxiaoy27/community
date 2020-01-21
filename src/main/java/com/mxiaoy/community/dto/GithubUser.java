package com.mxiaoy.community.dto;

import lombok.Data;

/**
 * @Author zhuyushuo
 * @Date 2020/1/3 14:56
 * @Version 1.0
 * @Description
 */
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String url;
}