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
        list.add(7);
        list.add(4);
        list.add(2);
        list.add(5);
        list.add(1);
        list.add(6);
        list.add(3);

//        System.out.println("List Size: " + list.size());
//        list.delMidNode();
        list.partition();
        System.out.println(list);

        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(7);
        list1.add(1);
        list1.add(6);

        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(5);
        list2.add(9);
        list2.add(2);

        System.out.println(list1.reversedListsSum(list2));
        System.out.println(list1.forwardListsSum(list2));
        System.out.println();

        LinkedList<Integer> palin = new LinkedList<>();
        palin.add(0);
        palin.add(1);
        palin.add(2);
        palin.add(1);
        palin.add(0);
        System.out.println(palin.isPalindrome());
        System.out.println("Looping Node: " + palin.checkLoop()); // null
        palin.head.next.next.next.next = palin.head.next;
        System.out.println("Looping Node: " + palin.checkLoop()); // 1
    }
}
