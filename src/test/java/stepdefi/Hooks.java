package stepdefi;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	public static WebDriver driver;
	public static Properties p;
	static ChromeOptions options = new ChromeOptions();
	
    static EdgeOptions optionss =new EdgeOptions();
	 @Before
	
	 public void initilizeBrowser() throws IOException {
		if(getPropertiess().getProperty("execution_env").equalsIgnoreCase("remote"))
	 	{	
		
		DesiredCapabilities capabilities=new DesiredCapabilities();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-blink-features=AutomationControlled");
		EdgeOptions optionss = new EdgeOptions();
		optionss.addArguments("--disable-blink-features=AutomationControlled");
		
		//os
		if(getPropertiess().getProperty("os").equalsIgnoreCase("windows"))
		{
			//options.addArguments("--disable-blink-features=AutomationControlled");
			capabilities.setPlatform(Platform.WIN11);
		}
		else if(getPropertiess().getProperty("os").equalsIgnoreCase("mac"))
		{
			capabilities.setPlatform(Platform.MAC);
		}
		else
		{
			System.out.println("No matching os..");
			return;
		}
		
		//browser
		
		switch(getPropertiess().getProperty("browser").toLowerCase())
		{
		case "chrome" : 
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			capabilities.setBrowserName("chrome"); 
			break;
		case "edge" : capabilities.setBrowserName("MicrosoftEdge");
		capabilities.setCapability(EdgeOptions.CAPABILITY, optionss);
		//capabilities.setBrowserName("edge");
		break;
		default: System.out.println("No matching browser.."); return;
		}
		
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
		
	    }
		
	else if(getPropertiess().getProperty("execution_env").equalsIgnoreCase("local"))
	{
		//launching browser based on condition - locally
	
		switch(getPropertiess().getProperty("browser").toLowerCase())
		{
		case "chrome":
			options.addArguments("--disable-blink-features=AutomationControlled");
			driver=new ChromeDriver(options);
			
		break;
		case "edge": 
			optionss.addArguments("--disable-blink-features=AutomationControlled");
			driver=new EdgeDriver(optionss); break;
		default: System.out.println("No matching browser..");
					return;
		}
		
	}
		driver.manage().deleteAllCookies();
		driver.get(getProperties().getProperty("appURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
	 
	
		public static Properties getPropertiess() throws IOException {
			FileReader file = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");

			p = new Properties();
			p.load(file);
			return p;
		}

	 
	
	 
//	 public WebDriver initilizeBrowser() throws IOException {
//		 if (getProperties().getProperty("execution_env").equalsIgnoreCase("local")) {
//			switch (getProperties().getProperty("browser")) {
//				case "chrome":
//					options.addArguments("--disable-blink-features=AutomationControlled");
//				
//					driver=new ChromeDriver(options);
//				
//
//					break;
//				case "firefox":
//					driver = new FirefoxDriver();
//					break;
//				default:
//					driver = new EdgeDriver();
//			}
//		}
//		
//
//		return driver;
//	}
//		
   
   @After
   public void tearDown() {
       		
      driver.quit();
      
   }
   //Scenario scenario
   

	public static Properties getProperties() throws IOException {
		FileReader file = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");

		p = new Properties();
		p.load(file);
		return p;
	}
	public static void ScreenShots(String fileName) throws IOException {
		TakesScreenshot ts= (TakesScreenshot)driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		File trg= new File(System.getProperty("user.dir")+"\\Screenshot\\"+ fileName);
		FileUtils.copyFile(src, trg);
	}
}

