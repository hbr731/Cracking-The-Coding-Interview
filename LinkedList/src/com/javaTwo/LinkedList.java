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

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        Node tnd = head;
        while (tnd.next != null) {
            str.append(tnd.data);
            str.append(", ");
            tnd = tnd.next;
        }
        return "LinkedList{" +
                str +
                '}';
    }
}
