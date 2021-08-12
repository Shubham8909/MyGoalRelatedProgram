
public class CheckpassByValue {
	
	public static void main(String[] args) {
		Employee e= new Employee(1, "ramu", 30);
		System.out.println(" B i "+e);
		changed(e.name);
		System.out.println(" A i "+e);
	}
	private static void changed(String s) {
		s="kurru";
		System.out.println(" In me i "+s);
	}
}
