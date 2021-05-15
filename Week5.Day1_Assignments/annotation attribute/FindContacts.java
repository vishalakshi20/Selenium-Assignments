package week5day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindContacts  extends BaseClass{

	@Test
	public void findContacts() throws InterruptedException {
		
		
		driver.findElement(By.linkText("Contacts")).click();
		
		driver.findElement(By.linkText("Find Contacts")).click();
		
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.name("emailAddress")).sendKeys("XYZ@gmail.com");
		driver.findElement(By.xpath("//button[text()='Find Contacts']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[2]")).click();
	}

}
