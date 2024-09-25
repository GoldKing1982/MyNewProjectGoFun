package testScript;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Runc {

	
	public String fileProp1(String userName) throws IOException {
		FileInputStream stream = new FileInputStream("config.properties");
		Properties properties = new Properties();
		properties.load(stream);
		userName = properties.getProperty("username");
		return userName;
		
	}
	public static void main(String[] args) throws IOException {
		Runc runcc = new Runc();
		System.out.println(runcc.fileProp1(null));

	}

}
