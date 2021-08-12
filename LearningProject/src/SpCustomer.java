import java.util.Date;

public class SpCustomer extends Customer{
	
	private String spName;

	public String getSpName() {
		return spName;
	}
	public void setSpName(String spName) {
		this.spName = spName;
	}
	public SpCustomer(int id, String name, Date joiningDate, String spName) {
		super(id, name, joiningDate);
		this.spName = spName;
	}

}
