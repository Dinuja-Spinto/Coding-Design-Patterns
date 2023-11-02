package codingPatterns;

public class Knapsack {
    public static int knapsack(int[] values, int[] weights, int capacity) {
        int n = values.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        int max = dp[n][capacity];
        int w = capacity;
        int[] selectedItems = new int[n];
        for (int i = n; i > 0 && max > 0; i--) {
            if (max != dp[i - 1][w]) {
                selectedItems[i - 1] = 1;
                max -= values[i - 1];
                w -= weights[i - 1];
            }
        }

        System.out.print("Selected items: ");
        for (int i = 0; i < n; i++) {
            if (selectedItems[i] == 1) {
                System.out.print("Item " + (i + 1) + " ");
            }
        }
        System.out.println();

        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int capacity = 50;

        int maxValue = knapsack(values, weights, capacity);
        System.out.println("Maximum value: " + maxValue);
    }
}
