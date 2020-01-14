package com.javaTwo;

import java.util.*;

public class Graph {
    protected static class Edge {
        protected int src, dest;

        public Edge() {}
        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    List<List<Integer>> adj = new ArrayList<>();

    public Graph(List<Edge> edges) {
        for (int i = 0; i < edges.size(); i++)
            adj.add(i, new ArrayList<>());

        for (Edge e : edges)
            adj.get(e.src).add(e.dest);
    }

    private static void printGraph(Graph graph) {
        int src = 0;
        int n = graph.adj.size();

        while (src < n)
        {
            for (int dest : graph.adj.get(src))
                System.out.print("(" + src + " --> " + dest + ")\t");

            System.out.println();
            src++;
        }
    }


    /*
    Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
     */
    public static boolean findRoute(Graph g, int start, int end) {
        if (start == end) return true;

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        List<Boolean> visited = new LinkedList<>();
        int src = 0;
        while (src < g.adj.size()) {
            visited.add(src, false);
            for (int dest : g.adj.get(src)) {
                if(visited.contains(dest)) continue;
                visited.add(dest, false);
            }
            src++;
        }


        while (!q.isEmpty()) {
            Integer current = q.remove();
//            System.out.println(visited.get(current));
            if (visited.get(current) == false) {
                visited.add(current, true);
                if (current == end) return true;
                for (int dest : g.adj.get(current)) {
//                    System.out.println("adding: " + dest);
                    q.add(dest);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        List<Edge> edges = Arrays.asList(new Edge(0, 1), new Edge(1, 2),
                new Edge(2, 0), new Edge(2, 1),new Edge(3, 2),
                new Edge(4, 5), new Edge(5, 4));
        Graph g = new Graph(edges);
        printGraph(g);

        System.out.println("5 -> 4: " + findRoute(g, 5, 4)); // true
        System.out.println("0 -> 3: " + findRoute(g, 0, 3)); // false
        System.out.println("0 -> 2: " + findRoute(g, 0, 2)); // true
        System.out.println("1 -> 2: " + findRoute(g, 1, 2)); // true
        System.out.println("3 -> 3: " + findRoute(g, 3, 3)); // true
        System.out.println("2 -> 3: " + findRoute(g, 2, 3)); // false
        System.out.println("1 -> 0: " + findRoute(g, 1, 0)); // true
        System.out.println("1 -> 4: " + findRoute(g, 1, 4)); // false
    }
}
