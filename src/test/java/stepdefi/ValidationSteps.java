package stepdefi;

import java.io.IOException;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjects.ValidationPage;
import pageobjects.freelist;
import pageobjects.gym;

public class ValidationSteps{
	
    public 	ValidationPage validation;
	public freelist free;
	public gym gyminfo;
	public WebDriver driver;
	public Properties p;
	
	
	@Given("user is on the justdail page")
	public void user_is_on_the_justdail_page() {
		driver=Hooks.driver;
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		validation = new ValidationPage(driver);
	}

	@Then("click on later button")
	public void click_on_later_button() throws InterruptedException, IOException {
		
		validation.clicklater();
		Hooks.ScreenShots("mainpage.png");
	   }
	@Then("select location")
	public void select_location() throws InterruptedException, IOException {
		validation.clicklocation();
		Hooks.ScreenShots("location.png");
	}

	@Then("select current location")
	public void select_current_location() throws InterruptedException, IOException {
	    
	    validation.clickdetect();
	    Hooks.ScreenShots("detect.png");
	    
	}

	@Then("click on search bar")
	public void click_on_search_bar() throws InterruptedException {
	  validation.clicksearchbar();	}

	@Then("search carwash")
	public void search_carwash() throws InterruptedException, IOException {
	   validation.sendcarwash();
	   Hooks.ScreenShots("searchcarwash.png");
	}

	@Then("click on search")
	public void click_on_search() throws InterruptedException {
		//validation.clicksearchbar();
		
	}

	@Then("click on applyfilter")
	public void click_on_applyfilter() throws InterruptedException, IOException {
		Hooks.ScreenShots("nonfilterlist.png");
		validation.filterapply();
	}

	@Then("scroll to four star")
	public void scroll_to_four_star() throws InterruptedException, IOException {
	    validation.scrolldown();
	    Hooks.ScreenShots("filters.png");
	}

	@Then("click on apply")
	public void click_on_apply() throws InterruptedException, IOException {
	    validation.clickapply();
	}
	@Then("print name and phone no. of the carwash")
	public void print_name_and_phone_no_of_the_carwash() throws InterruptedException, IOException {
		Hooks.ScreenShots("filterlist.png");
	   validation.printdeatils();
	}
	
	
	
	
	
	
	@Given("user is on free listing page")
	public void user_is_on_free_listing_page() throws InterruptedException {
		driver=Hooks.driver;
		free=new freelist(driver);
	    free.freebuttonclick();
	}

	@Then("click on phone number input box")
	public void click_on_phone_number_input_box() throws InterruptedException, IOException {
		Hooks.ScreenShots("freelist.png");
	   free.clickonnuminput();
	}

	@Then("enter a wrong phone no.")
	public void enter_a_wrong_phone_no() throws InterruptedException, IOException {
		free.sendnumber();
		Hooks.ScreenShots("sendnumber.png");
	}

	@Then("click on start now")
	public void click_on_start_now() throws InterruptedException, IOException {
		free.clickstart();
		
	}

	@Then("capture the error message")
	public void capture_the_error_message() throws InterruptedException, IOException {
		free.geterrormsg();
		Hooks.ScreenShots("errormsg.png");
	}

	@Then("display the error message")
	public void display_the_error_message() throws InterruptedException, IOException {
	    free.printerrormsg();
	}
	
	
	
	
	

	@Given("user is on main page")
	public void user_is_on_main_page() throws InterruptedException {
		driver=Hooks.driver;
		gyminfo=new gym(driver);
		gyminfo.gomainpage();
	}

	@Then("click on gym page")
	public void click_on_gym_page() throws InterruptedException, IOException   {
		gyminfo.gympageclick();
		Hooks.ScreenShots("gympage.png");
	}

	@Then("finding and printing all dropdown menus")
	public void finding_and_printing_all_dropdown_menus() throws InterruptedException, IOException {
	    gyminfo.gyminfocollect();
	}

	
}

