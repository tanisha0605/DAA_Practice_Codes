import java.util.Arrays;

public class BellmanFord {
    static class Edge {
        int source, destination, weight;

        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static int[] bellmanFord(Edge[] edges, int V, int source) {
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        // Relax all edges |V| - 1 times
        for (int i = 0; i < V - 1; i++) {
            for (Edge edge : edges) {
                if (distance[edge.source] != Integer.MAX_VALUE && distance[edge.source] + edge.weight < distance[edge.destination]) {
                    distance[edge.destination] = distance[edge.source] + edge.weight;
                }
            }
        }

        // Check for negative-weight cycles
        for (Edge edge : edges) {
            if (distance[edge.source] != Integer.MAX_VALUE && distance[edge.source] + edge.weight < distance[edge.destination]) {
                System.out.println("Graph contains negative-weight cycle.");
                return null;
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        int V = 5; // Number of vertices
        int source = 0; // Source vertex

        // Example graph represented as an array of edges (source, destination, weight)
        Edge[] edges = {
                new Edge(0, 1, 5),
                new Edge(0, 2, 4),
                new Edge(1, 3, 3),
                new Edge(2, 1, 6),
                new Edge(3, 2, 2),
                new Edge(3, 4, 2),
                new Edge(4, 0, 3)
        };

        int[] distance = bellmanFord(edges, V, source);
        if (distance != null) {
            System.out.println("Shortest distances from source vertex " + source + ":");
            for (int i = 0; i < V; i++) {
                System.out.println("Vertex " + i + ": " + distance[i]);
            }
        }
    }
}

