package com.shubham.enums;

public enum Colors {
	
	RED("Dangers","Dont go anywhere"),
	GREEN("Nutrals","you can go anywhere"),
	YELLOW("Warning","Alerts ");
	
	private Colors(String action, String massage) {
		this.action = action;
		this.massage = massage;
	}

	private String action;
	private String massage;

	public String getMassage() {
		return massage;
	}
	public String getAction() {
		return action;
	}
	
	public static void main(String[] args) {
		Colors c=Colors.RED;
		System.out.println(c);
		
		Colors c1[]=Colors.values();
		for(Colors c2:c1) {
			System.out.println(c2.name()+" -- "+c2.action+" -- "+c2.massage);
			System.out.println(c2.name()+" -- "+c2.getAction()+" -- "+c2.getMassage()
			);
			System.out.println(c2.ordinal());
		}
	}
}
