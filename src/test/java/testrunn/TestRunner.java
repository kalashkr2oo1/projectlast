package testrunn;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
					features = {".//feature/carwash.feature"},
					glue={"stepdefi"}
					,plugin= {"pretty", "html:cucumberReports/myreport.html",
							  "rerun:target/rerun.txt",
							  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
							},
							
					dryRun=false,    // checks mapping between scenario steps and step definition methods
					monochrome=true,    // to avoid junk characters in output
					publish=true  
					//dryRun=true
				)


public class TestRunner {
	
}
