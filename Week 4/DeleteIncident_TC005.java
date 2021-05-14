package week4assignments_incidentmanagement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
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

public class DeleteIncident_TC005 {

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
		
		/*WebElement incidentNumber = driver.findElement(By.xpath("//a[@class='linked formlink']"));
		
		incidentNumber.click();
		String incidentnumber = driver.findElement(By.id("incident.number")).getAttribute("value");
		System.out.println(incidentnumber);
		//WebElement system = driver.findElement(By.xpath("//ul[@class='sn-widget-list sn-widget-list-table']//li"));
			
		
		//js.executeScript("arguments[0].scrollIntoView();", system);
		driver.findElement(By.id("sysverb_delete_bottom")).click();
		driver.findElement(By.id("ok_button")).click();*/
		
		WebElement forTextNum = driver.findElement(By.xpath("//span[@class='input-group-addon input-group-select']//select[1]")); 
		new Select(forTextNum).selectByIndex(1); 
		WebElement findElement1 = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		findElement1.click();
		
		findElement1.sendKeys("INC0010920");
		findElement1.sendKeys(Keys.ENTER);
		WebElement incidentNumber = driver.findElement(By.xpath("//a[@class='linked formlink']"));
		
		incidentNumber.click();
		driver.findElement(By.id("sysverb_delete_bottom")).click();
		driver.findElement(By.id("ok_button")).click();
		
		String cs = "No records to display";
		String deleteIncident = driver.findElement(By.xpath("//td[text()='No records to display']")).getText();
		System.out.println(deleteIncident);
		if (deleteIncident.equalsIgnoreCase(cs)) {
			System.out.println("Deleted Existing Incident");
		} 
		else
		{
			System.out.println("Incident not Deleted");
		}
	}

	
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}


