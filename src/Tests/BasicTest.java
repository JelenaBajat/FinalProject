package Tests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import Pages.LocationPopupPage;
import Pages.LoginPage;
import Pages.NotificationSistemPage;
import Pages.ProfilePage;

public abstract class BasicTest {

	protected WebDriver driver;
	protected JavascriptExecutor js;
	protected WebDriverWait waiter;
	protected String baseUrl = "http://demo.yo-meals.com";
	protected String customer = "customer@dummyid.com";
	protected String password = "12345678a";
	protected LocationPopupPage locationPopupPage;
	protected LoginPage loginPage;
	protected NotificationSistemPage notificationSistemPage;
	protected ProfilePage profilePage;


	

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.js = (JavascriptExecutor) driver;
		this.waiter = new WebDriverWait(driver, 10);
		this.locationPopupPage = new LocationPopupPage(driver, js, waiter);
		this.loginPage = new LoginPage(driver, js, waiter);
		this.notificationSistemPage = new NotificationSistemPage(driver, js, waiter);
		this.profilePage = new ProfilePage(driver, js, waiter);
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		this.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

//	@AfterClass
//	public void clean() {
//		this.driver.quit();
//	}
	
	@AfterMethod
	public void ifTestFail(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			File src = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src,
					new File("C:\\Users\\Baja\\Desktop\\Itbootcamp\\Zavrsni projekat\\FinalProject\\screenshots\\screenshot.png"));
		}
		driver.manage().deleteAllCookies();
	}
}