package week4assignments_changemanagement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateNewChange_TC1 {

	public static void main(String[] args)throws Exception {
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			
			driver.get("https://dev103117.service-now.com");
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			driver.switchTo().frame(0);
			driver.findElement(By.id("user_name")).sendKeys("admin");
			driver.findElement(By.id("user_password")).sendKeys("India@123");
			driver.findElement(By.id("sysverb_login")).click();
			WebElement findElement = driver.findElement(By.id("filter"));
			findElement.sendKeys("Change");
			Thread.sleep(3000);
			findElement.sendKeys(Keys.ENTER);
			driver.findElement(By.xpath("(//div[text()='Create New'])[3]")).click();
			
			driver.switchTo().frame(0);
			driver.findElement(By.xpath("//span[text()='Normal']")).click();
			String changerequestnumber = driver.findElement(By.id("change_request.number")).getAttribute("value");
			System.out.println("Change Request Number created : " + changerequestnumber);
			
			WebElement findElement2 = driver.findElement(By.id("change_request.short_description"));
			findElement2.click();
			findElement2.sendKeys("Testcase for New Change creation5");
			
			driver.findElement(By.id("sysverb_insert")).click();	
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("(//div[text()='Open'])[3]")).click();
			
			driver.switchTo().frame(0);
			WebElement shortDesc = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']")); 
			new Select(shortDesc).selectByIndex(2);
			
			WebElement findElement3 = driver.findElement(By.xpath("//input[@placeholder='Search']"));
			findElement3.click();
			findElement3.sendKeys("Testcase for New Change creation5");
			findElement3.sendKeys(Keys.ENTER);
			
			//String shortDescription = driver.findElement(By.cssSelector("span#change_request_breadcrumb>a:nth-of-type(5)>b")).getText();
			
			
			String number = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
			System.out.println("Change request Number searched : " +number);
			
			if(changerequestnumber .equals(number)) {
				System.out.println("Created New Change Matches and success");
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
