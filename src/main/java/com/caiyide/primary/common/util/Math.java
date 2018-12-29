package com.caiyide.primary.common.util;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public final class Math {
    // 默认除法运算精度
    private static final int DEF_DIV_SCALE = 50;
    // 以50位为计算精度，四舍五入
    private static MathContext mc = new MathContext(50, RoundingMode.HALF_UP);

    // 这个类不能实例化
    private Math() {
        ;
    }

    /**
     * 提供精确的加法运算。
     *
     * @param v1 被加数
     * @param v2 加数
     * @return 两个参数的和
     */
    public static double add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }

    /**
     * 提供精确的减法运算。
     *
     * @param v1 被减数
     * @param v2 减数
     * @return 两个参数的差
     */
    public static double sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 提供精确的乘法运算。
     *
     * @param v1 被乘数
     * @param v2 乘数
     * @return 两个参数的积
     */
    public static double mul(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).doubleValue();
    }

    /**
     * 提供精确的乘法运算。
     *
     * @param v1    被乘数
     * @param v2    乘数
     * @param scale 表示表示需要精确到小数点以后几位
     * @return 两个参数的积
     */
    public static double mul(double v1, double v2, int scale) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return round(b1.multiply(b2).doubleValue(), scale);
    }

    /**
     * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到 小数点以后50位，以后的数字四舍五入。
     *
     * @param v1 被除数
     * @param v2 除数
     * @return 两个参数的商
     */
    public static double div(double v1, double v2) {
        // return div(v1, v2, DEF_DIV_SCALE);
        return div(v1, v2, mc);
    }

    public static double div(double v1, double v2, MathContext mc) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2, mc).setScale(DEF_DIV_SCALE, RoundingMode.HALF_UP)
                .doubleValue();
    }

    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */
    public static double div(double v1, double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 提供精确的小数位四舍五入处理。
     *
     * @param v     需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */
    public static double round(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 提供向上取整，保留scale小数位
     *
     * @param v
     * @param scale
     * @return
     */
    public static double ceiling(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_CEILING).doubleValue();
    }

    /**
     * 提供向下取整，保留scale小数位
     *
     * @param v
     * @param scale
     * @return
     */
    public static double floor(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_FLOOR).doubleValue();
    }

    /**
     * 格式化
     *
     * @param format
     * @param v
     * @return
     */
    public static String format(String format, double v) {
        DecimalFormat df = new DecimalFormat(format);
        return df.format(v);
    }

    /**
     * 两数相除后乘以100 保留 小数
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return
     */
    public static double percent(double v1, double v2, Integer scale) {
        if (v2 == 0) {
            return 0;
        }
        return Math.mul(div(v1, v2), 100, scale);
    }


	/*public static void main(String[] args) {
        System.out.println(Math.div(11000, 3));
		System.out.println(Math.div(11000, 3, 2));
		System.out.println(Math.ceiling(0.234, 2));
		System.out.println(Math.round(0.234, 2));
		System.out.println(Math.floor(200.55, 0));
		System.out.println(Math.floor(-200.55, 0));
		System.out.println(Math.format("#.00", 0));
	}*/
}
