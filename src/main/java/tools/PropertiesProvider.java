package tools;

import java.io.IOException;
import java.util.Properties;

public class PropertiesProvider {
	private static Properties prop;
	
	static {
		prop = new Properties();
		try {
			prop.load(Properties.class.getResourceAsStream("/test.properties"));
			prop.load(Properties.class.getResourceAsStream("/crsms.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String propertyName) {
        return prop.getProperty(propertyName);
    }
}
