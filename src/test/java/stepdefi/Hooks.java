package stepdefi;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	public static WebDriver driver;
	public static Properties p;
	static ChromeOptions options = new ChromeOptions();
	
    
	 @Before
	 public void setUp() throws IOException {
		driver=initilizeBrowser();
		driver.manage().deleteAllCookies();
		driver.get(getProperties().getProperty("appURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 }
	 
	 public WebDriver initilizeBrowser() throws IOException {
		 if (getProperties().getProperty("execution_env").equalsIgnoreCase("local")) {
			switch (getProperties().getProperty("browser")) {
				case "chrome":
					options.addArguments("--disable-blink-features=AutomationControlled");
				
					driver=new ChromeDriver(options);
				

					break;
				case "firefox":
					driver = new FirefoxDriver();
					break;
				default:
					driver = new EdgeDriver();
			}
		}
		

		return driver;
	}
		
   
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

