package com.vermas.code.learning;
public class LCMOFTwoNumber
{
    // Recursive method to return gcd of a and b
    static int gcd(int a, int b)
    {
    	System.out.println(a+" ,"+b);
        if (a == 0)
            return b; 
        return gcd(b % a, a); 
    }
    
    
     
    // method to return LCM of two numbers
    static int lcm(int a, int b)
    {
    	System.out.println(gcd(a, b));
        return (a / gcd(a, b)) * b;
    }
     
    // Driver method
    public static void main(String[] args) 
    {
        int a = 10, b = 1;
        System.out.println("LCM of " + a +
                           " and " + b + 
                      " is " + lcm(a, b));
    }
}