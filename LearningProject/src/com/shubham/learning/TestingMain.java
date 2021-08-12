package com.shubham.learning;

import org.apache.commons.lang.StringUtils;

public class TestingMain {
   public static void main(String[] args) {
	
	   String params="operator=mobetisalat&shortCode=9820&param2=4331&param3=%2BFlEGbhK7BhV%2BG4f8ytBpKPzHiTtuRpeEn8weuLgcY4%3D&param1=sourceIP:223.30.211.117";
       System.out.println(getValueFromCommaSeparatedParam3(params,"param3"));
	   
   }
   
   public static String getValueFromCommaSeparatedParam3(String commaSeparatedString, String key) {
	    if (StringUtils.isEmpty(commaSeparatedString)) 
	        return null;
	    if (StringUtils.containsIgnoreCase(commaSeparatedString, key)) {
	        String[] commaBaseSplitArray = commaSeparatedString.split("\\,");
	        for (String keyValue : commaBaseSplitArray) {
	         if(StringUtils.containsIgnoreCase(keyValue, key)) {
	        	 System.out.println(keyValue);
	        	 return StringUtils.trim(keyValue.substring(key.length()+1));
	         }  
	        }
	    }
	    return null;
	}
}
