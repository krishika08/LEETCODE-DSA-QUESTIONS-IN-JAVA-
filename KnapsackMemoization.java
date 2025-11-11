public class KnapsackMemoization {
    // Main recursive function
    // val[] = contains the values of the items
    // wt[] = contains the weights of the items
    // w = current remaining capacity of the bag
    // n = number of items we are considering currently
    // dp[][] = to store the results
    public static int knapsack(int val[], int wt[], int w, int n, int dp[][]) {
        // BASE CASE:
        // If either the bag capacity becomes 0
        // OR there is no more item left
        // then, MAX VALUE = 0
        if (w == 0 || n == 0) {
            return 0;
        }
        // dp[n][w]represents the maximum value we can get
        // -> using first n items
        // ->within bag capacity of w
        // we check dp[n][w] != -1 as when program starts . we always fill dp table with -1 everywhere
        // -1 = not calculated yet
        // if dp[n][w] != -1 is not equal to -1 then it means that we have calculated it already 
        // we can directly store the result  
        if (dp[n][w] != -1) {
            return dp[n][w];
        }
        
        // wt[] stores the weights of items
        // n is the no.of items
        // n-1 is used as array is 0-indexed
        if (wt[n - 1] <= w) {
            // (wt[n - 1] <= w -> If true, then it can fit in the knapsack
            // if true , we have 2 options --
            // OPTION 1->INCLUDE
            // -> add its value to tatoal
            // ->reduce the remaining capacity of the bag
            // -> move to next items recursively (n-1)
            int ans1 = val[n - 1] + knapsack(val, wt, w - wt[n - 1], n - 1, dp);
            // OPTION 2 -> EXCLUDE
            // ->skip the current item
            // ->bag capacity remains the same(w)
            // -> Move to the next item (n-1)
            int ans2 = knapsack(val, wt, w, n - 1, dp);

            // We will choose that option(include,exclude)that gives higher total value
            // and stores the result in dp[n][w]
            dp[n][w] = Math.max(ans1, ans2);
            // returns the max value of the result
            return dp[n][w];
        } else {
            // if weight > remaining capacity of the knapsack
            // then we need to only exclude it 
            dp[n][w] = knapsack(val, wt, w, n - 1, dp);
            return dp[n][w];
        }
    }

    public static void main(String[] args) {
        // values (profits) of each item
        int val[] = {15, 14, 10, 45, 30};
        // weights of the corresponding arrays
        int wt[] = {2, 5, 1, 3, 4};
        // maximum capacity of the knapsack
        int w = 7;
        // create 2D array(dp table)for memoization
        // rows = no.of items + 1(val.length + 1)
        // colums = capacity + 1(w + 1)
        // +1 for BASE CASE (0 items or 0 capacity)
        int dp[][] = new int[val.length + 1][w + 1];

        // initialize all the cells of dp with -1 
        // that we can get that not calculated yet
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        // call the knapsack dunction to calculate the maximum value
        System.out.println(knapsack(val, wt, w, val.length, dp));
    }
}