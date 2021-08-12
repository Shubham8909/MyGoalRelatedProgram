// Java code for serialization and deserialization
// of a Java object
import java.io.*;

public class Demo implements java.io.Serializable
{


	public int a;
	public String b;
	public Employee e;

	// Default constructor
	public Demo(int a, String b, Employee e)
	{
		this.a = a;
		this.b = b;
		this.e=e;
	}

}

class Test
{
	public static void main(String[] args)
	{
		Employee e=new Employee(1, "Shubham", 24);
		Demo object = new Demo(1, "geeksforgeeks",e);
		String filename = "/home/shubhamverma/Documents/Paytm_Confidential/shubham/Personal/WorkSpace/shubh.txt";
		
		// Serialization
		try
		{
			//Saving of object in a file
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);
			
			// Method for serialization of object
			out.writeObject(object);
			
			out.close();
			file.close();
			
			System.out.println("Object has been serialized");

		}
		
		catch(IOException ex)
		{
			System.out.println("IOException is caught"+ex);
		}


		Demo object1 = null;

		// Deserialization
		try
		{
			// Reading the object from a file
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);
			
			// Method for deserialization of object
			object1 = (Demo)in.readObject();
			
			in.close();
			file.close();
			
			System.out.println("Object has been deserialized ");
			System.out.println("a = " + object1.a);
			System.out.println("b = " + object1.b);
			System.out.println("e = " + object1.e);
		}
		
		catch(IOException ex)
		{
			System.out.println("IOException is caught"+ex);
		}
		
		catch(ClassNotFoundException ex)
		{
			System.out.println("ClassNotFoundException is caught");
		}

	}
}
