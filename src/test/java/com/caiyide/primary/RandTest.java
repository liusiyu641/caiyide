package com.caiyide.primary;


import com.caiyide.primary.web.vo.ShopCarVo;

import java.util.ArrayList;
import java.util.List;

/**
 * @outhor liusiyu
 * @create 2018-10-17-13:50
 */
public class RandTest {
//    public static void main(String[] args) {
//        Random rand = new Random();
//        int randuser = rand.nextInt(100) + 1;
//
//        System.out.println(randuser);
//
//        Date d = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String nowtime = sdf.format(d);
//        System.out.println(nowtime);
//        System.out.println(d);
//
//        int  startime = Integer.parseInt(sdf.format(d).substring(8,10));
////        int b = Integer.valueOf(startime).intValue();
//        System.out.println(startime);
//
//        MathContext mc = new MathContext(5, RoundingMode.HALF_UP);
//        BigDecimal totalpowerjishu1 ;
//        BigDecimal totalmoneyjishu1 ;
////        totalpowerjishu1.setScale( 5,BigDecimal.ROUND_HALF_UP );
////       System.out.println("测试-----------------------------------------------" + totalpowerjishu1);
//    }
    public static void main(String[] args) {
        System.out.println( "小弱鸡" );
        List<ShopCarVo>shop=new ArrayList<>(  );
        ShopCarVo vo=new ShopCarVo();
        vo.setUserId( "123" );
        shop.add( vo );
        ShopCarVo vo2=new ShopCarVo();
        vo2.setUserId( "124" );
        shop.add( vo2 );

        ShopCarVo vo3=new ShopCarVo();
        vo3.setUserId( "123" );

        System.out.println( shop.contains(vo3) );
   }

}
