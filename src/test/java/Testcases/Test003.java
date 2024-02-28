package Testcases;

	import java.io.IOException;
	import org.testng.annotations.Test;
	import factoryy.BaseClass;
	import pageobjects.ValidationPage;
import pageobjects.gym;
		
		
		 
		public class Test003 extends BaseClass{
		  @Test
		  public void GymPage() throws InterruptedException, IOException {
			  	logger.info("Starting gym homepage automation.......................");
			  	gym page = new gym(driver);
			  //	carWashServicesPage car = new carWashServicesPage(driver);
		 
				page.gomainpage();
				logger.info("Went to Gym listing page.......................");
				page.gympageclick();
				BaseClass.ScreenShots("gympage.png");
				page.gyminfocollect();
				logger.info("Completed gym homepage automation.......................");
				
				
				//page.servicesDetails("Car Washing Services");
			  //	logger.info("Completed JustDial homepage automation.......................");
		 
				Thread.sleep(5000);
		//	  	logger.info("Starting CarWashServicePage homepage automation.......................");
//		 
//				car.clickOnAllFilters();
//			  	car.scrollAndSelectRatings();
//			  	car.clickOnApplyFilters();
//			  	car.serviceCenterNamesAndPhoneNumbers();
//			  	logger.info("Completed CarWashServicePage homepage automation.......................");
			} 
		}




