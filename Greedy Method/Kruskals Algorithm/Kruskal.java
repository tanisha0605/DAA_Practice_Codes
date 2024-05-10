import java.util.*;

public class Kruskal {
    static class Edge implements Comparable<Edge> {
        int source, destination, weight;

        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge edge) {
            return this.weight - edge.weight;
        }
    }

    static int[] parent;

    static void makeSet(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        parent[rootY] = rootX;
    }

    static void kruskal(Edge[] edges, int n) {
        Arrays.sort(edges);
        List<Edge> mst = new ArrayList<>();
        int minCost = 0;

        makeSet(n);
        int edgeCount = 0;

        for (Edge edge : edges) {
            if (edgeCount == n - 1) break;

            int rootSource = find(edge.source);
            int rootDestination = find(edge.destination);

            if (rootSource != rootDestination) {
                mst.add(edge);
                minCost += edge.weight;
                union(rootSource, rootDestination);
                edgeCount++;
            }
        }

        if (edgeCount != n - 1) {
            System.out.println("No spanning tree");
        } else {
            System.out.println("Minimum cost of spanning tree: " + minCost);
            System.out.println("Edges of the minimum spanning tree:");
            for (Edge edge : mst) {
                System.out.println("(" + edge.source + ", " + edge.destination + ")");
            }
        }
    }

    public static void main(String[] args) {
        int n = 4; // Number of vertices
        Edge[] edges = {
                new Edge(0, 1, 10),
                new Edge(0, 2, 6),
                new Edge(0, 3, 5),
                new Edge(1, 3, 15),
                new Edge(2, 3, 4)
        };

        kruskal(edges, n);
    }
}

