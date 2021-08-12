package com.overridding;
// Java code to illustrate the
// error caused when we try to
// insert heterogenous objects
import java.util.*;
public class TreeSetDemo {

	public static void main(String[] args)
	{
		Set<StringBuffer> ts = new TreeSet<>();

		// Elements are added using add() method
		ts.add(new StringBuffer("A"));
		ts.add(new StringBuffer("Z"));
		ts.add(new StringBuffer("L"));
		ts.add(new StringBuffer("B"));
		ts.add(new StringBuffer("O"));

		// StringBuffer implements Comparable interface
		System.out.println(ts);
	}
}
