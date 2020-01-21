package com.mxiaoy.community.model;

import lombok.Data;

/**
 * @Author zhuyushuo
 * @Date 2020/1/20 15:02
 * @Version 1.0
 * @Description
 */

@Data
public class Question {
    private Integer id;
    private String title;
    private String description;
    private Long gmt_create;
    private Long gmt_modified;
    private Integer creator;
    private Integer comment_count;
    private Integer view_count;
    private Integer like_count;
    private String tag;
}