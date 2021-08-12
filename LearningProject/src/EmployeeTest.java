import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class EmployeeTest {
	
	public static void main(String[] args) {
		
		

		
		 Employee e=new Employee(1,  "Shubham", 24);
		 Employee e1=new Employee(2,  "Shubham", 24);
		 
		 String s= new String("Shubham");
		 
		 String s2= new String("Shubham");
		 
		 System.out.println("String"+s.hashCode());
		 System.out.println("String"+s2.hashCode());
		
	
				 
		/*
		 * Employee e1=new Employee(1, "Shubham", 24); Employee e3=new Employee(1,
		 * "Shubham", 24); Employee e2=new Employee(1, "Shubham", 24);
		 */
			
	    
		
		System.out.println("HashCode :: "+e.hashCode());
		/*
		 * System.out.println("HashCode :: "+e1.hashCode());
		 * System.out.println("HashCode :: "+e2.hashCode());
		 * System.out.println("HashCode :: "+e3.hashCode());
		 */
		
	//	Map<Employee, Integer> empMap= new HashMap<>();

		 HashMap<Employee, String> hm = new HashMap<Employee,String>() ;
		 System.out.println("-->"+hm.hashCode());
		 hm.put(e, "S");
		 hm.put(e1, "S");
		 
		 HashMap<Employee, String> hm1 = new HashMap<Employee,String>() ;
		 System.out.println("-->"+hm1.hashCode());
		 hm1.put(e, "S");
		 hm1.put(e1, "S");
		 
		 
		 
		 System.out.println("1--"+hm.hashCode());
		 System.out.println("1--"+hm1.hashCode());
		// TreeMap<Employee, String> tm = new TreeMap<Employee, String>();
		 
		/*
		 * TreeSet<Employee> t= new TreeSet<>();
		 * 
		 * hm.put(e, "employee 1"); // tm.put(e, "employee 2"); t.add(e);
		 */
		
		/*
		 * empMap.put(e,2); empMap.put(e1,3); empMap.put(e3,4); empMap.put(e2,5);
		 */
		
		System.out.println("Size "+hm.size());
		
		/*
		 * Iterator<Map.Entry<Employee, Integer>> itr =empMap.entrySet().iterator();
		 * while(itr.hasNext()) { Map.Entry<Employee, Integer> emp=itr.next();
		 * System.out.println(emp.getKey().hashCode() +" :hashcode ");
		 * System.out.println(emp.getKey() +" : "+emp.getValue()); }
		 */
		
		
		
	}

}
