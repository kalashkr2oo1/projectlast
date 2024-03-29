package Testcases;
import java.io.IOException;
import org.testng.annotations.Test;
import factoryy.BaseClass;
import pageobjects.ValidationPage;

	
	
	 
	public class Test001 extends BaseClass{
		
		public ValidationPage page;
		
	  @Test(priority=1,groups={"sanity","smoke"})
	  public void JustDialHomePage() throws InterruptedException, IOException {
			logger.info("Starting JustDial homepage automation.......................");
		  	 page = new ValidationPage(driver);
		  	
			page.clicklater();
			BaseClass.ScreenShots("mainpage.png");
			logger.info("Reached JustDial homepage automation.......................");
			
			
	
		} 
	  @Test(priority=2,groups={"sanity"},dependsOnMethods={"JustDialHomePage"})
	  public void selectlocation() throws InterruptedException, IOException {
		  page.clicklocation();
			BaseClass.ScreenShots("location.png");
			page.clickdetect();
			BaseClass.ScreenShots("detect.png");
			logger.info("Location detected.......................");
			page.clicksearchbar();
			page.sendcarwash();
			BaseClass.ScreenShots("sendcarwash.png");
			logger.info("Reached JustDial carwashing at current location.......................");
	  }
	  @Test(priority=3,groups={"sanity","regression"},dependsOnMethods={"JustDialHomePage","selectlocation"})
	  public void secondpage() throws InterruptedException, IOException {
		  Thread.sleep(5000);
		  page.filterapply();
			BaseClass.ScreenShots("filters.png");
			page.scrolldown();
			page.clickapply();
			BaseClass.ScreenShots("filterlist.png");
			logger.info("Filters are applied.......................");
			page.printdeatils();
			logger.info("Completed CarWashServicePage homepage automation.......................");
			
			
			Thread.sleep(5000);
	  }
	  
	}


