package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	
	public String getGlobalValue(String key) throws IOException {
		// Method to fetch global property
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/config.properties");
		prop.load(fis);
		return prop.getProperty(key);

	}
	
	

}
