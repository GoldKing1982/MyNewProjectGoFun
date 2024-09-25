package pomClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.interactions.Actions;

import helperClasses.Helper;
import helperClasses.MouseActions;
import helperClasses.PrintToConsole;
import helperClasses.Waits;

public class LoginPOM {
	
	public WebDriver driver;
	PrintToConsole print = new PrintToConsole();
	MouseActions mouse = new MouseActions();
	Helper helper = new Helper();
	Waits wait = new Waits();
	
	public LoginPOM(WebDriver browserdriver) {
		this.driver = browserdriver;
		
	}
	//URL for Login Page 
	
	public String loginPageURL ="https://www.gofun88.in/";
	
	
	//Locators for Login page Id and Password
	public By enterButton = By.id("loginBtn");
	public By userNameTextBox = By.xpath("//input[@id='lphone']");
	public By passwordTextBox = By.xpath("//input[@id='lpwd']");
	public By loginButton = By.xpath("//a[@id='gologin']");
	
	//Locator for page title
	public String pageTitles = "Fun88 India Official - Online Sports Betting & Live Casino Games";
	
	
	//Method to verify login page
	
	 public void verifyLoginPage() {
	  String text = driver.getTitle();
	  Assert.assertEquals(text,
	 "Fun88 India Official - Online Sports Betting & Live Casino Games");
	  print.printToConsole(text);
	 }
	 
	
	//Method to login the application
	public void userLogin(String Username, String Password) {
		try {
		driver.findElement(enterButton).click();
		wait.implicitWait(driver, 20);
		print.printToConsole("Logging In......");
		print.printToConsole(" ");
		driver.findElement(userNameTextBox).sendKeys(Username);
		driver.findElement(passwordTextBox).sendKeys(Password);
		mouse.Click(driver, loginButton);		
		print.printConsoleLine();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	

}
