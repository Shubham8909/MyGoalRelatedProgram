import java.util.Stack;

public class StackQueue{
	   static Stack<Integer> s1 = new Stack<Integer>();
	   static Stack<Integer> s2 = new Stack<Integer>();
	
	public static void main(String[] args) {
		Push(2);
		Push(3);
		int x=Pop();
		Push(4);
		int y=Pop();
		String s="3313";
		int ee=s.charAt(2);
		
		System.out.println("ee "+ee);
		
		System.out.println(x+"   "+y);
	}
   

    //Function to push an element in queue by using 2 stacks.
     static void Push(int x)
    {
	   s1.push(x);
    }
	
    
    //Function to pop an element from queue by using 2 stacks.
     static  int Pop()
    {
	   while(s1.size()>1){
	       s2.push(s1.pop());
	   }
	   if(s1.isEmpty()) return -1;
	   int returValue=s1.pop();
	    while(!s2.isEmpty()){
	       s1.push(s2.pop());
	   }
	   return returValue;
    }
    
    
}