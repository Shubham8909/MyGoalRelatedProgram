import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Test111 {
	
	public static void main(String[] args) {
		SpCustomer c1= new SpCustomer(1,"Shubham",getDate("2021-06-02"),"Aamu");
		SpCustomer c2= new SpCustomer(2,"Nitin",getDate("2021-03-01"),"Kriti");
		SpCustomer c3= new SpCustomer(3,"Vicky",getDate("2021-05-02"),"Mosi");

		List<Customer> list= new ArrayList<>();
		list.add(c1);
		list.add(c2);
		list.add(c3);
		
		
		
		
		List<Customer> customList=list.stream().
				                  sorted((x1,x2)-> x1.getJoiningDate().compareTo(x2.getJoiningDate()))
				                  .collect(Collectors.toList());
		
		
		
		int sum =list.stream().filter(x->x.getId()>1).mapToInt(x-> x.getId()).sum();
                
		System.out.println("SUM :: "+sum);
		
		OptionalInt count =list.stream().filter(x->x.getId()>5).map(x->x.getId()).mapToInt(x->x).findAny();
		
		System.out.println("SUM :: "+count.isPresent());
		
		/*
		 * list.sort(new Comparator<Customer>() {
		 * 
		 * @Override public int compare(Customer o1, Customer o2) { SpCustomer
		 * sp1=(SpCustomer)o1; SpCustomer sp2=(SpCustomer)o2; return
		 * sp1.getSpName().compareTo(sp2.getSpName()); } });
		 */
		//System.out.println(list);
		
		System.out.println(customList);
	}
	
	public static Date getDate(String str) {
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
		Date d1=null;
		try {
			d1 = sd.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d1;
	}

}




