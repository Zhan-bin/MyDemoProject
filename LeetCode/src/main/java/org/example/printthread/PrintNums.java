package org.example.printthread;

public class PrintNums {
    private static int num = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Printer(), "Thread1");
        Thread thread2 = new Thread(new Printer(), "Thread2");
        thread1.start();
        thread2.start();
    }

    static class Printer implements Runnable {
        @Override
        public void run() {
            while (num <= 100) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + ": " + num++);
                    lock.notify();
                    if (num <= 100) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }
}
