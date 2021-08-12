import java.util.ArrayList;
import java.util.List;

public class GCStringTest {
	
	public static <T> void main(String[] args) throws InterruptedException {
		
	//	String str= new String("Shubham");
		Shubham str= new Shubham("Shubham");
	   

		str=null;
		System.gc();
		Thread.sleep(1000);
		System.out.println("end methods...");
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println(" Call finalized method.");
	}
	
}
	
	 final class Shubham{

		String name;
		public Shubham(String name) {
			this.name=name;
		}
		

	
	}


