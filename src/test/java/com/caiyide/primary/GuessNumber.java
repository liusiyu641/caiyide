package com.caiyide.primary;

import java.util.Random;
import java.util.Scanner;

/**
 * @outhor liusiyu
 * @create 2019-03-19-15:27
 */
public class GuessNumber {
    public static void main(String[] args) {
      int num =new Random().nextInt(100);
//        System.out.println( "num = " + num );
        Scanner scan =new Scanner(System.in);
        System.out.println("游戏开始，输入100以内的数字：");
        while (true){
            int shu = scan.nextInt();
            if (num>shu){ System.out.println("数字小了点！！！" );
            }
//            if (num-shu<10){ System.out.println("加油，很接近咯！！！" );
//            }
            if (num<shu){ System.out.println("数字大了点！！！" );
            }
            if (num==shu){ System.out.println("恭喜你猜对了！！！");
            }
        }
    }
}
