import java.util.Arrays;

class Item {
    float weight;
    int value;

    Item(float weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

public class KnapsackBranchAndBound {

    static int[] knapsack(int W, Item[] arr) {
        Arrays.sort(arr, (a, b) -> Float.compare(b.value / b.weight, a.value / a.weight));
        int n = arr.length;
        int maxProfit = 0;
        int[] included = new int[n];

        for (int i = 0; i < n; i++) {
            included[i] = 0;
        }

        for (Item item : arr) {
            if (item.weight <= W) {
                maxProfit += item.value;
                W -= item.weight;
                for (int i = 0; i < n; i++) {
                    if (arr[i] == item) {
                        included[i] = 1;
                        break;
                    }
                }
            } else {
                maxProfit += (int) (W * (item.value / item.weight));
                for (int i = 0; i < n; i++) {
                    if (arr[i] == item) {
                        included[i] = 1;
                        break;
                    }
                }
                break;
            }
        }

        System.out.println("Maximum possible profit = " + maxProfit);
        return included;
    }

    public static void main(String[] args) {
        int W = 10;
        Item[] arr = {
                new Item(2, 40),
                new Item(3.14f, 50),
                new Item(1.98f, 100),
                new Item(5, 95),
                new Item(3, 30)
        };

        int[] included = knapsack(W, arr);
        int n = arr.length;
        System.out.println("Included items using 0 and 1: ");
        for (int i = 0; i < n; i++) {
            System.out.println("Item " + (i + 1) + ": Included = " + included[i] + ", Profit = " + arr[i].value);
        }
    }
}


