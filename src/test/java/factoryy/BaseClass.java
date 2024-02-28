package factoryy;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
	public static Properties p;
	public static Logger logger;
	public static ChromeOptions options = new ChromeOptions();
	static EdgeOptions optionss =new EdgeOptions();
	
	@BeforeClass
	@Parameters({"os", "browser"})
	public void initilizeBrowser(String os, String browser) throws IOException {
		logger=LogManager.getLogger(Logger.class.getName());
		
		optionss.addArguments("--disable-blink-features=AutomationControlled");
		options.addArguments("--disable-blink-features=AutomationControlled");
		
		if(getProperties().getProperty("execution_env").equalsIgnoreCase("remote"))
	 	{	
		
		DesiredCapabilities capabilities=new DesiredCapabilities();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-blink-features=AutomationControlled");
		
		//os
		if(os.equalsIgnoreCase("windows"))
		{
			//optionss.addArguments("--disable-blink-features=AutomationControlled");
			capabilities.setPlatform(Platform.WIN11);
		}
		else if(os.equalsIgnoreCase("mac"))
		{
			capabilities.setPlatform(Platform.MAC);
		}
		else
		{
			System.out.println("No matching os..");
			return;
		}
		
		//browser
		
		switch(browser.toLowerCase())
		{
		case "chrome" : 
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			capabilities.setBrowserName("chrome"); 
			break;
		case "edge" :
			capabilities.setCapability(ChromeOptions.CAPABILITY, optionss);
			capabilities.setBrowserName("MicrosoftEdge"); break;
		default: System.out.println("No matching browser.."); return;
		}
		
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
		
	    }
	else if(getProperties().getProperty("execution_env").equalsIgnoreCase("local"))
	{
		//launching browser based on condition - locally
	
		switch(browser.toLowerCase())
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
	
		//return driver;
	}
     @AfterClass
	public void  tearDown() {
		

		driver.quit();
	}

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
	
	public static void takeSS(String fileName) throws IOException {
		TakesScreenshot ts= (TakesScreenshot)driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		File trg= new File(System.getProperty("user.dir")+"\\reports\\"+ fileName);
		FileUtils.copyFile(src, trg);
	}

}