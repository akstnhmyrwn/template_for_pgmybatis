package com.xiangpeng.shsearch.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class Carousel extends BaseEntity implements Serializable {
    private Long id;
    private String movieId;
    private String image;
    private int sort;
    private int isShow;
}
