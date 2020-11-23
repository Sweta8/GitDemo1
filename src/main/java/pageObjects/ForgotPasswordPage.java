package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {
	
	WebDriver driver;
	public ForgotPasswordPage(WebDriver driver)
	{
		this.driver=driver;
	}

	private By emailAddress= By.id("user_email");
	private By sendInstruction=By.cssSelector("input[value='Send Me Instruction']");
	
	
	public WebElement getemailAddress()
	{
		return driver.findElement(emailAddress);
	}
	
	public WebElement getsendInstruction()
	{
		return driver.findElement(sendInstruction);
	}
	
}
