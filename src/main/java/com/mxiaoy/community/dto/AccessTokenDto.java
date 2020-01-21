package com.mxiaoy.community.dto;

import lombok.Data;

/**
 * @Author zhuyushuo
 * @Date 2020/1/2 20:25
 * @Version 1.0
 * @Description
 */
@Data
public class AccessTokenDto {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_url;
    private String state;
}