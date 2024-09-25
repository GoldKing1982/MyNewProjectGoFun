package helperClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
	
	public static WebDriver browserdriver;
	PrintToConsole print = new PrintToConsole();  	
	
//Initializing chrome driver
	public void initializeChromeDriver () {
		print.printToConsole("Initializing Browser");
		browserdriver = new ChromeDriver();
		browserdriver.manage().window().maximize();
		print.printToConsole("Maximizing Browser");
	
}
//Navigate to URL
	public void navigateTo(String URL) {
		browserdriver.navigate().to(URL);
		print.printToConsole("Navigating to " + URL);		
	}
	
	public void getURL(String URL) {
		browserdriver.get(URL);
		print.printToConsole("Navigating to " + URL);
	}

//Display Title
	public void getTitle() {
		String Title = browserdriver.getTitle();
			
	}
	
	public void Refresh() {
		browserdriver.navigate().refresh();		
	}
//Exit Browser
	public void exitBrowser() {
		browserdriver.quit();
		print.printToConsole("Exiting Browser");
	}
	
	
}