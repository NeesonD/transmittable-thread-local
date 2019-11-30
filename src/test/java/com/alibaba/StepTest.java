package com.alibaba;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Create on 2019-11-28
 * Copyright (c) 2019 by XueBang Information Technology Co.Ltd.
 * All Rights Reserved, Designed By XueBangSoft
 * Copyright:  Copyright(C) 2014-2019
 * Company:    XueBang Information Technology Co.Ltd.
 *
 * @author DaiLe
 */
public class StepTest {

    private static ExecutorService es = TtlExecutors.getTtlExecutorService(Executors.newFixedThreadPool(1));

    private static TransmittableThreadLocal<Integer> transmittableThreadLocal = new TransmittableThreadLocal();
    private static TransmittableThreadLocal<Integer> transmittableThreadLocal2 = new TransmittableThreadLocal();

    public static void main(String[] args) throws InterruptedException {
//        es.execute(()->{
//            System.out.println(Thread.currentThread().getName());
//        });
//        Thread.sleep(2000L);
        System.out.println("===");
//        Thread.sleep(2000L);
        transmittableThreadLocal.set(5);
        transmittableThreadLocal2.set(6);
        es.execute(()->{
            System.out.println(Thread.currentThread().getName());
            Integer integer = transmittableThreadLocal.get();
            System.out.println(integer);
        });
    }

}
