// Class definition
public class LCSTabulation {

    // Create a function
    // Declare 2 strings in that
    // And return the integer value (i.e. --> length of LCS)
    public static int LCSTabulation(String str1, String str2) {

        // Calculate the length of string 1 and then store in n
        int n = str1.length();

        // Calculate the length of string 2 and then store in m
        int m = str2.length();

        // Create a 2D Array (matrix)
        // Matrix of size (n+1) by (m+1)
        // +1 is taken so that the empty string (index 0) case can be stored
        int dp[][] = new int[n + 1][m + 1];

        // Starts a loop to iterate through every row index from 0 to n
        for (int i = 0; i < n + 1; i++) {

            // Starts a nested loop
            // Iterates through every column from index 0 to m
            for (int j = 0; j < m + 1; j++) {

                // To check if the current cell is in the 0th row OR the 0th column
                if (i == 0 || j == 0) {

                    // If current cell is at index 0 (empty string case)
                    // Set LCS Length = 0
                    dp[i][j] = 0;
                }
            }
        }

        // Starts the loop from 1
        // 0 is already filled
        // i = current length of str 1 being processed
        // i means which character we are checking of str 1
        for (int i = 1; i < n + 1; i++) {

            // Inner loop from j = 1
            // j = current length of str 2 being processed
            // j means which character we are checking of str 2
            for (int j = 1; j < m + 1; j++) {

                // Compares the characters of str1 and str2
                // We use i-1 and j-1
                // We take the indexing of the strings from 0 and our loop is at 1
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {

                    // Characters get matched
                    // Add 1 to the diagonal value (previous result)
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {

                    // Value from top cell (ignoring current char of str1)
                    int ans1 = dp[i - 1][j];

                    // Value from left cell (ignoring current char of str2)
                    int ans2 = dp[i][j - 1];

                    // Give the max value from both and store in the current cell
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }


        // --------------------------------- NEW ADDED FOR TABLE ( NOT IMPORTANT) ------------------------
             System.out.println("DP TABLE IS :");
             // for all ROWS
             for(int i = 0 ; i < dp.length ; i++){
                // for all COLUMNS 
                for(int j =0 ; j<dp[0].length ; j++){
                    // a new line after every row 
               System.out.print(dp[i][j] +" ");
                }
                System.out.println();
             }
              System.out.println();
             
// -------------------------------- ENDS --------------------------------------------------
        
        // Returns the final answer located at the bottom-right corner
        return dp[n][m];
    }

    // Main method
    public static void main(String[] args) {
        // Initialize the first string variable
        String str1 = "abcdge";

        // Initialize the second string variable
        String str2 = "abedg";

        // Call the function and print the returned value
        System.out.println(LCSTabulation(str1, str2));
    }

}
