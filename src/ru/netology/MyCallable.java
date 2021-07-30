package ru.netology;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    private int count = 1;

    @Override
    public String call() throws Exception {
        for (int i = 0; i < 5; i++) {
            Thread.sleep(3000);
            count++;
        }
        return Thread.currentThread().getName() + "задача выполнена " + count++ + " раз";
    }
}

