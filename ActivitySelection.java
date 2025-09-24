// IMPORTING ALL THE CLASSES FRONM THE PACKAGE
import java.util.*;
// DEFINES A CLASS NAME
public class ActivitySelection {
    // MAIN METHOD
    public static void main(String[] args) {

        // MAKING TWO ARRAYS ONE FOR THE STARTING OF THE ACTIVITY AND ANOTHER FOR ENDING OF THE ACTIVITY
        int start[] = {1,3,0,5,8,5}; //ACTIVITY STARTING TIME(ACTIVITY BEGINS)
        int end[] = {2,4,6,7,9,9}; // ACTIVITY ENDINGB TIME(ACTIVITY FINISHES)
        // TO INITIALIZING THE COUNT = O THAT STARTING FROM THE ZERO 
        // TO COUNT HOW MANY ACTIVITIES WE CAN SELECT
        int maxAct = 0;
        // TO STORE THAT WHICH ACTIVITIES WE HAVE BEEN SELECTED BY THEIR INDEX NUMBE
        ArrayList<Integer>ans = new ArrayList<> ();
        // IN ACTIVITY SEKLECTION PROVBLEM  WE ALWAYS CHOOSE FIRST ACTIVITY BY DEFAULT AND ENDS 
        // EARLY 0 MEANS INDEX OF THE4 FIRST ACTIVITY

        maxAct =1;
        ans.add(0);
        // END TIME OF THE LAST CHOOSEN ACTIVITY HERE IT THEV END TIME OF THE FIRST ACTIVITY THAT IS 2

         int inLastEnd = end[0];
        //  LOOP FOR ALL THE ACTIVITIES FROM INDEX 1 TO THE END
         for( int i  = 1 ; i < end.length ; i++){
            // TO CHECK THE CONDITION THAT THE NEXT ACTIVITY STARTED FROM THE LAST ACTIVITY END TIME OR NOT 
            if (start[i] >= inLastEnd){
                // IF THE ACTIVITY IS VALID AND DO NOT OVERLAP WITH ANY OTHER OF THE ACTIVITY THEN IT WILLL INCREASE THEV TOTAL COUNT  AND ALSO ADDS ITS INDEX TON THE LIST AND ALSO UPDATES TE LAST ACTIVITY END TIME

                maxAct ++;//INCREASES THE TORTAL COUNT OF THE ACTIVITIES
                ans.add(i);//ADD ITS INDEX TO THE LIST
                inLastEnd = end [i];//LAST SELECTED ACTIVITY UPDATED
            }

         }
         //TO PRINT HOW MANY ACTIVIES WE HAVE SELECTED IN TOTAL
         System.out.println("maxAct:"  + maxAct);
         //TO PRINT EACH SELECTED ACTIVITY BY ITS INDEX
         for(int i =0;i<ans.size();i++){
            System.out.println("A" + ans.get(i)+" ");
         }
         //TO PRINT A BLACK LINE
         System.out.println();
    }
}