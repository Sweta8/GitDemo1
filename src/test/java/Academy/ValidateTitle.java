package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class ValidateTitle extends Base {
	
	public static Logger log=LogManager.getLogger(Base.class.getName());
	
	WebDriver driver;
	@Test
	public void pNet() throws IOException
	{
		
		LandingPage l=new LandingPage(driver);
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES123");
		log.info("validate courses");
		
	}
	@BeforeTest
	public void initialize() throws IOException
	{
		driver= initializeDriver();
		driver.get(prop.getProperty("url"));
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		
		
	}
	
	

}
