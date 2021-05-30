package pages;

import org.openqa.selenium.WebElement;

import hooks.TestNgHooks;
import io.cucumber.java.en.Then;

public class ViewLead extends TestNgHooks {
	
	@Then("Verify if New lead is created") 
	public void verifyIfLeadIsCreated() {
		
	
	WebElement ele = locateElement("id", "viewLead_companyName_sp");
	if(ele.isDisplayed())
	{ 
	System.out.println("New Lead is created"); 
	}  
	else {
    System.out.println("New Lead is not created"); 
    }
  }
}
