package Testcases;
import java.io.IOException;
import org.testng.annotations.Test;
import factoryy.BaseClass;
import pageobjects.ValidationPage;

	
	
	 
	public class Test001 extends BaseClass{
	  @Test
	  public void JustDialHomePage() throws InterruptedException, IOException {
			logger.info("Starting JustDial homepage automation.......................");
		  	ValidationPage page = new ValidationPage(driver);
		  	
			page.clicklater();
			BaseClass.ScreenShots("mainpage.png");
			logger.info("Reached JustDial homepage automation.......................");
			page.clicklocation();
			BaseClass.ScreenShots("location.png");
			page.clickdetect();
			BaseClass.ScreenShots("detect.png");
			logger.info("Location detected.......................");
			page.clicksearchbar();
			page.sendcarwash();
			BaseClass.ScreenShots("sendcarwash.png");
			logger.info("Reached JustDial carwashing at current location.......................");
			page.filterapply();
			BaseClass.ScreenShots("filters.png");
			page.scrolldown();
			page.clickapply();
			BaseClass.ScreenShots("filterlist.png");
			logger.info("Filters are applied.......................");
			page.printdeatils();
			logger.info("Completed CarWashServicePage homepage automation.......................");
			
			//page.servicesDetails("Car Washing Services");
		  //	logger.info("Completed JustDial homepage automation.......................");
	 
			Thread.sleep(5000);
	//	  	logger.info("Starting CarWashServicePage homepage automation.......................");
//	 
//			car.clickOnAllFilters();
//		  	car.scrollAndSelectRatings();
//		  	car.clickOnApplyFilters();
//		  	car.serviceCenterNamesAndPhoneNumbers();
//		  	logger.info("Completed CarWashServicePage homepage automation.......................");
		} 
	}


