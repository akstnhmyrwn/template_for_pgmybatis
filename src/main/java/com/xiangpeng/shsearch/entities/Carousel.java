package com.xiangpeng.shsearch.entities;

import lombok.Data;

@Data
public class Carousel extends BaseEntity{
    private Long id;
    private String movieId;
    private String image;
    private int sort;
    private int isShow;

    public Carousel(){
        this.getClassName();
        super.getClassName();
    }
}
