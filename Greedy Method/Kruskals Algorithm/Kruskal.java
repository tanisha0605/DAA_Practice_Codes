import java.util.*;

public class Kruskal {
    // Class to represent an edge in the graph
    static class Edge implements Comparable<Edge> {
        int source, destination, weight;

        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        // Compare edges based on their weight for sorting
        @Override
        public int compareTo(Edge edge) {
            return this.weight - edge.weight;
        }
    }

    // Array to store the parent of each vertex for union-find
    static int[] parent;

    // Function to initialize the union-find structure
    static void makeSet(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    // Function to find the root of the set containing x using path compression
    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // Function to union two sets containing x and y
    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        parent[rootY] = rootX;
    }

    // Kruskal's algorithm to find the Minimum Spanning Tree (MST)
    static void kruskal(Edge[] edges, int n) {
        // Sort edges by weight
        Arrays.sort(edges);
        List<Edge> mst = new ArrayList<>();
        int minCost = 0;

        // Initialize union-find structure
        makeSet(n);
        int edgeCount = 0;

        // Iterate over sorted edges
        for (Edge edge : edges) {
            // If we have found n-1 edges for the MST, break
            if (edgeCount == n - 1) break;

            int rootSource = find(edge.source);
            int rootDestination = find(edge.destination);

            // If including this edge does not form a cycle
            if (rootSource != rootDestination) {
                mst.add(edge);
                minCost += edge.weight;
                union(rootSource, rootDestination);
                edgeCount++;
            }
        }

        // If we have less than n-1 edges, the graph is not connected
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

        // Call Kruskal's algorithm
        kruskal(edges, n);
    }
}


