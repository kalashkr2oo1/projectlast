package pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.excel;

public class freelist extends BasePage {
	
	public freelist(WebDriver driver) {
		super(driver);
	}
	String msg;
	
	@FindBy(xpath="//*[@id=\"__next\"]/div/section/div[1]/section[1]/div/div[2]/div/div[3]/span")
	WebElement laterbutton;
		
		@FindBy(xpath="//*[@id=\"header_freelisting\"]/a/div[2]")
		WebElement freebutton;

		@FindBy(xpath="//*[@id=\"1\"]")
		WebElement number;
		
		@FindBy(xpath="//*[@id=\"listyourbusiness\"]/div[1]/form/span[2]")
		WebElement errormsg;
		
		@FindBy(xpath="//*[@id=\"listyourbusiness\"]/div[1]/form/button")
		WebElement startbutton;
		
		
		
		//*[@id="__next"]/main/div/header/div/div[1]/a/img
		public void freebuttonclick() throws InterruptedException {
			laterbutton.click();
			freebutton.click();
		}
		
		public void clickonnuminput() throws InterruptedException {
			number.click();
		}
		
		public void sendnumber() throws InterruptedException {
			number.sendKeys("1234567890");
		}
		
		public void clickstart() throws InterruptedException, IOException {
			startbutton.click();
			//Thread.sleep(2000);
			
		}
		
		public void geterrormsg() throws InterruptedException {
			 msg = errormsg.getText();
		}
		
		public void printerrormsg() throws InterruptedException, IOException {
			System.out.println("--------------------------------------------------------------------------------------");
			System.out.println("Error message="+ msg);
			excel.writeExcelData("Sheet1",1,5,msg);
		}

}
		
	


