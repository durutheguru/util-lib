package com.julianduru.util.format;


import java.text.DecimalFormat;

/**
 * created by julian
 */
public class NumberFormat {


    public static String format(double value) {
        var formatter = new DecimalFormat("#,###.00");
        return formatter.format(value);
    }


}

