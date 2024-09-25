package testScript;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import helperClasses.Driver;
import helperClasses.Helper;
import helperClasses.PrintToConsole;
import helperClasses.Waits;
import pomClass.ActiveTeamPOM;
import pomClass.FileIS;
import pomClass.FillStakePOM;
import pomClass.LoginPOM;
import pomClass.LogoutPOM;
import pomClass.TeamScorePOM;

public class GoFunTScript {

	Driver driver = new Driver();
	PrintToConsole print = new PrintToConsole();
	Waits wait = new Waits();
	Helper helper = new Helper();

	// Objects for Extent Report
	ExtentReports extentReport;
	ExtentSparkReporter htmlReporter = new ExtentSparkReporter("htmlReporter.html");
	ExtentTest testCase;
	
	public String fileProp1(String userName) throws IOException {
		FileInputStream stream = new FileInputStream("config.properties");
		Properties properties = new Properties();
		properties.load(stream);
		userName = properties.getProperty("username");
		return userName;
		
	}
	
	public String fileProp2(String passWord) throws IOException {
		FileInputStream stream = new FileInputStream("config.properties");
		Properties properties = new Properties();
		properties.load(stream);
		passWord = properties.getProperty("password");
		return passWord;
		
	}
	
	
		
 @Test(priority =0)
	public void beforeTest() {

		// Extent report creation
		extentReport = new ExtentReports();
		htmlReporter = new ExtentSparkReporter("ExtentReporter_GoFun88.html");
		extentReport.attachReporter(htmlReporter);
		

		// initializing driver
		driver.initializeChromeDriver();

	}

	@Test(dependsOnMethods = {"beforeTest"}, priority = 1)
	public void initializePage() throws IOException {

		LoginPOM login = new LoginPOM(driver.browserdriver);
		
		
		// Extent Report Message
		testCase = extentReport.createTest("Opening Home Page");

		// Logging in to home page

		try {
			print.printToConsole(" --------------------------------");
			print.printToConsole("| THIS IS GO FUN 88 RUN -  1 |");
			print.printToConsole(" --------------------------------");
			print.printToConsole(" ");
			driver.navigateTo(login.loginPageURL);
			wait.implicitWait(driver.browserdriver, 10);
			print.printToConsole("---------------Verify Home Page-------------");
			login.verifyLoginPage();
			
			print.printConsoleLine();
		} catch (Exception e) {
			print.printToConsole(e.getMessage());
			testCase.log(Status.FAIL, " Launching GoFun88 Homepage Failed");
		}
		// Creating report
		extentReport.flush();
	}

	@Test(dependsOnMethods = {"beforeTest"}, priority = 2)
	public void loginPage() {
		LoginPOM login = new LoginPOM(driver.browserdriver);
		GoFunTScript gofun = new GoFunTScript();
		
		// Extent Report Message
		testCase = extentReport.createTest("Log in Page");

		// Verifying page and logging in
		try {

			login.userLogin(gofun.fileProp1(null), gofun.fileProp2(null));
			print.printToConsole("Logged in");
		} catch (Exception e) {
			print.printToConsole(e.getMessage());
			testCase.log(Status.FAIL, "Login Failed");
		}
		// Creating report
		extentReport.flush();

	}

	@Test(dependsOnMethods = {"beforeTest"}, priority = 3)
	public void verifyActiveGames() {

		ActiveTeamPOM active = new ActiveTeamPOM(driver.browserdriver);
		// Extent report title
		testCase = extentReport.createTest("Verifying Active Game Page");

		try {
			print.printConsoleLine();
			print.printToConsole("========================= LIST OF ACTIVE GAMES =====================");
			print.printToConsole(" ");
			active.activeGames();
			print.printToConsole(" ");
			print.printConsoleLine();
			print.printToConsole("========================= LIST OF ACTIVE TEAMS =====================");
			print.printToConsole(" ");
			active.activeTeams();
			
		} catch (Exception e) {
			print.printToConsole(e.getMessage());
			testCase.log(Status.FAIL, "Fetching Active Games Failed");
		}
		// Creating report
		extentReport.flush();
	}

	@Test(dependsOnMethods = {"beforeTest"}, priority = 4)
	public void teamScore() {
		TeamScorePOM score = new TeamScorePOM(driver.browserdriver);
		// Extent report title
		testCase = extentReport.createTest("Retriving Scores Page");
		try {
			print.printToConsole("========================SCORES OF ACTIVE TEAMS=====================");
			print.printToConsole("");
			score.printTeamScore();
			print.printConsoleLine();
		} catch (Exception e) {
			print.printToConsole(e.getMessage());
			testCase.log(Status.FAIL, "Fetching Team Score Failed");
		}
		// Creating report
		extentReport.flush();
	}

	@Test(dependsOnMethods = {"beforeTest"}, priority = 5)
	public void fillStake() {

		// Extent report title
		testCase = extentReport.createTest("Fixing Bet Page");
		FillStakePOM fillstake = new FillStakePOM(driver.browserdriver);

		try {
			print.printToConsole("===========================FILLING TEAM BET============================");
			fillstake.placeBet();
			print.printToConsole("================ T A K I N G S C R E E N S H O T =======================");
			wait.explicitWait(driver.browserdriver, 0, fillstake.errorMsg);;
			helper.screenShot(driver.browserdriver);
		} catch (Exception e) {
			print.printToConsole(e.getMessage());
			testCase.log(Status.FAIL, "Fixing Bet Failed");
		}
		// Creating report
		extentReport.flush();
	}
	
	
	@Test(priority=6)
	public void afterTest() {
			// Extent report title
			testCase = extentReport.createTest("Logging Out");
			
			try {
			LogoutPOM logout = new LogoutPOM(driver.browserdriver);
			print.printToConsole("===========================LOGGING OUT============================");
			logout.logOutApp();
			wait.implicitWait(driver.browserdriver, 30);
			print.printToConsole("===========================EXITING BROWSER===========================");
			driver.exitBrowser();
		} catch (Exception e) {
			print.printToConsole(e.getMessage());
			testCase.log(Status.FAIL, "Logout Failed");
			}
			// Creating report
			extentReport.flush();
	}
}
