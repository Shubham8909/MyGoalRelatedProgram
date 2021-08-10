package com.interview.prgram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
1. Write a method to remove a given value from array list having string values.

2. Write a method to return the maximum value from an integer array passed as an input parameter.

3. Write a method to update the city attribute of Student object array list passed as an input parameter. If the city is "Mumbai"
 then change it to "Delhi". The method should return how many student records were updated.

4. Write a method to check whether the strings passed as input parameters are made up of the same set of characters.

5. Write a method to remove duplicate values from an array list passed as an input parameter.

6. Write a method to return the second largest element in an integer array passed as an input parameter.

7. Write a method to reverse an integer array passed as an input parameter.

8. Write a method to return the odd numbers and their frequency from an integer array list passed as an input parameter.
*/
public class InterviewClearTrail {
	
	public static void main(String[] args) {
		
		List<String> s = new ArrayList<>();
		s.add("Shubham");
		s.add("Shubham");
		s.add("Shubham");
		System.out.println(s);
		List<String> res = removeDuplicateValue(s);
		System.out.println(res);
		
		 // int [] arr = {27,57,78,5}; System.out.println(maxValueFromArray(arr));
		 
		
		/*
		 * Student s=new Student(1, "Shubham", "Mumbai"); Student s1=new Student(2,
		 * "Shubham", "UP"); Student s2=new Student(3, "Shubham", "Delhi"); Student
		 * s3=new Student(4, "Ravi", "Mumbai"); Student s4=new Student(5, "ramu",
		 * "Mumbai");
		 * 
		 * List<Student> list= new ArrayList<>(); list.add(s4); list.add(s);
		 * list.add(s1); list.add(s2); list.add(s3); int
		 * count=updateStudentRecordsCount(list); System.out.println(count);
		 */
		
		//System.out.println(checkStringHavingSameCharater("ssss"));
		
		Integer [] arr = {27,57,78,5,6,27,57,5,5,5,27};
		
		
		//System.out.println(kthLargestElement(arr,3));
		
		System.out.println(oddNumberWithTheirFreq(Arrays.asList(arr)));
	}
  //1.Write a method to remove a given value from array list having string values.
	private static List<String> removeGivenString(List<String> sList,String key) {
		Iterator<String> itr=sList.listIterator();
	    while(itr.hasNext()) {
	    	String str=itr.next();
	    	if(str.equalsIgnoreCase(key)) 
	    		itr.remove();
	    }
		return sList;
	}
	
	//2.Write a method to return the maximum value from an integer array passed as an input parameter.
	private static int maxValueFromArray(int [] arr) {
		int max=Integer.MIN_VALUE;
		for(int i : arr) {
			if(i>max) 
			  max=i;
		}
		return max;
	}
	
 //	3.Write a method to update the city attribute of Student object array list passed as an input parameter. If the city is "Mumbai" 
//	then change it to "Delhi". The method should return how many student records were updated.
	private static int updateStudentRecordsCount(List<Student> studentList) {
	     int count=0;
	     for(Student s: studentList) {
	    	 if(s.getCity().equalsIgnoreCase("Mumbai")) {
	    		 s.setCity("Delhi");
	    		 count++;
	    	 }
	     }
		return count;
	}
	
	//4.Write a method to check whether the strings passed as input parameters are made up of the same set of characters.
	private static boolean checkStringHavingSameCharater(String s) {
		char ch[]=s.toCharArray();
		char first=ch[0];
		for(int i=1; i<ch.length; i++) {
			if(first!=ch[i]) {
				return false;
			}
		}
		return true;
	}
	
	//5. Write a method to remove duplicate values from an array list passed as an input parameter.
	private static List<String> removeDuplicateValue(List<String> list) {
	     HashSet<String> set= new HashSet<>();
	     for(String s: list) {
	    	 set.add(s);
	     }
		return new ArrayList<>(set);
	}
	
	//6.Write a method to return the second largest element in an integer array passed as an input parameter.
	private static int kthLargestElement(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i : arr) {
			pq.add(i);
		}
		for (int i = 0; i < k - 1; i++) {
			pq.poll();
		}
		return pq.peek();
	}
	
   //7. Write a method to reverse an integer array passed as an input parameter.
	private static int[] reverseArray(int[] arr) {
	    int s=0;
	    int l=arr.length-1;
	    while(s<l) {
	    	int tmp=arr[s];
	    	arr[s]=arr[l];
	    	arr[l]=tmp;
	    	s++;
	    	l--;
	    }
	    return arr;
	}
	
	//8. Write a method to return the odd numbers and their frequency from an integer array list passed as an input parameter.
	private static Map<Integer, Integer> oddNumberWithTheirFreq(List<Integer> list) {
	     Map<Integer, Integer> oddMapwithFrq= new HashMap<>();
	     for(Integer s: list) {
	    	 if(s%2!=0) {
	    		 if(oddMapwithFrq.containsKey(s)) 
	    			 oddMapwithFrq.put(s, oddMapwithFrq.get(s)+1);
	    		 else 
	    			 oddMapwithFrq.put(s,1);
	    	 }
	     }
		return oddMapwithFrq;
	}
}

class Student{
	private int id;
	private String name;
	private String city;
	public int getId() {
		return id;
	}
	public Student(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}
