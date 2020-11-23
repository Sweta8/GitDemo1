package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;

import com.sun.jna.platform.FileUtils;

public class Base {
	
	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException
	{
		prop=new Properties();
		FileInputStream fis =new FileInputStream(System.getProperty("user.dir")+"\\data.properties");
		prop.load(fis);
		//String value=System.getProperty("browser");
		String value=prop.getProperty("browser");
		System.out.println(value);
		if(value.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\swetas\\Documents\\Java_Selenium\\chromedriver_win32 (1)\\chromedriver.exe");
			ChromeOptions options =new ChromeOptions();
			if(value.contains("headless"))
			{
				options.addArguments("headless");
			}
			driver =new ChromeDriver(options);
		}
		else if(value.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\swetas\\Documents\\Java_Selenium\\geckodriver-v0.27.0-win64\\geckodriver.exe");
			driver =new FirefoxDriver();
		}
				
		else if(value.equals("internetexplorer"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Users\\swetas\\Documents\\Java_Selenium\\IEDriverServer_x64_3.150.1\\IEDriverServer.exe");
			driver =new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
			
		}
	public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		org.apache.commons.io.FileUtils.copyFile(src, new File(destinationFile));
		return destinationFile;
		
	}
		
	}

