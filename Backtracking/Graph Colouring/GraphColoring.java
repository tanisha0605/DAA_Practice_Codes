public class GraphColoring {
    static int[] colors;
    static int[][] graph;
    static int n; // number of vertices
    static int m; // number of colors

    static boolean nextValue(int k) {
        do {
            colors[k] = (colors[k] + 1) % (m + 1);
            if (colors[k] == 0)
                return false;
            int j;
            for (j = 0; j < n; j++) {
                if (graph[k][j] != 0 && colors[k] == colors[j])
                    break;
            }
            if (j == n)
                return true;
        } while (true);
    }

    static void mColoring(int k) {
        do {
            if (!nextValue(k))
                return;
            if (k == n - 1) {
                // All vertices colored
                printColors();
            } else {
                mColoring(k + 1);
            }
        } while (true);
    }

    static void printColors() {
        for (int i = 0; i < n; i++) {
            System.out.print(colors[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example graph represented as an adjacency matrix
        n = 5;
        m = 3;
        graph = new int[][]{
                {0, 1, 1, 1, 0},
                {1, 0, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {1, 0, 1, 0, 1},
                {0, 1, 0, 1, 0}
        };
        colors = new int[n];
        mColoring(0); // Start coloring from vertex 0
    }
}
