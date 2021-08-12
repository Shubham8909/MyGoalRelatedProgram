package com.testing;

public class Tweet {
	
	private boolean flag;

	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	@Override
	public String toString() {
		return "Tweet [flag=" + flag + "]";
	}
}
