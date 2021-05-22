package week5.assignment;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead extends BaseClass{

	@Test(dataProvider = "TestData")
	public void deleteLead(String phoneno) throws InterruptedException {
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.name("phoneNumber")).sendKeys(phoneno);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		
		String text = driver.findElement(By.xpath("//div[@class = 'x-grid3-cell-inner x-grid3-col-partyId']")).getText();
		driver.findElement(By.xpath("//div[@class = 'x-grid3-cell-inner x-grid3-col-partyId']/a[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Delete")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.name("id")).sendKeys(text);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		boolean noRecordsTo = driver.findElement(By.xpath("//div[text()='No records to display']")).isDisplayed();
		if (noRecordsTo) {
			System.out.println("No records to Display - Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
		
	}
	@DataProvider(name="TestData")
	public Object[][] fetchData() throws InvalidFormatException, IOException{
		
		String[][] data = ReadExcel.readExcel("Delete Lead");
		return data;
	}

}
