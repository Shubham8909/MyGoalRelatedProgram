
public class PassByvalue {
	
	public static void main(String[] args) {
		
		StringBuilder sb= new StringBuilder("Shubham");
	    String value="verma";
	    changeMathod(sb,value);
	    sb=null;
	    System.out.println("String "+value+" sb "+sb);
		
	}

	private static void changeMathod(StringBuilder sb, String value) {
		sb.append("Soft");
		value=value+" Verma";
	}

}
