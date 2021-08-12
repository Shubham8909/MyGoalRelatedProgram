import java.util.HashMap;
import java.util.Map;

public class ClassA {
	
	public static void main(String[] args) {
		int arr[]= {7,1,5,3,6,4};
		
	    int maxP=Integer.MIN_VALUE;
	    int min=arr[0];
		for(int i=1; i<arr.length;i++) {
			
			 min=Math.min(min, arr[i]);
			int sell=arr[i]-min;
			if(sell>maxP) {
				maxP=sell;
			}
		}
		
		System.out.println("max profit "+maxP);
	
		
				
		
	}
}

 class ClassB {
	 public void m1() {
		 System.out.println(" m1 in class B");
		 this.game();
	 }
	 public void game() {
		 System.out.println("game in class B");
	 } 
}


 class ClassC extends ClassB {
	 
	 public void m1() {
		 super.m1();
		 System.out.println(" m1 in class c");
	 }
	 public void game() {
		 System.out.println("game in class c");
	 }
	 
	 public void game1() {
		 System.out.println("game1 in class c");
	 }

}