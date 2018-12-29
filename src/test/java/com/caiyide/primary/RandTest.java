package com.caiyide.primary;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @outhor liusiyu
 * @create 2018-10-17-13:50
 */
public class RandTest {
    public static void main(String[] args) {
        Random rand = new Random();
        int randuser = rand.nextInt(100) + 1;

        System.out.println(randuser);

        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowtime = sdf.format(d);
        System.out.println(nowtime);
        System.out.println(d);

        int  startime = Integer.parseInt(sdf.format(d).substring(8,10));
//        int b = Integer.valueOf(startime).intValue();
        System.out.println(startime);

        MathContext mc = new MathContext(5, RoundingMode.HALF_UP);
        BigDecimal totalpowerjishu1 ;
        BigDecimal totalmoneyjishu1 ;
//        totalpowerjishu1.setScale( 5,BigDecimal.ROUND_HALF_UP );
//       System.out.println("测试-----------------------------------------------" + totalpowerjishu1);
    }
}
