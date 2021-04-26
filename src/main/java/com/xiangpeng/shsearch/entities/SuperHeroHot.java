package com.xiangpeng.shsearch.entities;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SuperHeroHot extends BaseEntity implements Serializable {
    private String id;
    private String name;
    private String poster;
    private String cover;
    private String trailer;
    private Double score;
    private Integer prisedCounts;
    private String basicinfo;
    private String originalName;
    private String titalTime;
    private String plotDesc;
    private List<String> directors;
    private List<String> actors;
    private List<String> plotPics;
    private String createTime;
}
