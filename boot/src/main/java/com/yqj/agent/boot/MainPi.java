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
        long count = 0;
        long total = 100000000000L;
        for (long i=0; i<total; i++){
            double x = ThreadLocalRandom.current().nextDouble(1);
            double y = ThreadLocalRandom.current().nextDouble(1);
            if (Math.sqrt(x * x + y * y) < 1.0){
                count+=1;
            }
        }
        double pi = 4 * (double)count / (double) total;
        System.out.println("Pi is: " + pi);
    }

}
