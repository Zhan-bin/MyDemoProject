package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            public void run() {
                try {
                    List<Object> list = new ArrayList<>();
                    for (int i = 0; i < 20; i++) {
                        list.add(new int[100000]);
                        System.out.println("Run" + i);
                        Thread.sleep(5000);
                    }

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread thread = new Thread(runnable);
        Thread thread1 = new Thread(runnable);
        thread.start();
        thread1.start();
    }
}