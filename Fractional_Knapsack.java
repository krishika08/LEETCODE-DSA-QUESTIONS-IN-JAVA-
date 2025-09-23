import java.util.*;
public class Fractional_Knapsack {
                public static void main(String[] args) {
                    int val [] ={60,100,120};//Values of items
                    int weight [] = {10,20,30};//Weights of items
                    int W = 50; //capacity of the Knapsack

                //     2D arrays to sort the value index and the value ratios
                    double ratio [][] = new double[val.length][2];
                    for(int i = 0; i < val.length;i++){
                                ratio[i][0] = i; // Original index
                                ratio[i][1] = val[i]/(double)weight[i]; // to calculate the ratio | ratio = value/weight
                    }
                //     Sorting the items by ratio in ascending order 
                    Arrays.sort(ratio,Comparator.comparingDouble(o->o[1]));
                    
                    int capacity = W;//Remaining capacity of the knapsack
                    double finalvalue = 0;// To initiate the final value of the knapsack
                    //we will be using a loop as we want the items in the descendoing order
                    for(int i = ratio.length-1; i>=0; i--){
                                int idx =(int)ratio[i][0]; //To get the original index of the item from the sorted ratio array
                                // if full item can be taken to the knapsack
                                if(capacity >= weight[idx]){
                                                finalvalue += val[idx];//for adding full value to the knapsack
                                                capacity -= weight[idx];//reduce the remaining capacity 
                                }
                                // If only a part of of item can be taken 
                                else{
                                                finalvalue += (ratio[i][1] * capacity);//Add fractional value
                                                capacity = 0;  //Knapsack is full         
                                                break;//No more items can be added Exiting the loop
                                }
                    }
                    System.out.println("final value = " + finalvalue);// To print the final value that can be the maximum in the Knapsack
                }

}
