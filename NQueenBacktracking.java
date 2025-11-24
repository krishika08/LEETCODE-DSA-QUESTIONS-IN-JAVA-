// DECLARES A PUBLIC JAVA CLASS THAT CONTAINS BACKTRACKING METHODS
public class NQueenBacktracking {
                // DECLARES A PUBLIC STATIC METHOD
                // THAT TAKES 2D ARRAY BOARD WITH DATA TYPE CHAR  AND AN INTEGER ROW
                // IT WILL PLACE QUEENS ROW BY ROW(current row number)
                public static void NQueenBacktracking(char board[][],int row){
                                // base case check for recursion
                                // IF WE HAVE PLACED QUEENS FOR ALL ROWS , WE HAVE REACHED A  FULL CONFIGURATION
                                if(row == board.length){
                                                // CALL PRINTBOARD TO PRINT THE CURRENT BOARD CONFIGURATION TO THE CONSOLE
                                                printboard(board);
                                                // EXIT THE CURRENT CALL OF THIS METHOD
                                                // RETURN AFTER PRINTING
                                                return;
                                }
                                // column loop
                                // TRY EVERY COLUMN IN THE CURRENT ROW
                                // EACH ITERATION TRIES TO PLACE A QUEEN AT COLUMN i IN THE CURRENT ROW
                                for (int i = 0; i < board.length; i++) {
                                                // PLACE A QUEEN CHARACTER "Q" AT THE CELL
                                                // IN CURRENT ROW AND COLUMN i
                                    board[row][i] = 'Q';
                                //     RECURSIVELY CALL FOR NEXT ROW TO PLACE THE NEXT QUEEN USING CURRENT STATE
                                    NQueenBacktracking(board, row+1); // function call
                                //     REMOVE THE QUEEN PLACED EARLIER
                                // BACKTRACKING  STEP THAT OTHER COLUMNS CAN BE TRIED
                                    board[row][i] = '.'; //backtracking step
                                }
                }
                // PRINT THE 2D BOARD TO THE CONSOLE
                public static void printboard(char board[][]){
                                // OUTER LOOP ITERATING ROWS
                                for (int i = 0; i < board.length; i++) {
                                                // INNER LOOP ITERATING COLUMNS FOR CURRENT ROW
                                    for (int j = 0; j < board.length; j++) {
                                                // PRINT CELL VALUE AND A SPACE
                                        System.out.print(board[i][j] + " ");
                                    }
                                //     MOVE TO NEXT LINE AFTER PRINTING THE ROW
                                    System.out.println();
                                }
                }
                // MAIN METHOD
                public static void main(String[] args) {
                                // DECLARES THE BOARD VALUE BY 2 i.e.2 x 2
                    int n = 2;
                //     CREATES A NEW 2D CHAR ARRAY WITH N ROWS AND N COLUMNS TO REPRESENT THEIR CHESSBOARD
                    char board[][] = new char[n][n];
                //     initialize
                // LOOP OVER ROWS TO INITIALIZE EACH CELL
                for (int i = 0; i < n; i++) {
                                // INNER LOOP OVER COLUMNS WITHIN A ROW
                                for (int j = 0; j < n; j++) {
                                                // MARK CELL AS EMPTY
                                    board[i][j] = '.';
                                }
                }
                // CALL THE RECURSIVE METHOD TO START PLACING QUEENS BEGINNING FROM ROW 0
                NQueenBacktracking(board, 0);
                }
}
