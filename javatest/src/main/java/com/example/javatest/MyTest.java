package com.example.javatest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class MyTest {
    public static void main(String[] args) {

    }

    static void test01(){
        ExecutorService executorService = Executors.newCachedThreadPool();
    }

    static void test02(){
        ExecutorService executorService = Executors.newCachedThreadPool(new ThreadFactory() {
            @Override
            public Thread newThread(Runnable runnable) {
                return null;
            }
        });
    }

    static void test03(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}
