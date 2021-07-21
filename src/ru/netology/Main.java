package ru.netology;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        Callable<String> myCallable = new MyCallable();
        Callable<String> myCallable1 = new MyCallable();
        Callable<String> myCallable2 = new MyCallable();
        Callable<String> myCallable3 = new MyCallable();
        ExecutorService exec = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<Callable<String>> callableTasks = new ArrayList<>();
        callableTasks.add(myCallable);
        callableTasks.add(myCallable1);
        callableTasks.add(myCallable2);
        callableTasks.add(myCallable3);

        //демонстрация запуска всех задач
        try {
            List<Future<String>> futures = exec.invokeAll(callableTasks);
            for (Future<String> future : futures) {
                System.out.println(future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        //демонстрация запуска одной задачи
        try {
            String result = exec.invokeAny(callableTasks);
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        exec.shutdown();
    }
}

