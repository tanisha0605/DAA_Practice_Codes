public class GraphColoring {
    // Method to add an edge between two nodes in the graph
    public static void addNode(int[][] graph, int x, int y) {
        graph[x][y] = 1;
        graph[y][x] = 1;
    }

    // Method to check if it is safe to color a node with a given color
    public static boolean isSafe(int col, int[] color, int x, int[][] graph) {
        for (int i :graph[x]) {
            if (graph[x][i] == 1 && color[i] == col) {
                return false; 
                // If there exists an edge between node x and i, and the color of node i is the same as col, return false
            }
        }
        return true; // Otherwise, it is safe to color the node
    }

    // Method to determine if the graph can be colored with at most m colors
    public static boolean canColor(int x, int[][] graph, int[] color, int n, int m) {
        if (x == n) return true; // Base case: if all nodes are colored, return true
        
        // Try to color node x with each color from 1 to m
        for (int i = 1; i <= m; i++) {
            if (isSafe(i, color, x, graph)) {
                color[x] = i; // Assign color i to node x
                if (canColor(x + 1, graph, color, n, m)) return true; // Recur to color the next node
                color[x] = 0; // If coloring node x with color i does not lead to a solution, remove color (backtrack)
            }
        }
        return false; // If no color can be assigned to this node, return false
    }

    public static void main(String args[]) {
        // Initialize a graph with 4 nodes
        int[][] graph = new int[4][4];
        
        // Add edges between nodes
        addNode(graph, 0, 1);
        addNode(graph, 1, 2);
        addNode(graph, 2, 3);
        addNode(graph, 3, 0);
        addNode(graph, 2, 0);

        // Initialize an array to store the color assigned to each node
        int[] color = new int[4];

        // Try to color the graph with at most 3 colors
        boolean ans = canColor(0, graph, color, 4, 3); // 4 is the number of nodes, 3 is the max number of colors, 0 is the starting index

        if (!ans) {
            System.out.println("No, we can't color the graph with 3 colors.");
        } else {
            System.out.println("Yes, we can color the graph. The colors assigned to each node are:");
            for (int i : color) {
                System.out.print(i + " ");
            }
        }
    }
}

