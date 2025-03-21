package org.example.problem.now;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Demo {
    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ExecutorService executorService = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        ThreadPoolExecutor executor = (ThreadPoolExecutor) executorService;

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread start");
                ThreadInfo threadInfo = threadMXBean.getThreadInfo(Thread.currentThread().getId(), 10);
                if (threadInfo != null) {
                    System.out.println(threadInfo);
                } else {
                    System.out.println("NULL");
                }
            }
        });

        thread.start();
    }
}
