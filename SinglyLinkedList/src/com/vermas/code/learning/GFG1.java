package com.vermas.code.learning;
import java.io.*;
import java.util.*;
 
class GFG1{
     
public static void preserveSpace(String str)
{
    int n = str.length();
  
    // Initialize two pointers as two corners
    int start = 0;
    int end = n - 1;
     
    char[] Str = str.toCharArray();
     
    // Move both pointers toward each other
    while (start < end)
    {
         
        // If character at start or end 
        // is space, ignore it
        if (Str[start] == ' ') 
        {
            start++;
            continue;
        }
        else if (Str[end] == ' ') 
        {
            end--;
            continue;
        }
  
        // If both are not spaces, do swap
        else
        {
            char temp = Str[start];
            Str[start] = Str[end];
            Str[end] = temp;
            start++;
            end--;
        }
    }
    System.out.println(String.valueOf(Str));
}
 
// Driver Code
public static void main(String[] args) 
{
    String str = "internship at geeks for geeks";
     
    preserveSpace(str);
}
}