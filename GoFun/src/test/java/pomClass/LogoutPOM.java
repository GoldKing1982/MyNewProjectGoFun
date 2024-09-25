package pomClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helperClasses.Helper;
import helperClasses.MouseActions;
import helperClasses.PrintToConsole;
import helperClasses.Waits;

public class LogoutPOM {
	
	public WebDriver driver;
	PrintToConsole print = new PrintToConsole();
	MouseActions mouse = new MouseActions();
	Helper helper = new Helper();
	Waits wait = new Waits();
	
	public LogoutPOM(WebDriver browserdriver) {
		this.driver = browserdriver;
		
	}
	
	//Locators for Login page Id and Password
	public String logoutURL = "https://www.gofun88.in/member/?url=index";
	public By logout = By.xpath("//*[text()='Logout']");

	

	public void logOutApp() {
		wait.implicitWait(driver, 20);
		driver.navigate().to(logoutURL);;
		wait.implicitWait(driver, 20);
		mouse.Click(driver, logout);
	}
		
	}
