package Testcases;

	import java.io.IOException;
	import org.testng.annotations.Test;
	import factoryy.BaseClass;
import pageobjects.gym;
		
		
		 
		public class Test003 extends BaseClass{
			public gym page;
			
		  @Test(priority=1,groups={"sanity","smoke"})
		  public void GymPage() throws InterruptedException, IOException {
			  	logger.info("Starting gym homepage automation.......................");
			  	 page = new gym(driver);
			  //	carWashServicesPage car = new carWashServicesPage(driver);
		 
				page.gomainpage();
				logger.info("Went to Gym listing page.......................");
				page.gympageclick();
				BaseClass.ScreenShots("gympage.png");
				
				
				
				Thread.sleep(5000);
		
			} 
		  @Test(priority=2,groups={"regression"},dependsOnMethods={"GymPage"})
		  public void collectinfo() throws InterruptedException, IOException {
			  page.gyminfocollect();
				logger.info("Completed gym homepage automation.......................");
		  }
		}




