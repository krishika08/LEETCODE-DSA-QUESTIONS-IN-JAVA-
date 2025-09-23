import java.util.*;

public class Fractional_Knapsack {
                public static void main(String[] args) {
                    int val [] ={60,100,120};//Values of items
                    int weight [] = {10,20,30};//Weights of items
                    int W = 50; //capacity of the Knapsack

                //     2D arrays to sort the ratios
                    double ratio [][] = new double[val.length][2];
                    for(int i = 0; i < val.length;i++){
                                ratio[i][0] = i; // Original index
                                ratio[i][1] = val[i]/(double)weight[i]; // to calculate the ratio | ratio = value/weight
                    }
                //     Sorting the items by eratio in ascending order 
                    Arrays.sort(ratio,Comparator.comparingDouble(o->o[1]));
                    
                    int capacity = W;
                    int finalvalue = 0;
                    for(int i = ratio.length-1; i>=0; i--){
                                int idx =(int)ratio[i][0];
                                if(capacity >= weight[idx]){
                                                finalvalue += val[idx];
                                                capacity -= weight[idx];
                                }
                                else{
                                                finalvalue += (ratio[i][1] * capacity);
                                                capacity = 0;           
                                                break;
                                }
                    }
                    System.out.println("final value = " + finalvalue);
                }

}
