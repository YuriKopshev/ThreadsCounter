package ru.netology;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    private int count = 0;

    @Override
    public String call() throws Exception {
        for (int i = 0; i < 5; i++) {
            Thread.sleep(3000);
            count++;
            System.out.println("Задача"+ count + "выполнена!");
        }
        return Thread.currentThread().getName() + "задача выполнена " + count + " раз";
    }
}

