package com.goalOf3Month;
class FindUnion {
    
    static int printUnion(int arr1[], int arr2[], int m, int n)
    {
        int i = 0, j = 0;
        while (i < m && j < n) {
        	if(i+1 < m && arr1[i]==arr1[i+1]) {
        		i++;
        	   continue;
        	}
        	if(j+1 < n && arr2[j]==arr1[j+1]) {
        		j++;
        		continue;
        	}
        	
            if (arr1[i] < arr2[j])
                System.out.print(arr1[i++] + " ");
            else if (arr2[j] < arr1[i])
                System.out.print(arr2[j++] + " ");
            else {
                System.out.print(arr2[j++] + " ");
                i++;
            }
        }
  
        /* Print remaining elements of 
         the larger array */
        while (i < m)
            System.out.print(arr1[i++] + " ");
        while (j < n)
            System.out.print(arr2[j++] + " ");
  
        return 0;
    }
  
    public static void main(String args[])
    {
        int arr1[] = { 1, 2, 2, 5, 6,6};
        int arr2[] = { 2, 3, 5, 7,7,7};
        int m = arr1.length;
        int n = arr2.length;
        printUnion(arr1, arr2, m, n);
    }
}