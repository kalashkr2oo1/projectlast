package Testcases;

	import java.io.IOException;
	import org.testng.annotations.Test;
	import factoryy.BaseClass;
	
import pageobjects.freelist;
		
		
		 
		public class Test002 extends BaseClass{
		  @Test
		  public void Freelistingpage() throws InterruptedException, IOException {
			  	
			  	freelist page = new freelist(driver);
			  	logger.info("Starting Freelisting homepage automation.......................");
			  //	carWashServicesPage car = new carWashServicesPage(driver);
		 
				page.freebuttonclick();
				BaseClass.ScreenShots("freelist.png");
				logger.info("Reached on Freee listing page.......................");
				page.clickonnuminput();
				page.sendnumber();
				BaseClass.ScreenShots("sendnumber.png");
				logger.info("Sent the phone no. input.......................");
				page.clickstart();
				BaseClass.ScreenShots("errormsg.png");
				page.geterrormsg();
				logger.info("Error message captured.......................");
				page.printerrormsg();
				logger.info("Completed Freelisting homepage automation.......................");
				
				
			
		 
				Thread.sleep(5000);
		
			} 
		}





