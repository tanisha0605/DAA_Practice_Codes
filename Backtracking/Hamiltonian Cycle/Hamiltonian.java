import java.util.*;

public class Hamiltonian {
    // Method to add an edge between two nodes in the graph
    public static void addNode(int[][] graph, int x, int y) {
        graph[x][y] = 1;
        graph[y][x] = 1;
    }

    // Method to check if it is safe to add a node to the Hamiltonian Cycle
    public static boolean isSafe(int x, int i, int[][] graph, int[] visit) {
        // Check if there is an edge between the last visited node and the current node
        if (graph[visit[x - 1]][i] == 0) return false;
        // Check if the current node has already been visited
        for (int j : visit) {
            if (j == i) return false;
        }
        return true;
    }

    // Method to find a Hamiltonian Cycle using backtracking
    public static boolean hamiltonCycle(int x, int[][] graph, int[] visit, int n) {
        // Base case: if all nodes are visited
        if (x == n) {
            // Check if there is an edge from the last node to the starting node
            if (graph[visit[x - 1]][visit[0]] == 1) return true;
            return false;
        }
        // Try to add each node to the cycle
        for (int i = 0; i < n; i++) {
            if (isSafe(x, i, graph, visit)) {
                visit[x] = i; // Add node i to the cycle
                if (hamiltonCycle(x + 1, graph, visit, n)) return true; // Recur to add the next node
                visit[x] = -1; // Backtrack if adding node i does not lead to a solution
            }
        }
        return false;
    }

    public static void main(String args[]) {
        int[][] graph = new int[5][5]; // Initialize a graph with 5 nodes

        // Add edges between nodes
        addNode(graph, 0, 1);
        addNode(graph, 0, 3);
        addNode(graph, 1, 2);
        addNode(graph, 1, 3);
        addNode(graph, 1, 4);
        addNode(graph, 2, 4);
        addNode(graph, 3, 4);

        int[] visit = new int[5]; // Array to store the Hamiltonian Cycle
        Arrays.fill(visit, -1); // Initialize the array with -1
        visit[0] = 0; // Start the cycle with node 0

        boolean ans = hamiltonCycle(1, graph, visit, 5); // Start finding the cycle from the second node

        if (!ans) {
            System.out.println("No, there is no Hamiltonian cycle.");
        } else {
            System.out.println("Yes, there is a Hamiltonian cycle. The cycle is:");
            for (int i : visit) {
                System.out.print(i + " ");
            }
            System.out.print(visit[0]); // Print the starting node to complete the cycle
        }
    }
}

