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
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IncidentManagement_TC001 {

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
		Thread.sleep(3000);
		findElement.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//div[text()='Create New']")).click();
		driver.switchTo().frame(0);
		String incidentNumber = driver.findElement(By.id("incident.number")).getAttribute("value");
		System.out.println("Incident Number while creation :" +incidentNumber);
		
		driver.findElement(By.id("lookup.incident.caller_id")).click();
		
		Set<String> windows = driver.getWindowHandles();
		List<String> windows1 = new ArrayList<String>(windows);
		String windowHandle1 = windows1.get(1);
		
		driver.switchTo().window(windowHandle1);
		driver.findElement(By.xpath("//table[@id='sys_user_table']/tbody[1]/tr[1]/td[3]/a[1]")).click();
		
		String windowHandle2 = windows1.get(0);
		driver.switchTo().window(windowHandle2);
		driver.switchTo().frame(0);
		WebElement findElement2 = driver.findElement(By.id("incident.short_description"));
		findElement2.click();
		driver.findElement(By.id("incident.short_description")).sendKeys("Test created");
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(@class,'column_head list_hdrcell')]")).click();
		
		/*WebElement findElement3 = driver.findElement(By.xpath("//a[contains(@class,'column_head list_hdrcell')]"));
		findElement3.sendKeys(Keys.chord(Keys.CONTROL, "c"));
		WebElement findElement4 = driver.findElement(By.xpath("//input[@class='form-control']"));
		findElement4.click();
		findElement4.sendKeys(Keys.chord(Keys.CONTROL, "v"));
		findElement4.sendKeys(Keys.ENTER);		
		System.out.println("Incident ID created" +findElement4);*/
		
		WebElement findElement3 = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		findElement3.click();
		findElement3.sendKeys(incidentNumber);
		findElement3.sendKeys(Keys.ENTER);
		String numberINC = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
		System.out.println(("Incident Number after submittion :" +numberINC));
		if (incidentNumber .equals(numberINC)) {
			System.out.println("Incident Number Matches");
		}

	}

}
