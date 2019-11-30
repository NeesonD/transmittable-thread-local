package com.alibaba;

import com.alibaba.ttl.threadpool.TtlExecutors;
import org.junit.Test;

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
public class IThreadLocalTest {

    static class Pet {
        private String name;

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public Pet(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Pet{" +
                "name='" + name + '\'' +
                '}';
        }
    }

    @Test
    public void testThreadLocalInPool() throws InterruptedException {
        final ThreadLocal<Pet> tl1 = new InheritableThreadLocal<>();
        final ThreadLocal<Pet> tl2 = new InheritableThreadLocal<>();


        Pet pet = new Pet("xiaomao");
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ExecutorService ttlExecutorService = TtlExecutors.getTtlExecutorService(executorService);
        tl1.set(pet);
        for(int i =0 ;i<2;i++) {
            ttlExecutorService.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " " + tl1.get());
            });
        }

        Thread.sleep(2000L);

        //inheritableThreadLocal是浅拷贝
        pet.setName("xiaogou");
        for(int i =0 ;i<2;i++) {
            executorService.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " " + tl1.get());
            });
        }


        //线程池中线程一旦创建完成，InheritableThreadLocal就再也传不进去
        pet.setName("xiaoji");
        tl2.set(pet);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" "+tl2.get());
            }
        });

    }



}
