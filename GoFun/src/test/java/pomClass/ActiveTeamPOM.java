package pomClass;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import helperClasses.Driver;
import helperClasses.Helper;
import helperClasses.MouseActions;
import helperClasses.PrintToConsole;
import helperClasses.Waits;

public class ActiveTeamPOM{
	
	public WebDriver driver;
	PrintToConsole print = new PrintToConsole();
	MouseActions mouse = new MouseActions();
	Waits wait = new Waits();
	
	
	public ActiveTeamPOM(WebDriver browserdriver) {
		this.driver = browserdriver;

	}
	
	public By menuButton = By.xpath("//div[@class='hamburger d-none-h5']");
	
	public By exchangeButton = By.xpath("//i[@class='ico-exchange']");
	
	public By hamMenuButton = By.xpath("//button[@class='sc-DNdyV eNzCzF']");
	
	//locator for first game
	public By firstGame = By.xpath("//div[@class='sc-jXQZqI sc-fgfRvd ewZJim']//following::div[@name='cricket']");
	
	//locator for second game
	public By secondGame = By.xpath("//div[@class='sc-jXQZqI sc-fgfRvd ewZJim']//following::div[@name='football']");
	
	//locator for third game
	public By thirdGame = By.xpath("//div[@class='sc-jXQZqI sc-fgfRvd ewZJim']//following::div[@name='volleyball']");
	
	//locator for fourth game
	public By fourthGame = By.xpath("//div[@class='sc-jXQZqI sc-fgfRvd ewZJim']//following::div[@name='tennis']");
		
	//locator for fifth game
	public By fifthGame = By.xpath("//div[@class='sc-jXQZqI sc-fgfRvd ewZJim']//following::div[@name='horse']");
	
	//locator for sixth game
	public By sixthGame = By.xpath("//div[@class='sc-jXQZqI sc-fgfRvd ewZJim']//following::div[@name='greyhound']");
	
	//locator for popup
	public By popUp = By.xpath("//*[text()='OK']");
	
	public void activeGames(){
		//handling alert
		wait.implicitWait(driver, 20);
		try {
		mouse.Click(driver, popUp);
			
		} catch (Exception e) {
			
		}
		
		wait.explicitWait(driver, 40, menuButton);
		mouse.Click(driver, menuButton);
		wait.explicitWait(driver, 30, exchangeButton);
		mouse.Click(driver, exchangeButton);
		wait.implicitWait(driver, 30);
		driver.switchTo().frame(0);
		wait.implicitWait(driver, 30);

		try {
			if (driver.findElement(firstGame).isEnabled()) {
				System.out.println("CRICKET");
			}
		} catch (Exception e) {

		}
		try {
			if (driver.findElement(secondGame).isEnabled()) {
				System.out.println("FOOTBALL");
			}
		} catch (Exception e) {

		}

		try {
			if (driver.findElement(thirdGame).isEnabled()) {
				System.out.println("VOLLEYBALL");
			}
		} catch (Exception e) {

		}

		try {
			if (driver.findElement(fourthGame).isDisplayed()) {
				System.out.println("TENNIS");
			}
		} catch (Exception e) {

		}

		try {
			if (driver.findElement(fifthGame).isDisplayed()) {
				System.out.println("HORSE");
			}
		} catch (Exception e) {
		}
		try {
			if (driver.findElement(sixthGame).isDisplayed()) {
				System.out.println("GREYHOUND");
			}
		} catch (Exception e) {
		}
	}
	
	public void activeTeams(){
		List<WebElement> teams = driver.findElements(By.xpath("//div[@class='sc-jXQZqI sc-fgfRvd ewZJim']//following::div[@class='sc-bEjcJn hfQiAE']"));
		for (WebElement webElement : teams) {
			System.out.println(webElement.getText());
			}
		}
	}
