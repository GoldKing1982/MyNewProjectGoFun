package pomClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helperClasses.Helper;
import helperClasses.MouseActions;
import helperClasses.PrintToConsole;
import helperClasses.Waits;

public class FillStakePOM {
	
	public WebDriver driver;
	PrintToConsole print = new PrintToConsole();
	MouseActions mouse = new MouseActions();
	Helper helper = new Helper();
	Waits wait = new Waits();
	
	
	public FillStakePOM(WebDriver browserdriver) {
		this.driver = browserdriver;

	}
	
	//locator for menu
	public By hamMenuButton = By.xpath("//button[@class='sc-DNdyV eNzCzF']");
	
	//locator click second game
	public By secondGame = By.xpath("(//span[@class='sc-gacfCG iSNGzL'])[1]");
	
	//locator  second team
	public By secondTeam = By.xpath("(//div[@class='sc-bEjcJn hfQiAE'])[2]");
	
	//locator for score card
	public By scoreClick = By.xpath("(//div[@class='sc-kUaPvJ kORNuz'])[1]");
	
	//locator for 50 points button
	public By fiftyPoints = By.xpath("(//button[@class='sc-jnlKLf psNAq'])[1]");
	
	//locator for 100 point button
	public By hundredPoints = By.xpath("(//button[@class='sc-jnlKLf psNAq'])[2]");
	
	//locator for placing bet button
	public By placeBet = By.xpath("//button[@class='sc-feJyhm SLJo']");
	
	//locator for error msg
	public By errorMsg = By.xpath("//*[text()='Not enough balance']");
	
	
	public void placeBet() {
		
		mouse.Click(driver, hamMenuButton);
		wait.explicitWait(driver, 20, secondGame);
		mouse.Click(driver, secondGame);
		print.printToConsole("second game clicked");
		wait.explicitWait(driver, 40, secondTeam);
		mouse.Click(driver, secondTeam);
		print.printToConsole("second team clicked");
		wait.explicitWait(driver, 40, scoreClick);
		mouse.Click(driver, scoreClick);
		print.printToConsole("Score  clicked");
		wait.explicitWait(driver, 40, fiftyPoints);
		mouse.Click(driver, fiftyPoints);
		print.printToConsole("50 clicked");
		wait.explicitWait(driver, 40, hundredPoints);
		mouse.Click(driver, hundredPoints);
		print.printToConsole("100 clicked");
		wait.explicitWait(driver, 40, placeBet);
		mouse.Click(driver, placeBet);
		
	}

}
