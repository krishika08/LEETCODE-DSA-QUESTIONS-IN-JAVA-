// Importing all the classes from the package
import java.util.*;
// Defines the main class 
public class JOB_SEQUENCING {
                // Create a custom data stucture named 'Job'
                // Defines a static inner class to act as a blueprint for a 'Job' object.
                static class Job{
                                int deadline;//variable that stores job deadline
                                int profit;//variable to store job's profit
                                int id;//variable to store the job's unique id
                // Constructor method to create and initialize a new job object
                // when we create a new job object,then this method sets the initial values of the id,deadline and profit
                public Job(int i,int d,int p){
                                id = i;
                                deadline = d;
                                profit = p;
                }
                }
//  Main method where the execution of the program begins
public static void main(String args[]){
                // Storing the data of the job as a deadline and profit
                int JobInfo [][] = {{4,20},{1,10},{1,40},{1,30}};
                // creating a list to keep all the jobs
                ArrayList<Job>jobs = new ArrayList<>();
                // Create a for loop that will iterate for JobInfo array for each job and variable i is used as counter(0,1,2,......) and uniqueID
                for(int i = 0; i< JobInfo.length;i++){
                                // Creates a new Job object
                                // use index i as ID , JobInfo[i][0] and JobInfo[i][1] as profit
                                // then, adds new object to the jobs list
                                jobs.add(new Job(i,JobInfo[i][0],JobInfo[i][1]));
                }
                // Sorting the jobs list in the descending order  so that job with the highest profit is at the starting
                // if we want it in ascending order make it opposite use obj1.profit in place of obj2.profit and vice versa
                Collections.sort(jobs,(obj1,obj2)-> obj2.profit - obj1.profit);
                // to creating a list to store the numbers that we will select to do 
                ArrayList<Integer>seq = new ArrayList<>();
                // to track the time that how many jobs we have done so far
                int time = 0;
                for(int i = 0; i< jobs.size();i++){
                                // Picking the job at position i from the list and storing it in the curr variable
                                Job curr = jobs.get(i);
                                // to check that the job can be done before its deadline or not 
                                if(curr.deadline > time){
                                                // seq is a list where we store the IDs of the jobs we have selected
                                                // curr is for the current job that is being checked
                                                // seq.add means to add the ID to the final list
                                                seq.add(curr.id);
                                                // when we add a job to our sequence then the time will get incremented by 1 that helps us to tracking of jobs that how many jobs we have already done
                                                time++;
                                }
                }
                // To print the total no of jobs that we have selected and schedule
                System.out.println("max jobs = " +seq.size());
                // To check every job ID that we have stored in the seq list
                for(int i = 0; i<seq.size();i++){
                                // To print each job id
                                System.out.print(seq.get(i) + " ");
                }
                // to move to next line after printing 
                System.out.println();
}
}
