package helperClasses;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.FluentWait;

public class Waits {
	
//Implicit Wait
	public void implicitWait(WebDriver driver, int time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		
	}

//Explicit Wait
	public void explicitWait(WebDriver driver, int time, By webelement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.elementToBeClickable(webelement));
		
	}

	public void fluentWait(WebDriver driver, int time, int poll, By webelement) {
		Wait <WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(time))
				.pollingEvery(Duration.ofSeconds(poll))
				.ignoring(StaleElementReferenceException.class);
	}
}
