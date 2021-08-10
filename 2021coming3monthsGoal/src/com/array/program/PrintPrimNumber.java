package com.array.program;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrintPrimNumber {

	public static void main(String[] args) {

		System.out.println(PrimeDigitNumber2("9090842252"));

	}

	private static String PrimeDigitNumber2(String string) {
		char c[] = string.toCharArray();
		System.out.println(Arrays.toString(c));
		boolean carry = false;
		
		Map<Integer,Integer> mapOtherThen0index= new HashMap<Integer,Integer>();
		
		
		
		
		for (int i = c.length - 1; i >= 0; i--) {
			
			
			
			if (i == 0) {
				int k = 0;

				if (carry)
					k = Integer.parseInt(String.valueOf(c[i])) - 1;
				else
					k = Integer.parseInt(String.valueOf(c[i]));

				if (k == 0)
					c[i] = '0';
				else if (k == 1)
					c[i] = '0';
				else if (k == 2)
					c[i] = '2';
				else if (k == 3)
					c[i] = '3';
				else if (k == 4)
					c[i] = '3';
				else if (k == 5)
					c[i] = '5';
				else if (k == 6)
					c[i] = '5';
				else if (k == 7)
					c[i] = '7';
				else if (k == 8)
					c[i] = '7';
				else if (k == 9)
					c[i] = '7';
			} else {
				if(c[0]=='9' || c[0]=='8') {
					carry = true;
					c[i] = '7';
				}else if(c[0]=='7' && c[i]>='7') {
					c[i] = '7';
				}else if(c[0]=='7' && (c[i]>='5'|| c[i]<'7')) {
					c[i] = '5';
				}else if(c[0]=='7' && (c[i]=='4' || c[i]=='3')) {
					c[i] = '3';
				}else if(c[0]=='7' && c[i]=='2') {
					c[i] = '2';
				}else if(c[0]=='7' && (c[i]=='1'|| c[i]=='0')) {
					carry = true;
					c[i] = '7';
				}
				
				
				if (c[i] == '0') {
					
				} else if (c[i] == '1') {
					carry = true;
					c[i] = '7';
				} else if (c[i] == '2')
					c[i] = '2';
				else if (c[i] == '3')
					c[i] = '3';
				else if (c[i] == '4')
					c[i] = '3';
				else if (c[i] == '5')
					c[i] = '5';
				else if (c[i] == '6')
					c[i] = '5';
				else if (c[i] == '7')
					c[i] = '7';
				else if (c[i] == '8')
					c[i] = '7';
				else if (c[i] == '9')
					c[i] = '7';
			}
		}

		String s = "";

		System.out.println(Arrays.toString(c));

		for (int i = 0; i < c.length; i++) {
			if (c[i] != '0') {
				s = s + c[i];
			}
		}
		return s;
	}
	//0-7
	//1-7
	//2-2
	//3-3
	//4-3
	//5-5
	//6-5
	//7-7
	//8-7
	//9-9
	// 7 5 3 2

	private static String PrimeDigitNumber1(String string) {
		int max=0;
		if(string.length()==1) {
	    return String.valueOf(maxValue(string));
     	}else {
		  for(int i=1;i<string.length();i++) {
			  if(string.charAt(i)==0 && string.charAt(i-1)>7 ) {
				  
				  
			  }else if(string.charAt(i)==0 && string.charAt(i-1)>5) {
				  
			  }else if(string.charAt(i)==0 && string.charAt(i-1)>3) {
				  
			  }
			  
			  
		  }
		
		return null;
	}
		
	}
	
	public static int maxValue(String string) {
		int max = 0;
		int n = Integer.parseInt(string);
		if (n == 2)
			return n;
		for (int i = 2; i < n; i++) {
			if (isPrime(i)) {
				if (max < i) {
					max = i;
				}
			}
		}
		return max;
	}

	static String PrimeDigitNumber(String N) {
		long n = Long.parseLong(N);
		long max = 0;
		for (long i = 2; i <= n; i++) {
			String s = String.valueOf(i);
			int count = 0;
			for (int k = 0; k < s.length(); k++) {
				char c = s.charAt(k);
				if (isPrime(Integer.parseInt(String.valueOf(c)))) {
					count++;
				}
			}
			if (count == s.length()) {
				System.out.println(i+" ");
				if (max < i) {
					max = i;
				}
			}
		}

		return String.valueOf(max);
	}

	public static boolean isPrime(int n) {
		if (n <= 1)
			return false;
		for (int i = 2; i < n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

}
