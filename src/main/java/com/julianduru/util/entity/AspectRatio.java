package com.julianduru.util.entity;


import lombok.Data;

import javax.persistence.Embeddable;

/**
 * created by julian
 */
@Data
@Embeddable
public class AspectRatio {


    // TODO: add constraint on size
    private int scaleWidth;


    private int scaleHeight;


    public AspectRatio() {}


    public AspectRatio(int scaleWidth, int scaleHeight) {
        this.scaleWidth = scaleWidth;
        this.scaleHeight = scaleHeight;
    }


}