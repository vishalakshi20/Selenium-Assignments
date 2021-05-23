package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions( dryRun = false,

features= {"src/test/java/features/EditLead.feature","src/test/java/features/DuplicateLead.feature"},
				glue = {"stepdefinition"},
				monochrome = true
		
		)

public class RunCucumberTests extends AbstractTestNGCucumberTests{

}
