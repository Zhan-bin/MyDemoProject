package org.example.sort.singleton;

public class Singleton {
    private static volatile Singleton singleton;

    private Singleton() {}

    public synchronized static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }

        return singleton;
    }
}
