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

public class UpdateScheduleChange_TC3 {

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
			findElement3.sendKeys("CHG0030753");
			findElement3.sendKeys(Keys.ENTER);
			
			driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
			
			WebElement description = driver.findElement(By.id("change_request.description"));
			js.executeScript("arguments[0].scrollIntoView();", description);
			
			driver.findElement(By.xpath("//span[text()='Schedule']")).click();
			
			driver.findElement(By.xpath("//span[@class='icon-calendar icon']")).click();
			
			driver.findElement(By.id("GwtDateTimePicker_day22")).click();
			
			driver.findElement(By.id("GwtDateTimePicker_ok")).click();
			String changerequeststartdate = driver.findElement(By.id("change_request.start_date")).getAttribute("value");
			
			driver.findElement(By.xpath("(//span[@class='icon-calendar icon'])[2]")).click();
			
			driver.findElement(By.id("GwtDateTimePicker_day24")).click();
			
			driver.findElement(By.id("GwtDateTimePicker_ok")).click();
			String changerequestenddate = driver.findElement(By.id("change_request.end_date")).getAttribute("value");
			
			driver.findElement(By.id("label.ni.change_request.cab_required")).click();
			
			driver.findElement(By.xpath("//a[@data-date_time_format='yyyy-MM-dd']//span[1]")).click();
			
			driver.findElement(By.id("GwtDateTimePicker_day25")).click();
			
			
			driver.findElement(By.id("sysverb_update")).click();
			
			String startDate = driver.findElement(By.xpath("//div[@class='datex date-calendar']")).getText();
				
			if(startDate .equals(changerequeststartdate)) {
				System.out.println("Start Date updated : " + startDate);
			}
			String endDate = driver.findElement(By.xpath("(//div[@class='datex date-calendar'])[2]")).getText();	
			
			if(endDate .equals(changerequestenddate)) {
				System.out.println("End Date updated : " + endDate);
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
