package code;

import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
//        System.out.println("Hello, World!");
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(1);
        pq.add(2);
        pq.add(4);
        pq.add(3);
        System.out.println(pq.poll());
    }
}
