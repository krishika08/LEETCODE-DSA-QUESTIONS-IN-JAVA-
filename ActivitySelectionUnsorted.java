import java.util.*;
public class ActivitySelectionUnsorted {
                public static void main(String[] args) {
                    //unsorted arrays
                    int start[] = {2,8,5,0,7,1,4};
                    int end[] = {4,9,9,6,9,5,8};
                   
                    //declaring 2D arrays with start.length(rows) with 3 number of columns 
                    int activities[][] = new int[start.length][3];
                    for(int i = 0; i<start.length;i++){
                                activities [i][0] = i; //Original index
                                activities [i][1] = start[i]; //start time
                                activities [i][2] = end[i]; // end time
                    }
                    // Sorting a array using a comparator acc to their end times
                    // 2 is for the end time      
                    Arrays.sort(activities,Comparator.comparingDouble(o -> o[2]));
                    //initializing the count here to 0 to count the max number of activities
                    int maxAct = 0;
                    //ans stores the index of the activity that has been selected 
                    ArrayList<Integer> ans = new ArrayList<>();

                    //maxAct = 1 is taken as in Activity Selection problem acc to greedy approach by default first activity is selected that ends early
                    maxAct = 1;
                    // Adds the index of the first selected activity after sorting 
                    ans.add(activities[0][0]);
                    //tells the end time of the first selected acttivity that it may not overlap with the other activities
                    int lastEnd = activities [0][2];

                    for(int i = 1;i < end.length;i++){
                                //compares the start time with the end time of the last selected activity and to check that any of the activity should not overlap with the other activity
                                if(activities [i][1]>= lastEnd){
                                                //if the activities are not overlapping incrementing the count of the activities
                                                maxAct++;
                                                // add the non overlapping activities to the ans
                                                ans.add(activities[i][0]);
                                                //lastEnd variable is updated to the end time of the newly selected activity 
                                                lastEnd = activities[i][2];
                                }
                    }         
                }
}
