package com.julianduru.util;


/**
 * created by julian
 */
public class MathUtil {


    private static final double DEFAULT_EQUALITY_THRESHOLD = 0.00000001;


    public static boolean equal(float f1, float f2) {
        return equal(f1, f2, DEFAULT_EQUALITY_THRESHOLD);
    }


    public static boolean equal(float f1, float f2, double threshold) {
        return Math.abs(f1 - f2) < threshold;
    }


}
