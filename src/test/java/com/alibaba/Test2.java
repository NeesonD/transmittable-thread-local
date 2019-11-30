package com.alibaba;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Create on 2019-11-30
 * Copyright (c) 2019 by XueBang Information Technology Co.Ltd.
 * All Rights Reserved, Designed By XueBangSoft
 * Copyright:  Copyright(C) 2014-2019
 * Company:    XueBang Information Technology Co.Ltd.
 *
 * @author DaiLe
 */
public class Test2 {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        executor.submit(() -> {});

//        TransmittableThreadLocal<String> child = new TransmittableThreadLocal<>();
//        executor.submit(() -> {
//            child.set("value-set-in-child");
//            System.out.println(Thread.currentThread().getName() + ": " + child.get());
//        });
//
//        final TransmittableThreadLocal<String> parent = new TransmittableThreadLocal<>();
//        parent.set("value-set-in-parent");
//        executor.submit(TtlRunnable.get(() -> {
//            System.out.println(Thread.currentThread().getName() + ": " + child.get()); // 这里child.get为null
//            System.out.println(Thread.currentThread().getName() + ": " + parent.get());
//        }));

        executor.shutdown();
    }

}
