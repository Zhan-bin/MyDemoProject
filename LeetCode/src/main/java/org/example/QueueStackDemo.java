package org.example;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class QueueStackDemo {
    public static void main(String[] args) {
        QueueStackDemo demo = new QueueStackDemo();

        demo.linkListDemo();
    }

    private void linkListDemo() {
        LinkedList<Integer> list = new LinkedList<>();

        System.out.println("================ add");
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("Print all: " + list);
        while (!list.isEmpty()) {
            System.out.println("Poll: " + list.poll());
        }
        System.out.println("================ add");

        System.out.println("================ addLast");
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        System.out.println("Print all: " + list);
        while (!list.isEmpty()) {
            System.out.println("Poll: " + list.poll());
        }
        System.out.println("================ addLast");

        System.out.println("================ addFirst");
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        System.out.println("Print all: " + list);
        while (!list.isEmpty()) {
            System.out.println("Poll: " + list.poll());
        }
        System.out.println("================ addFirst");
    }

    private void arrayDeQueueDemo() {

    }

    private void stackDemo() {

    }

    private void priorityQueueDemo() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
    }
}
