package com.shubham.enums;

// Java code for serialization and deserialization
// of a Java object
import java.io.*;

class Emp implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 transient int a;
	 static int b;
	 String name;
	  int age;
	 transient String pwd;

	// Default constructor
	public Emp(String name, int age, int a, int b,String pwd) {
		this.name = name;
		this.age = age;
		this.a = a;
		Emp.b = b;
		this.pwd=pwd;
	}
	
	private void writeObject(ObjectOutputStream oos) throws Exception
    {
        // to perform default serialization of Account object.
        oos.defaultWriteObject();
  
        // epwd (encrypted password)
        String epwd = "123" + pwd;
  
        // writing encrypted password to the file
        oos.writeObject(epwd);
    }
  
    // this method is executed by jvm when readObject() on
    // Account object reference in main method is executed by jvm.
    private void readObject(ObjectInputStream ois) throws Exception
    {
        // performing default deserialization of Account object
        ois.defaultReadObject();
  
        // deserializing the encrypted password from the file
        String epwd = (String)ois.readObject();
  
        // decrypting it and saving it to the original password
        // string starting from 3rd  index till the last index
        pwd = epwd.substring(3);
    }

}

public class SerialExample {
	public static void printdata(Emp object1) {

		System.out.println("name = " + object1.name);
		System.out.println("age = " + object1.age);
		System.out.println("a = " + object1.a);
		System.out.println("b = " + object1.b);
		System.out.println("b = " + object1.pwd);
	}

	public static void main(String[] args) {
		Emp object = new Emp("ab", 20, 2, 1000,"Morgan");
		String filename = "/home/shubhamverma/Documents/Paytm_Confidential/shubham/Personal/shubham.txt";

		// Serialization
		try {
			// Saving of object in a file
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);
			// Method for serialization of object
			out.writeObject(object);

			out.close();
			file.close();

			System.out.println("Object has been serialized\n" + "Data before Deserialization.");
			printdata(object);

			// value of static variable changed
			object.b = 2000;
		}

		catch (IOException ex) {
			System.out.println("IOException is caught");
		}

		object = null;

		// Deserialization
		try {

			// Reading the object from a file
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);

			// Method for deserialization of object
			object = (Emp) in.readObject();

			in.close();
			file.close();
			System.out.println("Object has been deserialized\n" + "Data after Deserialization.");
			printdata(object);

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
