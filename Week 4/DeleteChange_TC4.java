package week4assignments_changemanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteChange_TC4 {

	public static void main(String[] args)throws Exception {
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
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
			driver.findElement(By.xpath("(//div[text()='Open'])[3]")).click();
			
		
			driver.switchTo().frame(0);
			WebElement number = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']")); 
			new Select(number).selectByIndex(1);
			
			WebElement findElement3 = driver.findElement(By.xpath("//input[@placeholder='Search']"));
			findElement3.click();
			findElement3.sendKeys("CHG0000032");
			findElement3.sendKeys(Keys.ENTER);
			
			driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
			WebElement number1 = driver.findElement(By.id("change_request.number"));
			
			number1.click();
			
			driver.findElement(By.id("sysverb_delete")).click();
			
			driver.findElement(By.id("ok_button")).click();
			
			String cs = "No records to display";
			String deleteChange = driver.findElement(By.xpath("//td[text()='No records to display']")).getText();
			System.out.println(deleteChange);
			if (deleteChange.equalsIgnoreCase(cs)) {
				System.out.println("Deleted Existing Change Request");
			} 
			else
			{
				System.out.println("Change Request not Deleted");
			}
		}

	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

