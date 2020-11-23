package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPasswordPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base {
	

	WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException
	{
		driver= initializeDriver();
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		
	}
	
	@Test(dataProvider="getData")
	public void baseNavigation(String userName,String passWord) throws IOException, InterruptedException
	{
	
		driver.get(prop.getProperty("url"));
		LandingPage l=new LandingPage(driver);
		LoginPage lp=l.getLogin();
		lp.getEmail().sendKeys(userName);
		lp.getPassword().sendKeys(passWord);
		ForgotPasswordPage f=lp.getForgotPassWord();
		f.getemailAddress().sendKeys(userName);
		f.getsendInstruction().click();
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data =new Object[2][2];
		data[0][0]="swetacjc@gmail.com";
		data[0][1]="123456";
		data[1][0]="swetan";
		data[1][1]="12345";
		return data;
	}

}
