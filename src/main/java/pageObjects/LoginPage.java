package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By emailAddress =By.id("user_email");
	private By passWord=By.id("user_password");
	private By logIn =By.cssSelector("input[value='Log In']");
	private By forgotPassword=By.linkText("Forgot Password?");
	
	public WebElement getEmail()
	{
		return driver.findElement(emailAddress);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(passWord);
	}
	
	public WebElement getLogIn()
	{
		return driver.findElement(logIn);
	}
	
	public ForgotPasswordPage getForgotPassWord()
	{
		driver.findElement(forgotPassword).click();
		return new ForgotPasswordPage(driver);
	}
}
