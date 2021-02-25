package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage {

	public LoginPage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter) {
		super(driver, js, waiter);
	}

	public WebElement getLoginBtn() {
		return this.driver.findElement(By.linkText("Login"));
	}

	public WebElement getEmail() {
		return this.driver.findElement(By.name("username"));
	}

	public WebElement getPassword() {
		return this.driver.findElement(By.name("password"));
	}

	public WebElement getRememberMe() {
		return this.driver.findElement(By.name("remember_me"));
	}

	public WebElement getLoginBtnSecond() {
		return this.driver.findElement(By.name("btn_submit"));
	}

	public WebElement getFacebookLogin() {
		return this.driver.findElement(By.linkText("FACEBOOK"));
	}

	public WebElement getGoogleLogin() {
		return this.driver.findElement(By.linkText("GOOGLE"));
	}

	public WebElement getSignUpNow() {
		return this.driver.findElement(By.linkText("Signup Now"));
	}

	public void loginMember(String email, String password) {
		this.getEmail().clear();
		this.getPassword().clear();
		this.getEmail().sendKeys(email);
		this.getPassword().sendKeys(password);
		this.getLoginBtnSecond().click();
	}
}
