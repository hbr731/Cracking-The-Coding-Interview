package com.javaTwo;

class Node<E> {
    protected E data;
    protected Node left, right, parent;
    public Node (E elt) {this.data = elt;}
}
public class Tree<E> {
    private static Node root;

    public Tree() {}

    public boolean isEmpty() {
        return root == null;
    }

    public void inOrderTraversal(Node nd) {
        if (nd == null) return;
        inOrderTraversal(nd.left);
        System.out.println(nd.data);
        inOrderTraversal(nd.right);
    }

    public void preOrderTraversal(Node nd) {
        if (nd == null) return;
        System.out.println(nd.data);
        preOrderTraversal(nd.left);
        preOrderTraversal(nd.right);
    }

    public void postOrderTraversal(Node nd) {
        if (nd == null) return;
        postOrderTraversal(nd.left);
        postOrderTraversal(nd.right);
        System.out.println(nd.data);
    }

    /*
    Given a sorted (increasing order) array with unique integer elements, write
    an algorithm to create a binary search tree with minimal height.
     */
    public static Node constructBST(Integer[] arr, int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;
        Node nd = new Node(arr[mid]);
        nd.left = constructBST(arr, start, mid - 1);
        nd.right = constructBST(arr, mid + 1, end);

        return nd;
    }

    public static void main(String[] args) {
        Tree<Integer> t = new Tree<>();
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        t.root = constructBST(arr, 0, arr.length - 1);
        t.preOrderTraversal(t.root);
        
    }
}
