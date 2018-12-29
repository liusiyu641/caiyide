package com.caiyide.primary.util;

/**
 * @outhor liusiyu
 * @create 2018-12-27-15:51
 */
public class OrderUtil {
    public static String random() {
        return "" + System.currentTimeMillis() + (long) (java.lang.Math.random() * 10000000L);
    }
}
