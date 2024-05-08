
public class FractionalKnapsack {
    
    static void fractionalKnapsack(int n, int[] w, int[] p, int W) {
        int i, j;
        int weightUsed = 0;
        int totalProfit = 0;
        double[] pbyw = new double[n];

        for (i = 0; i < n; i++) {
            pbyw[i] = (double) p[i] / (double) w[i];
        }

        for (i = 0; i < n - 1; i++) {
            for (j = 0; j < n - i - 1; j++) {
                if (pbyw[j] < pbyw[j + 1]) {
                    double tempPbyw = pbyw[j];
                    pbyw[j] = pbyw[j + 1];
                    pbyw[j + 1] = tempPbyw;

                    int tempWeight = w[j];
                    w[j] = w[j + 1];
                    w[j + 1] = tempWeight;

                    int tempProfit = p[j];
                    p[j] = p[j + 1];
                    p[j + 1] = tempProfit;
                }
            }
        }

        for (i = 0; i < n; i++) {
            if (w[i] <= W) {
                weightUsed += w[i];
                totalProfit += p[i];
                W -= w[i];
                System.out.println("Profit " + p[i] + " with weight " + w[i] + " added completely.");
            } else {
                double fraction = (double) W / (double) w[i];
                weightUsed += W;
                totalProfit += p[i] * fraction;
                W = 0;
                System.out.println("Profit " + p[i] + " with weight " + w[i] + " added by " + String.format("%.2f", fraction) + ".");
                System.out.println("Total profit: " + totalProfit);
            }
            if (W == 0) {
                break;
            }
        }
        System.out.println("Total weight occupied: " + weightUsed);
    }

    public static void main(String[] args) {
        int[] p = {280, 100, 120, 120};
        int[] w = {40, 10, 20, 24};
        int W = 60;
        int n = p.length;
        fractionalKnapsack(n, w, p, W);
    }
}

