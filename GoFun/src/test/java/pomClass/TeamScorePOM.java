package pomClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helperClasses.Helper;
import helperClasses.MouseActions;
import helperClasses.PrintToConsole;
import helperClasses.Waits;

public class TeamScorePOM {
	
	public WebDriver driver;
	PrintToConsole print = new PrintToConsole();
	MouseActions mouse = new MouseActions();
	Helper helper = new Helper();
	Waits wait = new Waits();
	
	
	public TeamScorePOM(WebDriver browserdriver) {
		this.driver = browserdriver;

	}
	
	//locator for main menu
	
	public By mainMenuButton = By.xpath("(//button[@class='sc-bIKvTM jKzhOQ'])[1]");
	
	//locator for active teams scores
	
	public By activeTeamScore = By.xpath("//div[@class='sc-cpmKsF hUpZgO']//following::div[@class='sc-gPWkxV gbgwkq']");
	
	public void printTeamScore() {
		wait.implicitWait(driver, 30);
		print.printConsoleLine();
		print.printToConsole("=================ACTIVE TEAM SCORE=====================");
		
		List<WebElement> teamScore = driver.findElements(activeTeamScore);
		
		for (WebElement webElement : teamScore) {
			System.out.println(webElement.getText());
			}
				}
	}
