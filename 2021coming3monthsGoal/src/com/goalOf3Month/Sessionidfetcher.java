package com.goalOf3Month;

import java.util.Random;

public class Sessionidfetcher {

	public static long getSessionIdExpireTime = 0;
	public static String sessionId = null;

	public static void main(String[] args) {
       while(true) {
    	   try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	   String sId=getSeeionId();
    	   System.out.println("session Id "+sId);
       }
	}

	private static String getSeeionId() {
		long currentTime=System.currentTimeMillis();
		String session=null;
		if(getSessionIdExpireTime!=0 && getSessionIdExpireTime> currentTime) {
			session=sessionId;
			System.out.println("Session Id is expire  time is "+(getSessionIdExpireTime-currentTime)/1000+" seconds." );
		}else {
			session=String.valueOf(new Random().nextInt(1000));
			System.out.println(" session id generate "+session);
			if(session!=null) {
				sessionId=session;
				//82800000
				getSessionIdExpireTime=System.currentTimeMillis()+82800000;
			}
		}
		return session;
		
	}

}
