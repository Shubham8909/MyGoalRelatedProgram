package com.array.program;

import java.util.Arrays;

public class BoatstoSavePeople {
	
	public static void main(String[] args) {
		//weight of people
		double arr[]= {1.99, 1.01, 2.5, 1.5, 1.01};
		//capacity of boat (handle the weight)
		int limit=3;
		System.out.println("Ans "+numRescueBoats(arr,limit));
	}
	
    public static int numRescueBoats(double[] people, int limit) {
        Arrays.sort(people);
        int i=0;
        int j=people.length-1;
        int res=0; 
        while(i<=j){
            if(i==j){
                res++;
                break;
            }
            if(people[i]+people[j]<=limit){
                res++;
                i++;
                j--;
            }else{
                res++;
                j--;
            }
        }

   return res;

   }

}
