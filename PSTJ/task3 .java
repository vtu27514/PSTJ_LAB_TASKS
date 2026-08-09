  import java.util.*;

public class MaximumProfitAnalyzer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read number of days
        int n = sc.nextInt();

        int[] profit = new int[n];

        // Read profit/loss values
        for (int i = 0; i < n; i++) {
            profit[i] = sc.nextInt();
        }

        // Kadane's Algorithm
        int currentSum = profit[0];
        int maxSum = profit[0];

        for (int i = 1; i < n; i++) {

            currentSum = Math.max(profit[i],
                                  currentSum + profit[i]);

            maxSum = Math.max(maxSum, currentSum);
        }

        System.out.println(maxSum);

        sc.close();
    }
}