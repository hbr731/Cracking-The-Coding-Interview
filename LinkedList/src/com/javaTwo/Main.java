package com.javaTwo;

public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> l = new LinkedList<>();

        l.add(10);
        l.add(20);
        l.add(10);
        l.add(30);
        l.add(20);
        l.add(30);
        l.add(50);
        l.add(30);

        System.out.println(l);
        l.removeDuplicates();
        System.out.println(l);

        System.out.println();

        l = new LinkedList<>();

        l.add(10);
        l.add(20);
        l.add(10);
        l.add(30);
        l.add(20);
        l.add(30);
        l.add(50);
        l.add(30);

        System.out.println(l);
        l.removeDups();
        System.out.println(l);
    }
}
