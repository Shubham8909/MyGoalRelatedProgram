package com.cleartrip.properties.utils;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import com.cleartrip.properties.model.Command;

public interface CommanUtils {
	
	static Command createCommand(String commad) {
		System.out.println(commad);
		String values[]=commad.split(",");
		String commandNmae= values[0];
		values=ArrayUtils.remove(values, 0);
		List<String> params=Arrays.asList(values);
		return new Command(commandNmae, params);
	}
}