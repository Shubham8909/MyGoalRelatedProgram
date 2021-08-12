import java.util.Date;

public class Customer {
	private int id;
	private String name;
	private Date joiningDate;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", id=" + id + ", joiningDate=" + joiningDate + "]";
	}
	public Customer(int id, String name, Date joiningDate) {
		super();
		this.id = id;
		this.name = name;
		this.joiningDate = joiningDate;
	}

	
	
}
