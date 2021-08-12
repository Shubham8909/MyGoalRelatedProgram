package com.shubham.enums;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Student implements Serializable {

	private static final long serialVersionUID = 5933633406199567924L;
	 transient int a;
	 static int b;
	 String name;
	  int age;
	 transient String pwd;

	// Default constructor
	public Student(String name, int age, int a, int b,String pwd) {
		this.name = name;
		this.age = age;
		this.a = a;
		Emp.b = b;
		this.pwd=pwd;
	}
	
     public Student() {
    	 
     }
	




	@Override
	public String toString() {
		return "Student [a=" + a + ", name=" + name + ", age=" + age + ", pwd=" + pwd + "]";
	}







	public static void main(String[] args) {
		Customer c=new Customer();
		c.name="rolaa";
		Student object = new Student("ab", 20, 2, 1000,"Morgan");
		String filename = "/home/shubhamverma/Documents/Paytm_Confidential/shubham/Personal/shubham.txt";

		// Serialization
		try {
			// Saving of object in a file
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);
			// Method for serialization of object
			out.writeObject(object);
			out.writeObject(c);

			out.close();
			file.close();

			System.out.println("Object has been serialized\n" + "Data before Deserialization.");


			// value of static variable changed
			object.b = 2000;
		}

		catch (IOException ex) {
			System.out.println("IOException is caught"+ex.getMessage());
			ex.printStackTrace();
		}
	
	object = null;
	c=null;

	// Deserialization
	try {

		// Reading the object from a file
		FileInputStream file = new FileInputStream(filename);
		ObjectInputStream in = new ObjectInputStream(file);

		// Method for deserialization of object
		object= (Student) in.readObject();
		c= (Customer) in.readObject();
		
			/*
			 * if(o instanceof Student) { object=(Student)o; } if(o instanceof Customer) {
			 * c=(Customer) o; }
			 */
		in.close();
		file.close();
		System.out.println("Object has been deserialized\n" + "Data after Deserialization.");
        System.out.println(object);
        System.out.println(c);
		// System.out.println("z = " + object1.z);
	}

	catch (IOException ex) {
		System.out.println("IOException is caught");
	}

	catch (ClassNotFoundException ex) {
		System.out.println("ClassNotFoundException" + " is caught");
	}
}
}
