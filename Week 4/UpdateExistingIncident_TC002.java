package week4assignments_incidentmanagement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdateExistingIncident_TC002 {

	public static void main(String[] args) throws Exception {
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
		findElement.sendKeys("Incident");
		findElement.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//div[text()='Open']")).click();
		
		driver.switchTo().frame(0);
		//String existingIncident = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
		WebElement forTextNum = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']")); 
		new Select(forTextNum).selectByIndex(1); 
		WebElement findElement1 = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		findElement1.click();
		findElement1.sendKeys("INC0010868");
		Thread.sleep(2000);
		findElement1.sendKeys(Keys.ENTER);
		
		
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		driver.findElement(By.xpath("//div[@id= 'element.incident.urgency']//option[1]")).click();
		
		driver.findElement(By.xpath("//div[@id= 'element.incident.state']//option[2]")).click();
		
		driver.findElement(By.id("sysverb_update_bottom")).click();
		
		String incidentState = driver.findElement(By.cssSelector("table#incident_table>tbody>tr>td:nth-of-type(8)")).getText();
		if (incidentState.contentEquals("In Progress") ) {
			
			System.out.println("State updated to InProgress : " +incidentState);
		}
		
		String incidentPriority = driver.findElement(By.cssSelector("table#incident_table>tbody>tr>td:nth-of-type(7)")).getText();
		if (incidentPriority .contentEquals( "3 - Moderate")) {
			
			System.out.println("Priority updated to Moderate : " +incidentPriority);
		}
		else {
			System.out.println("Testcase Failed");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
