package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import hooks.TestNgHooks;
import io.cucumber.java.en.And;


public class Home extends TestNgHooks{
	
	
	public Home verifyWelcomeMessage() {
		verifyPartialText(locateElement("tag","h2"), "Welcome");
		return this;

	}

	public Login clickLogout() {
		click(locateElement("class","decorativeSubmit"));
		return new Login();
	
}
	@And("Click CRMSFA") 
	public Home clickCRMSFA() {
	click(locateElement("link", "CRM/SFA"));
	return this;
	}
	@And ("Click Create Leads")
	public CreateLead clickCreateLead() {
		click(locateElement("link", "Create Lead"));
		return new CreateLead();
		}

}
	