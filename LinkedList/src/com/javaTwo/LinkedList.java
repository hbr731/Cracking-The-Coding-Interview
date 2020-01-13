package com.javaTwo;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public class LinkedList<E> {

    protected class Node {
        protected E data;
        protected Node next;
        public Node() {}
        public Node(E elt) { data = elt; }
    }

    protected Node head;

    public int size() {
        int sz = 0;
        for (Node tnd = head; tnd != null; tnd = tnd.next) sz++;
        return sz;
    }

    public void addFirst(E elt) {
        Node nnd = new Node(elt);
        nnd.next = head;
        head = nnd;
    }

    public boolean add (E elt) {
        Node nnd = new Node(elt);

        if (head == null) {
            head = nnd;
            return true;
        }

        Node tnd = head;
        while (tnd.next != null) tnd = tnd.next;

        tnd.next = nnd;
        return true;
    }

    public E remove() {
        if (head == null) throw new NoSuchElementException();

        E ret = head.data;
        head = head.next;
        return ret;
    }

    public E remove (int idx) {
        if (idx < 0) throw new IndexOutOfBoundsException();
        if (idx == 0) return remove();

        Node tnd = head;
        int i = 0;

        while (i < idx - 1) {
            if (tnd != null) tnd = tnd.next;
            else throw new IndexOutOfBoundsException();
            i++;
        }

        E ret;
        if (tnd.next != null) {
            ret = tnd.next.data;
            tnd.next = tnd.next.next;
        } else throw new IndexOutOfBoundsException();

        return ret;
    }

    // Write code to remove duplicates from an unsorted linked list
    public void removeDuplicates() {
        Set<E> data = new HashSet<>();
        Node tnd = head;
        int i = 0;
        while (tnd.next != null) {
            if (!data.contains(tnd.data)) {
                data.add(tnd.data);
                i++;
            }
            else remove(i);
            tnd = tnd.next;
        }
    }

    // FOLLOW UP
    // How would uou solve this problem if a temporary buffer is not allowed?
    public void removeDups() {
        Node tnd = head;
        Node ttnd = tnd.next;
//        int i = 1;

        while (tnd.next.next != null) {
            while (ttnd.next != null) {
//                int idx = i;
                if (tnd.data == ttnd.data) remove(getIndex(ttnd));
//                else idx++;
                ttnd = ttnd.next;
            }
            tnd = tnd.next;
            ttnd = tnd.next;
//            i++;
        }
    }

    private int getIndex(Node nd) {
        Node tnd = head;
        int i = 0;
        while (tnd != nd) {
            i++;
            tnd = tnd.next;
        }
        return i;
    }

    public Node getNode(int idx) {
        if (idx < 0) throw new IndexOutOfBoundsException();
        Node tnd = head;
        int i = 0;

        while (i != idx && tnd.next != null) {
            i++;
            tnd = tnd.next;
        }

        if (tnd == null) throw new IndexOutOfBoundsException();
        return tnd;
    }

    public E get(int idx) {
        if (idx < 0) throw new IndexOutOfBoundsException();
        Node tnd = head;
        int i = 0;

        while (i != idx && tnd.next != null) {
            i++;
            tnd = tnd.next;
        }

        if (tnd == null) throw new IndexOutOfBoundsException();
        return tnd.data;
    }


    // Implement an algorithm to find the kth to last element of a singly linked list
    public void kToLast(int k) {
        if (k > size()) throw new IndexOutOfBoundsException();
        int i = 1;
        Node tnd = head;

        while (i < k) {
            tnd = tnd.next;
            i++;
        }

        while (i < size()) {
            System.out.println(tnd.data);
            tnd = tnd.next;
            i++;
        }
    }

    /*
    Implement an algorithm to delete a node in the middle (i.e., any node but the first
    and last node, not necessarily the exact middle) of a singly linked list, given
    only access to that node.

    EX:
    Input: the node c from the linked list a -> b -> c -> d -> e -> f -> null
    Result: a -> b -> d -> e -> f -> null
     */
    public void delMidNode() {
        int mid = (size()-1)/2;
        if (mid == size()) System.out.println("No middle element found");

//        System.out.println("size: " + size() + "\nmid: " +mid + "\n" + size()/2);
//        Node tnd = head;
//        int i = 0;
//
//        while (i < mid) {
//            i++;
//            tnd = tnd.next;
//        }
        System.out.println("Deleted: " + remove(mid));
    }

    /*
    Write code to partition a linked list around a value x, such that all nodes less
    than x come before all nodes greater than or equal to x. If x is contained within
    the list, the values of x only need to be after the elements less than x. The
    partition element x can appear anywhere in the "right partition"; it does not
    need to appear between the left and right partitions.
     */
    public void partition() {
        E pivot = remove((size()-1)/2);
        Node left = new Node();
        Node right = new Node(pivot);

//        System.out.println("pivot: " + pivot);

//        System.out.println("left: " + left.data);
//        System.out.println("right:" + right.data);

        Node tnd = head;
        Node lnd = left;
        Node rnd = right;
        while (tnd != null) {
//            System.out.println(tnd.data);

            if ((int) tnd.data < (int) pivot) {
//                System.out.println("smaller");
                while (lnd.next != null) lnd = lnd.next;
                lnd.next = new Node(tnd.data);
            }
            else {
//                System.out.println("inside else: " + tnd.data);
                while (rnd.next != null) rnd = rnd.next;
                rnd.next = new Node(tnd.data);
//                System.out.println(rnd.next.data);
            }
            tnd = tnd.next;
        }

        left = left.next;
//        System.out.println("left: " + left.data);
//        System.out.println("right:" + right.data);
        Node ttnd = left;

        while (ttnd.next != null) ttnd = ttnd.next;

        ttnd.next = right;

        head = left;

    }

    /*
    You have two numbers represented by a linked list, where each node contains a single digit.
    The digits are stored in reverse order, such that the 1s digit is at the head of the list.
    Write a function that adds the two numbers and returns the sum as a linked list.
     */
    public LinkedList<Integer> reversedListsSum(LinkedList<E> list) {
//        E temp = (E) list.get(0);
//        Node nd = new Node(temp);

//        Node lhead = list.head;
        Node tnd = head;

        StringBuilder str1 = new StringBuilder(), str2 = new StringBuilder();

        // save the list elements as nodes. Is this necessary?
//        Node ttnd = nd;
//        for (int i = 1; i < list.size(); i++) {
//            while (ttnd.next != null) ttnd = ttnd.next;
//            ttnd.next = new Node((E) list.get(i));
//        }

        while (tnd != null) {
            str1.insert(0, tnd.data);
            tnd = tnd.next;
        }

        for (int i = 0; i < list.size(); i++) str2.insert(0, list.get(i));

        System.out.println("str1: " + str1 + "\nstr2: " + str2);

        String sum = Integer.toString(Integer.parseInt(str1.toString()) +
                        Integer.parseInt(str2.toString()));

        LinkedList<Integer> ret = new LinkedList<>();
        for (int i = 0; i < sum.length(); i++) {
            ret.addFirst(Character.getNumericValue(sum.charAt(i)));
        }

        return ret;
    }

    /*
    FOLLOW UP
    Suppose the digits are stored in forward order. Repeat the above problem.
     */
    public LinkedList<Integer> forwardListsSum(LinkedList<E> list) {
        Node tnd = head;

        StringBuilder str1 = new StringBuilder(), str2 = new StringBuilder();

        while (tnd != null) {
            str1.append(tnd.data);
            tnd = tnd.next;
        }

        for (int i = 0; i < list.size(); i++) str2.append(list.get(i));

        System.out.println("str1: " + str1 + "\nstr2: " + str2);

        String sum = Integer.toString(Integer.parseInt(str1.toString()) +
                Integer.parseInt(str2.toString()));

        LinkedList<Integer> ret = new LinkedList<>();

        for (int i = 0; i < sum.length(); i++) {
            ret.add(Character.getNumericValue(sum.charAt(i)));
        }

        return ret;
    }

    /*
    Implement a function to check if a linked list is a palindrome
     */
    public boolean isPalindrome() {
        Node reversedHead = new Node(head.data);
        Node tnd = head.next;

        while (tnd != null) {
            Node temp = new Node(tnd.data);
            temp.next = reversedHead;
            reversedHead = temp;

            tnd = tnd.next;
        }

        Node tnd1 = head, tnd2 = reversedHead;
        for (int i = 0; i < size()/2; i++) {
            if (tnd1.data != tnd2.data) return false;
            tnd1 = tnd1.next;
            tnd2 = tnd2.next;
        }

        return true;
    }

    /*
    Given a circular linked list, implement an algorithm that returns the node at the beginning of
    the loop
     */
    public E checkLoop() {
        HashSet<Node> nodes = new HashSet<>();
        Node duplicate = new Node();
        Node tnd = head;
        while (tnd != null) {
            if (nodes.contains(tnd)) {
                duplicate = tnd;
                break;
            }
            else nodes.add(tnd);
            tnd = tnd.next;
        }

        return duplicate.data;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        Node tnd = head;
        while (tnd != null) {
            str.append(tnd.data);
            str.append(", ");
            tnd = tnd.next;
        }
        return "LinkedList{" +
                str +
                '}';
    }
}
