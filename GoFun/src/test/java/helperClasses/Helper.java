package helperClasses;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

//Method to Get text 	
	public String getText(WebDriver driver, By webelement) {
		String text = driver.findElement(webelement).getText();
		return text;		
	}
	
//Method to Send text
	public void sendText(WebDriver driver, By webelement, String Text) {
		driver.findElement(webelement).sendKeys(Text);		
		
	}
//Take Screenshot	
	public void screenShot(WebDriver driver) throws IOException {
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File desig = new File(System.getProperty("user.dir")+"/Screenshots/"+System.currentTimeMillis()+".png");
		FileHandler.copy(source, desig);

		
	}

}
