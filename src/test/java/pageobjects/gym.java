package pageobjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import factoryy.BaseClass;

 

public class gym extends BasePage {
	
	public gym(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//*[@id=\"__next\"]/div/section/div[1]/section[1]/div/div[2]/div/div[3]/span")
	WebElement laterbutton;
	
	    @FindBy(xpath="//*[@id=\"__next\"]/main/div/header/div/div[1]/a/img")
	    WebElement justbutton;
		
		@FindBy(xpath="//*[@id=\"mainContent\"]/div[2]/a[14]/div[1]")
		WebElement gymbutton;
		
		@FindBy(xpath="//*[@id='mainContent']/div[2]/a[14]")
		static WebElement gymIconLocator;
		
		@FindBy(xpath="//*[@id='mainContent']/div[2]/a[14]/div[2]")
		static WebElement gymIconButton;
		
		static By subMenuTitles = By.xpath("//*[@id='filter_ul']/li");
		
		static By dropDownList = By.xpath("//*[@class = 'jsx-6ab5af3a8693e5db animlabel']");

		
			public void gomainpage() throws InterruptedException {
				laterbutton.click();
				//justbutton.click();
		}
			public void gympageclick() throws InterruptedException, IOException {
				gymbutton.click();
				Thread.sleep(2000);
				
		}
		
		public void gyminfocollect() throws InterruptedException {
			
			List<WebElement> subMenuTitlesList = driver.findElements(subMenuTitles);
			// for printing the details submenu 
			System.out.println("----------------ALL THE SUBMENU ITEMS ON GYM SECTION PAGE-------------------------");
			for(int k = 0;k<subMenuTitlesList.size();k++) {
				String s = subMenuTitlesList.get(k).getText();
				System.out.println(s);
			}
			for (int i = 0; i < subMenuTitlesList.size(); i++) {
	            String Text = subMenuTitlesList.get(i).getText();
	            if (Text.contains("Sort")) {
	            	System.out.println("-------------Sort By Dropdown----------");
	            	subMenuTitlesList.get(i).click();
	                //List<WebElement> list2 = driver.findElements(By.xpath("//*[@class = 'jsx-6ab5af3a8693e5db animtext']"));
	                List<WebElement> list2= driver.findElements(dropDownList);
	                //System.out.println(list2.size());
	                for(int j =0; j<list2.size(); j++) {
	                		String s = list2.get(j).getText();
	                		System.out.println(s);
	                }
	            }
	            if (Text.contains("Amenities")) {
	            	System.out.println("-------------Amentities Dropdown----------");
	            	subMenuTitlesList.get(i).click();
	                //List<WebElement> list2 = driver.findElements(By.xpath("//*[@class = 'jsx-6ab5af3a8693e5db animtext']"));
	                List<WebElement> list2 = driver.findElements(dropDownList);
	                //System.out.println(list2.size());
	                for(int j =0; j<list2.size(); j++) {
	                		String s = list2.get(j).getText();
	                		System.out.println(s);
	                }
	            }
	            if (Text.contains("Ratings")) {
	            	System.out.println("-------------Ratings Dropdown----------");
	            	subMenuTitlesList.get(i).click(); 
	                //List<WebElement> list2 = driver.findElements(By.xpath("//*[@class = 'jsx-6ab5af3a8693e5db animtext']"));
	                List<WebElement> list2 = driver.findElements(dropDownList);
	                //System.out.println(list2.size());
	                for(int j =0; j<list2.size(); j++) {
	                		String s = list2.get(j).getText();
	                		System.out.println(s);
	                }
	            }
}
			

}
}
