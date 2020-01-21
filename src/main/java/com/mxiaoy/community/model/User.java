package com.mxiaoy.community.model;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String account_Id;
    private String user_name;
    private String user_token;
    private Long gmt_create;
    private Long gmt_modified;
    private String user_bio;
    private String avatar_url;


}
