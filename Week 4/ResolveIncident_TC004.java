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

public class ResolveIncident_TC004 {

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
		findElement1.sendKeys("INC0010846");
		Thread.sleep(2000);
		findElement1.sendKeys(Keys.ENTER);
		
		
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		
		WebElement incidentstate = driver.findElement(By.xpath("(//select[@class='form-control'])[3]")); 
		new Select(incidentstate).selectByIndex(3); 
		
		driver.findElement(By.xpath("//span[text()='Resolution Information']")).click();
		
		WebElement incidentclosecode = driver.findElement(By.xpath("//select[@mandatory='true']")); 
		new Select(incidentclosecode).selectByIndex(1); 
		
		WebElement resolutionNotes = driver.findElement(By.id("incident.close_notes"));
		resolutionNotes.click();
		resolutionNotes.sendKeys("Resolved");
		
		
		js.executeScript("arguments[0].scrollIntoView();", resolutionNotes);
		driver.findElement(By.id("resolve_incident_bottom")).click();
		
		
		String resolved = driver.findElement(By.xpath("//td[text()='Resolved']")).getText();
		System.out.println("Status: " +resolved);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
