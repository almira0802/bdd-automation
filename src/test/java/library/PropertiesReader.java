package library;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesReader {
	
	
	private Properties pro;
	private FileInputStream file;
	private String filePath;
	private String value;
	
	public PropertiesReader() {
		pro = new Properties();
		filePath = "src/test/resources/application.properties";
		
	}
	public String getData(String key) {
		try {
		file = new FileInputStream(filePath);
		pro.load(file);
		value = pro.getProperty(key);
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return value;
	}
	public static void main(String [] args) {
		PropertiesReader pr = new PropertiesReader();
		System.out.println(pr.getData("browser"));
	}

}
