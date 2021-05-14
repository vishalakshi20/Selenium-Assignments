package week4assignments_incidentmanagement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignIncident_TC003_ {

	public static void main(String[] args) throws Exception {
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
		findElement.sendKeys("Incident");
		findElement.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//div[text()='Open']")).click();
		
		driver.switchTo().frame(0);
		//String existingIncident = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
		WebElement forTextNum = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']")); 
		new Select(forTextNum).selectByIndex(1); 
		WebElement findElement1 = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		findElement1.click();
		findElement1.sendKeys("INC0010893");
		Thread.sleep(2000);
		findElement1.sendKeys(Keys.ENTER);
		
		
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		
		driver.findElement(By.id("lookup.incident.assignment_group")).click();
		Set<String> windows = driver.getWindowHandles();
		List<String> windows1 = new ArrayList<String>(windows);
		String windowHandle1 = windows1.get(1);
		
		driver.switchTo().window(windowHandle1);
		WebElement findElement2 = driver.findElement(By.xpath("//input[@class='form-control']"));
		findElement2.click();
		findElement2.sendKeys("Software");
		findElement2.sendKeys(Keys.ENTER);
		driver.findElement(By.linkText("Software")).click();
		
		driver.switchTo().window(windows1.get(0));
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//button[@data-for='sys_display.incident.assigned_to']//span[1]")).click();
		windows = driver.getWindowHandles();
		windows1 = new ArrayList<String>(windows);
		driver.switchTo().window(windows1.get(1));
		
		WebElement findElement3 = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		findElement3.click();
		findElement3.sendKeys("ITIL User");
		findElement3.sendKeys(Keys.ENTER);
		driver.findElement(By.linkText("ITIL User")).click();	
		driver.switchTo().window(windows1.get(0));
		driver.switchTo().frame(0);
		Thread.sleep(2000);
				
		WebElement workNotes = driver.findElement(By.id("activity-stream-textarea"));
		js.executeScript("arguments[0].scrollIntoView();", workNotes);
		workNotes.click();
		workNotes.sendKeys("Testcase 3");

		driver.findElement(By.id("sysverb_update_bottom")).click();
		
		String assignmentGroup = driver.findElement(By.cssSelector("table#incident_table>tbody>tr>td:nth-of-type(10)")).getText();
		if (assignmentGroup.contentEquals("Software") ) {
			
			System.out.println("State updated to InProgress : " +assignmentGroup);
		}
		
		String assignedTo = driver.findElement(By.cssSelector("table#incident_table>tbody>tr>td:nth-of-type(11)>a")).getText();
		if (assignedTo .contentEquals( "ITIL User")) {
			
			System.out.println("Priority updated to Moderate : " +assignedTo);
		}
		else {
			System.out.println("Testcase Failed");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
