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


//        l.kToLast(8);
        l.kToLast(2);

        System.out.println("----------------------");

        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
//        System.out.println("List Size: " + list.size());
        list.delMidNode();
    }
}
