package com.dyn.springbootdemo;

import com.dyn.springbootdemo.entity.PhoneDO;
import com.dyn.springbootdemo.entity.Test;

import java.lang.reflect.Constructor;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    String str=new String("good");
    char[]ch={'a','b','c'};

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.change(main.str,main.ch);
        System.out.println(main.str+main.ch[0]);

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <=i ; j++) {
                System.out.print(i+"*"+j+"="+i*j+" ");
            }
            System.out.println();
        }

        ReentrantLock lock = new ReentrantLock();

        try {
            for (int i = 0; i < 3; i++) {
                System.out.println("******  " + Thread.currentThread().getName() + " is printing " + i + "  ******");
                // 查询当前线程保持此锁的次数
                int holdCount = lock.getHoldCount();

                // 返回正等待获取此锁的线程估计数
                int queuedLength = lock.getQueueLength();

                // 如果此锁的公平设置为 true，则返回 true
                boolean isFair = lock.isFair();

                System.out.printf("---holdCount: %d;\n---queuedLength:%d;\n---isFair: %s\n\n", holdCount, queuedLength,
                        isFair);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public String change(String str,char ch[]){
        str="test ok";
        ch[0]='g';
        return str;
    }


}
