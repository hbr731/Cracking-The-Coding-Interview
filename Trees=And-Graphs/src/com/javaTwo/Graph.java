package com.javaTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public static void main(String[] args) {
        List<Edge> edges = Arrays.asList(new Edge(0, 1), new Edge(1, 2),
                new Edge(2, 0), new Edge(2, 1),new Edge(3, 2),
                new Edge(4, 5), new Edge(5, 4));
        Graph g = new Graph(edges);
        printGraph(g);
    }
}
