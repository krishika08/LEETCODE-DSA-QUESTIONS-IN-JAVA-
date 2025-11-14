public class KnapsackTabulation{
                // DECLARES STATIC METHOD THAT GIVES THE OUTPUT OF THE DP TABLEE
                // TAKES A 2D INTEGER ARRAY
public static void print(int dp [][]){
                // THIS LOOP ITERATES THROUGH EACH ROW OF THE DP TABLE
                // dp.length GIVES THE TOTAL NO. OF ROWS
                for(int i = 0;i < dp.length;i++){
                                // THIS LOOP RUNS FOR EVERY COLUMN INSIDE THE CURRENT LOOP
                                // dp[0].length GIVES THE BUMBER OF COLUMNS IN THE TABLE
                                for(int j = 0;j < dp[0].length;j++){
                                                // PRINTS EACH DP CELL AND THEN GIVES THE SPACE
                                                // SO THAT VALUES APPER IN THE SAME ROW
                                                System.out.print(dp[i][j]+" ");
                                }
                                // PRINTS A NEW LINE AFTER FINISHING ALL COLUMNS OF A ROW
                                System.out.println();
                }
                // Adds a blank line after printing the entire DP table to make output more readable
                System.out.println();
}
// FUNCTION TO SOLVE 0-1 KNAPSACK USING TABULATION
public static int KnapsackTabulation (int val[],int wt[],int W){
                // TOTAL NUMBER OF ITEMS
                int n = val.length;
                // CREATE DP table of size (n+1) (W+1)
                int dp[][] = new int [n+1][W+1];
                // CAPACITY 0 -> PROFIT ALWAYS 0
                for(int i = 0;i<dp.length;i++){
                                dp[i][0] = 0;
                }
                // ITEMS 0 -> PROFIT ALWAYS 0
                for(int j =0;j <= W;j++){
                                dp[0][j] = 0;
                }
                // NESTED LOOP
                // LOOP THROUGH ALL ITEMS
                for (int i = 1; i < n+1; i++){
                                // LOOP THROUGH ALL CAPACITIES FROM 1 TO W
                                for (int j = 1; j < W+1; j++){
                                                // CURRENT ITEM'S VALUE 
                                                int v = val[i-1];
                                                // CURRENT ITEM'S WEIGHT
                                                int weight = wt[i-1];
                                                // CHECKS IF THE ITEM CAN FIT INSIDE THE CURRENT CAPACITY J
                                                // IF WEIGHT IS LESS THAN EQUAL TO CAPACITY
                                                // WE HAVE TWO OPTIONS --
                                                // INCLUDE
                                                // EXCLUDE
                                                if(weight <= j){
                                                                // IF WE INCLUDE THE ITEM
                                                                // THEN WE NEED TO ADD
                                                                // ITS VALUE V (CURRENT ITEM VALUE)
                                                                // AND
                                                                // ALSO ADD THE BEST PROFIT FROM PREVIOUS ITEMS FOR REMAINING CAPACITY 
                                                                // THAT IS J - WEIGHT
                                                                int incProfit = v + dp[i-1][j-weight];
                                                                // IF WE EXCLUDE THE ITEM THEN, WE SIMPLY TAKE THE PROFIT FROM PREVIOUS ITEMS FOR CAPACITY 'J'
                                                                int excProfit = dp[i-1][j];
                                                                // CHOOSE THE MAXIMUM FROM INCLUDE AND EXCLUDE AND THEN STORE IT IN DP TABLE
                                                                dp[i][j] = Math.max(incProfit,excProfit);
                                                }
                                                else{//IF ITEM'S WEIGHT IS GREATER THAN J
                                                // THEN ITEM CAN NOT BE INCLUDED
                                                // TAKE ONLY EXCLUDED PROFIT
                                                                int excProfit = dp[i-1][j];
                                                                // STORE THE EXCLUDED PROFIT IN DP TABLE
                                                                dp[i][j] = excProfit;
                                                }
                                }                    
                                }
                                // AFTER FILLING THE ENTIRE TABLE
                                // PRINT THE DP TABLE 
                                print(dp);
                                // RETURN THE FINAL ANSWER
                                return dp[n][W];
                }
                public static void main(String[] args) {
        // values (profits) of each item
        int val[] = {15, 14, 10, 45, 30};
        // weights of the corresponding arrays
        int wt[] = {2, 5, 1, 3, 4};
        // maximum capacity of the knapsack
        int w = 7;
        // call the knapsack dunction to calculate the maximum value
        System.out.println(KnapsackTabulation(val, wt, w));
    }
}
