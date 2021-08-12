package com.shubham.learning;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LambdaFuctionWorking {
	
	public static void main(String[] args) {
		
		List<Person> people=Arrays.asList(
			new Person("Shubham", 1, "Verma", 1994),
			new Person("Vikash", 5, "Yadav", 1996),
			new Person("Tinku", 9, "Kushwah", 1993),
			new Person("Shikhar", 3, "Gupta", 1999)
		);
		
		//printPeople(people);
		people.stream().forEach(System.out ::println);
		Collections.sort(people,(p1,p2)-> p2.getLastName().compareTo(p1.getLastName()));
		System.out.println("After sort by last Name");
		//printPeople(people);
		people.stream().forEach(System.out ::println);
		
		Collections.sort(people,(p1,p2)-> p1.getYear().compareTo(p2.getYear()));
		System.out.println("After sort by Year");
		people.stream().forEach(x -> System.out.println(x));
		
		System.out.println("Start with S all records");
		printPeopleConditional(people ,p -> p.getFirstName().startsWith("S"));
	}

	private static void printPeopleConditional(List<Person> people, Condition condition) {
		for(Person person: people) {
			if(condition.test(person))
			 System.out.println(person);
		}
	}
	private static void printPeople(List<Person> people) {
		for(Person person: people) {
			System.out.println(person);
		}
		
	}

}

interface Condition{
	boolean test(Person p);
}
