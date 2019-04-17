package com.caiyide.primary;

/**
 * @outhor liusiyu
 * @create 2019-02-27-11:13
 */
public class MultiThreadDemo extends Thread{
    public MultiThreadDemo(String name) {
        super(name);
    }
    @Override
    public void run(){
        while (true) {
            System.out.println(Thread.currentThread().getName() + " is running ... "); // 打印当前线程的名字
            try {
                Thread.sleep(1000); // 休息1000ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {

//        // 基于子类的实现
//        new Thread() {
//            public void run() {
//                while (true) {
//                    System.out.println(Thread.currentThread().getName() + " is running ... "); // 打印当前线程的名字
//                    try {
//                        Thread.sleep(1000); // 休息1000ms
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            };
//        }.start();
//
//        // 基于接口的实现
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    System.out.println(Thread.currentThread().getName() + " is running ... "); // 打印当前线程的名字
//                    try {
//                        int b = 1;
//                        System.out.println("我是第二个！");
//                        Thread.sleep(1000); // 休息1000ms
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();


        MultiThreadDemo a1 =new MultiThreadDemo("第一个！"  );
        MultiThreadDemo a2 =new MultiThreadDemo("第二个！" );
        MultiThreadDemo a3 =new MultiThreadDemo("第三个！" );
        a1.start();
        a2.start();
        a3.start();
        // 主线程的方法
        while (true) {
            System.out.println(Thread.currentThread().getName() + " is running ... "); // 打印当前线程的名字
            try {
                Thread.sleep(1000); // 休息1000ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
