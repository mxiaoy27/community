package com.mxiaoy.community.model;

public class User {
    private Integer id;
    private String account_Id;
    private String user_name;
    private String user_token;
    private Long gmt_create;
    private Long gmt_modified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount_Id() {
        return account_Id;
    }

    public void setAccount_Id(String account_Id) {
        this.account_Id = account_Id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_token() {
        return user_token;
    }

    public void setUser_token(String user_token) {
        this.user_token = user_token;
    }

    public Long getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(Long gmt_create) {
        this.gmt_create = gmt_create;
    }

    public Long getGmt_modified() {
        return gmt_modified;
    }

    public void setGmt_modified(Long gmt_modified) {
        this.gmt_modified = gmt_modified;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", account_Id='" + account_Id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_token='" + user_token + '\'' +
                ", gmt_create=" + gmt_create +
                ", gmt_modified=" + gmt_modified +
                '}';
    }
}
