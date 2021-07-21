package ru.netology;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    private int count = 1;
    @Override
    public String call() throws Exception {
        Thread.sleep(3000);
        return Thread.currentThread().getName() + "задача выполнена " + count++ + " раз";
    }
}

