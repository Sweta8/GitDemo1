package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By signIn = By.xpath("//span[text()='Login']");
	
	private By featuredText= By.xpath("//h2[text()='Featured Courses']");
	private By popUp=By.xpath("//button[text()='NO THANKS']");
	
	public LoginPage getLogin()
	{
		driver.findElement(signIn).click();
		return new LoginPage(driver);
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(featuredText);
	}
	
	public int getPopUpSize()
	{
		return driver.findElements(popUp).size();
	}
	
	public WebElement getPopUp()
	{
		return driver.findElement(popUp);
	}
	

}
