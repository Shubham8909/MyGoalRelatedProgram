package com.collaboration.story.challenge.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertiesExtractor {
	
	final static Logger logger = LoggerFactory.getLogger(PropertiesExtractor.class);

	private static Properties properties;
	static {
		properties = new Properties();
		URL url = new PropertiesExtractor().getClass().getClassLoader().getResource("application.properties");
		try {
			properties.load(new FileInputStream(url.getPath()));
		} catch (IOException e) {
			logger.info("@Exception while getting data from application.properties  " + e);
		}
	}
	public static String getProperty(String key) {
		return properties.getProperty(key);
	}
}