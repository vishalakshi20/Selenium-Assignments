package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import hooks.TestNgHooks;
import io.cucumber.java.en.And;


public class Login extends TestNgHooks{
	
	@And ("Enter the username 'DemoSalesManager'")
	public Login typeUserName(String userdata) {
		type(locateElement("id","username"),userdata);
		return this;
	}
	@And ("Enter the password 'crmsfa'")
	public Login typePassword(String passdata) {
		type(locateElement("id","password"),passdata);
		return this;
	}
	@And ("Click Login button")
	public Home typePasswordAndEnter(String passdata) {
		typeAndEnter(locateElement("id", "password"),passdata);
		return new Home();
	}
	@And ("Click CRMSFA")
	public Home clickLogin() {
		click(locateElement("class", "decorativeSubmit"));
		return new Home();
	}

}
