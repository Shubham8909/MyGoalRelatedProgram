package com.shubham.learning;

public class Person {
	
 private String firstName;
 private Integer id;
 private String lastName;
 private Integer year;
 
   
public Person(String firstName, Integer id, String lastName, Integer year) {
	super();
	this.firstName = firstName;
	this.id = id;
	this.lastName = lastName;
	this.year = year;
}


public String getFirstName() {
	return firstName;
}


public void setFirstName(String firstName) {
	this.firstName = firstName;
}


public Integer getId() {
	return id;
}


public void setId(Integer id) {
	this.id = id;
}


public String getLastName() {
	return lastName;
}


public void setLastName(String lastName) {
	this.lastName = lastName;
}


public Integer getYear() {
	return year;
}


public void setYear(Integer year) {
	this.year = year;
}


@Override
public String toString() {
	return "Person [firstName=" + firstName + ", id=" + id + ", lastName=" + lastName + ", year=" + year + "]";
}
 
 

}
