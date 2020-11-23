package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class StepDefinition extends Base {
	
	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver=initializeDriver();
	}

	@Given("^Navigate to \"([^\"]*)\" site$")
	public void navigate_to_site(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.get(arg1);
	    
	}

	@Given("^Click on Login lnk in home page to land on secure sign in page$")
	public void click_on_Login_lnk_in_home_page_to_land_on_secure_sign_in_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		LandingPage l=new LandingPage(driver);
		if(l.getPopUpSize()>0)
		{
			l.getPopUp().click();
		}
		l.getLogin();
	   
	}
	
	@When("^User enters (.+) and (.+) and logs in$")
    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
		LoginPage lp=new LoginPage(driver);
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.getLogIn().click();
    }

	

	@Then("^verify user is logged in$")
	public void verify_user_is_logged_in() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	
	 @And("^close all chrome browsers$")
	    public void close_all_chrome_browsers() throws Throwable {
	       
		 driver.quit();
	    }
}
