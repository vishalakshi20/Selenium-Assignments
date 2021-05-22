package week5.assignment;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead extends BaseClass {

	
		@Test(dataProvider = "TestData", timeOut=6000)
		public void createLead(String companyName, String firstName, String lastName) throws InterruptedException {
			
			driver.findElement(By.linkText("Create Lead")).click();
			driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
			driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
			driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
			driver.findElement(By.name("submitButton")).click();
			
		}
			
		@DataProvider(name="TestData", indices= {0})
		public Object[][] fetchData() throws InvalidFormatException, IOException{
			
			String[][] data = ReadExcel.readExcel("Create Lead");
			return data;
			
		}

	}


