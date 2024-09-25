package helperClasses;

import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {
	
	public WebDriver browserdriver;

	//Mouseclick
	public void Click(WebDriver driver, By webelement) {
		driver.findElement(webelement).click();
		}
	
}
