package com.yqj.agent.boot;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Description:
 *
 * @author yaoqijun
 * @date 2019/12/20
 * Email: yaoqijunmail@foxmail.com
 */
public class MainPi {

    public static void main(String[] args) {
        for (int threadIndex = 0; threadIndex < 5; threadIndex++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            double value = singleCal();
                            System.out.println("calculate value count is " + value);
                            Thread.sleep(ThreadLocalRandom.current().nextLong(2000));
                        } catch (Exception e) {
                            System.out.println("error cause : " + e.toString());
                            try {
                                Thread.sleep(10000);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                }
            }).start();
        }
    }

    private static double singleCal() throws Exception{
        System.out.println(System.currentTimeMillis());
        long count = 0;
        long total = 360000000000L;
        for (long i=0; i<total; i++){
            byte[] unusedBlock = new byte[1024*1024];
            double x = ThreadLocalRandom.current().nextDouble(1);
            double y = ThreadLocalRandom.current().nextDouble(1);
            if (Math.sqrt(x * x + y * y) < 1.0){
                count+=1;
            }
        }
        double pi = 4 * (double)count / (double) total;
        return pi;
    }
}
