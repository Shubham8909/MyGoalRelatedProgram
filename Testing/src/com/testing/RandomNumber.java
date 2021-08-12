package com.testing;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class RandomNumber {

	public static void main(String[] args) {
		
		
      System.out.println(getRandomNumberUsingInts(1,10));
      System.out.println(getRandomNumberUsingInts(1,10));
      System.out.println(getRandomNumberUsingInts(1,10));
      System.out.println(getRandomNumberUsingInts(1,10));
      System.out.println(getRandomNumberUsingInts(1,10));
      
      System.out.println(getRandomNumber(20,31));
      
      System.out.println((int)Math.random());
      
      String s =UUID.randomUUID().toString();
          Instant plusSeconds = new Date().toInstant().plusSeconds(10000);
          plusSeconds.isBefore(new Date().toInstant());
	}
	
	public static int getRandomNumberUsingInts(int min, int max) {
	    Random random = new Random();
	    return random.ints(min, max)
	      .findFirst()
	      .getAsInt();
	}
	
	public static int getRandomNumber(int min, int max) {
	    return (int) ((Math.random() * (max - min)) + min);
	}
	
	public int getRandomNumberUsingNextInt(int min, int max) {
	    Random random = new Random();
	    return random.nextInt(max - min) + min;
	}

}
