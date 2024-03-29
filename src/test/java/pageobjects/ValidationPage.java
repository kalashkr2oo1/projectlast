package pageobjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import utilities.excel;

public class ValidationPage extends BasePage {
	
	
	public ValidationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//*[@id=\"__next\"]/div/section/div[1]/section[1]/div/div[2]/div/div[3]/span")
	WebElement laterbutton;
	
	@FindBy(xpath="//*[@id='city-auto-sug']")
	WebElement locationbox;
	
	@FindBy(xpath="//*[@id='react-autowhatever-city-auto-suggest']")
	WebElement detectlocation;
	
	@FindBy(xpath="//*[@id=\"main-auto\"]")
	WebElement searchbar;
	
	//@FindBy(xpath="//*[@class=\"search_button\"]")
	@FindBy(xpath="(//div[@class='search_text font14 fw400 color111'])[1]")
	WebElement selectcarwash;
	
	@FindBy(xpath="//*[@class=\"jsx-abd03633235cbc61 resfilter_item gray_whitefill_animat\"]")
	WebElement filters;
	
	@FindBy(xpath=" //*[@id=\"__next\"]/section/section/div/div[4]/aside/div/div[2]/div/div[1]/div[5]/span[3]")
	WebElement rating;
	
	@FindBy(xpath="//*[@id=\"__next\"]/section/section/div/div[4]/aside/div/div[2]/div/div[2]/button[2]")
	WebElement apply;
	
//	@FindBy(xpath="//div[@class='jsx-3349e7cd87e12d75 resultbox_title_anchor  line_clamp_1 ']")
//	List<WebElement> carWashServiceNames; 
//	
//	@FindBy(xpath="//div[@class='jsx-3349e7cd87e12d75 button_flare']")
//	WebElement hiddenPhoneNumbers;
//	
//	@FindBy(xpath="//span[@class='jsx-3349e7cd87e12d75 callcontent']")
//	WebElement carWashServiceContacts;
//	
//	@FindBy(xpath="//div[@class='jsx-3349e7cd87e12d75 resultbox_countrate ml-12 mr-12 font14 fw400 color777']")
//	List<WebElement> customerVotes;
	
	
	
	
	static By carWashServiceNames = By.xpath("//div[@class='jsx-3349e7cd87e12d75 resultbox_title_anchor  line_clamp_1 ']");
    
	static By hiddenPhoneNumbers = By.xpath("//div[@class='jsx-3349e7cd87e12d75 button_flare']");
	
	static By carWashServiceContacts = By.xpath("//span[@class='jsx-3349e7cd87e12d75 callcontent']");
	
	static By customerVotes = By.xpath("//div[@class='jsx-3349e7cd87e12d75 resultbox_countrate ml-12 mr-12 font14 fw400 color777']");
	
 
 

	
	public void clicklater() throws InterruptedException, IOException {
		laterbutton.click();
		
	}
	public void clicklocation() throws InterruptedException {
		locationbox.click();
	}
	
    public void clickdetect() throws InterruptedException {
    	detectlocation.click();
    //	Thread.sleep(5000);
    }
    public void clicksearchbar() throws InterruptedException {
    	searchbar.click();
		//Thread.sleep(5000);
    }
    
    public void sendcarwash() throws InterruptedException {
    	searchbar.sendKeys("car wash");
    	//WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(60));
    	//wait.until(ExpectedConditions.elementToBeClickable(selectcarwash));
		Thread.sleep(5000);
		selectcarwash.click();
		
    }
    public void filterapply() throws InterruptedException {
    	filters.click();
    }
    public void scrolldown() throws InterruptedException {
    //	WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(60));
		//wait.until(ExpectedConditions.visibilityOf(rating));
    	//Thread.sleep(2000);
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",rating);
		//Thread.sleep(5000);
    }
    public void clickapply() throws InterruptedException, IOException {
    	rating.click();
		apply.click();
		
    }
    
    public void printdeatils() throws InterruptedException, IOException {
    	String s = null,p = null, v= null;
		int g=0;
		List<WebElement> names= driver.findElements(carWashServiceNames);
		List<String> namesList=new ArrayList<String>();
		List<WebElement> hiddenIcon= driver.findElements(hiddenPhoneNumbers);
		List<WebElement> phoneNumbers= driver.findElements(carWashServiceContacts);
		List<String> phoneNumbersList= new ArrayList<String>();
		List<WebElement> customerRatings= driver.findElements(customerVotes); 
		List<String> customerRatingsList=new ArrayList<String>();
        int i=5;
        
		for(int j =0;j<i;j++) {
			System.out.println("--------------------------------------------------------------------------------------");
			namesList.add(names.get(j).getText());
			s=namesList.get(j);
			WebElement z=hiddenIcon.get(j);
			z.click();
			//Thread.sleep(2000);
			z=phoneNumbers.get(j);
			Thread.sleep(3000);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(hiddenPhoneNumbers));
			phoneNumbersList.add(z.getAttribute("data-href"));
			p=phoneNumbersList.get(j);
			//System.out.println(p);
			//Thread.sleep(2000);
			customerRatingsList.add(customerRatings.get(j).getText());
			v=customerRatingsList.get(j);
			v = v.replaceAll("\\D", "");
			int c=Integer.parseInt(v);
			if(c>20) {
				g++;
			System.out.println("Car Wash Service Name: "+s+"  ; Phone Number: "+p+"  ; Customer Ratings: "+c);
			excel.writeExcelData("Sheet1",j+1,0,s);
			excel.writeExcelData("Sheet1",j+1,1,p);
			excel.writeExcelData1("Sheet1",j+1,2,c);
			
	}
			if(g==j)
			{
				i++;
				g++;
			}
			
}
	}
    
    
    
    
    

}

