package pomClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class FileIS {
	
	public WebDriver driver;
	
	public FileIS(WebDriver browserdriver) {
		this.driver = browserdriver;

	}
	
	public void fileProperties() throws IOException {
		FileInputStream stream = new FileInputStream("config.properties");
		Properties properties = new Properties();
		properties.load(stream);
		String userName = properties.getProperty("username");
		String passWord = properties.getProperty("password");
	}
	

}
