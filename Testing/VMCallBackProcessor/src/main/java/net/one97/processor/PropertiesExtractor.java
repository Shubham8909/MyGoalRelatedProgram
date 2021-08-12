package net.one97.processor;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import org.apache.log4j.Logger;

public class PropertiesExtractor {

	private static final Logger log = Logger.getLogger(PropertiesExtractor.class);
	private static Properties properties;
	static {
		properties = new Properties();
		URL url = new PropertiesExtractor().getClass().getClassLoader().getResource("application.properties");
		try {
			properties.load(new FileInputStream(url.getPath()));
		} catch (IOException e) {
			log.info("@Exception while getting data from application.properties  " + e);
		}
	}
	public static String getProperty(String key) {
		return properties.getProperty(key);
	}
}