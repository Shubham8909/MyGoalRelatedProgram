import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentModificationException {

	public static void main(String[] args) {
		
		ConcurrentHashMap <String,Integer> map= new ConcurrentHashMap<>();
		System.out.println(map.put("Shubham", 1));
		System.out.println(map.put("Shubham", 4));
		map.put("Nitin", 2);
		map.put("Ravi", 3);
		
		Iterator<Map.Entry<String, Integer>> itr=map.entrySet().iterator();
		while(itr.hasNext()){
			itr.remove();
			Map.Entry<String, Integer> entry=itr.next();
			System.out.println(" "+entry.getKey()+" -- "+entry.getValue());
			 
		}
		System.out.println(map.size());
		
		List<Integer> list= new ArrayList<>();
	     list.add(1);
	     list.add(3);
	     list.add(12);
	     
	     Iterator<Integer> it= list.listIterator();
	     while(it.hasNext()) {
	    	 int x=it.next();
	    	 it.remove();
	    	 System.out.println(" x"+x);
	     }
	     
	     System.out.println(list.size());
	   
	     CopyOnWriteArrayList<Integer> c= new CopyOnWriteArrayList<>();
	     c.add(1);
	     c.remove(0);
	     
	     Iterator<Integer> itc= c.listIterator();
	     
	     itc.remove();
	     
	}
	
	

}
