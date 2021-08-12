package com.package1;

public class Employee {
	
	private String name;
	private long  empId;
	private long  dptId;

	public Employee(String name, long empId, long dptId) {
		super();
		this.name = name;
		this.empId = empId;
		this.dptId = dptId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	public long getDptId() {
		return dptId;
	}
	public void setDptId(long dptId) {
		this.dptId = dptId;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", empId=" + empId + ", dptId=" + dptId + "]";
	}
	
	

}
