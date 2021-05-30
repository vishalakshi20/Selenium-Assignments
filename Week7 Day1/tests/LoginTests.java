package tests;

import org.testng.annotations.Test;

import hooks.TestNgHooks;
import pages.Login;

public class LoginTests extends TestNgHooks {

	@Test(dataProvider = "FetchExcelData")
	public void login(String Username, String Password,String companyName, String firstName,String lastName) {
	
		new Login()
		.typeUserName("DemoSalesManager")
		.typePassword("crmsfa")
		.clickLogin()
		.verifyWelcomeMessage()
		.clickCRMSFA()
		.clickCreateLead()
		.enterCompanyName(companyName)
		.enterFirstName(firstName)
		.enterLastName(lastName)
		.clickSubmit()
		.verifyIfLeadIsCreated();
		
		}

	}
	

