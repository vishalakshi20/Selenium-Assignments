package week4assignments_changemanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssessChangeRequest_TC2 {

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
			driver.findElement(By.xpath("(//div[text()='Open'])[3]")).click();
			
		
			driver.switchTo().frame(0);
			WebElement number = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']")); 
			new Select(number).selectByIndex(1);
			
			WebElement findElement3 = driver.findElement(By.xpath("//input[@placeholder='Search']"));
			findElement3.click();
			findElement3.sendKeys("CHG0030753");
			findElement3.sendKeys(Keys.ENTER);
			
			driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
			
			WebElement changerequeststate = driver.findElement(By.id("change_request.state")); 
			new Select(changerequeststate).selectByIndex(1);
			driver.findElement(By.id("lookup.change_request.assignment_group")).click();
			
			Set<String> windows = driver.getWindowHandles();
			List<String> windows1 = new ArrayList<String>(windows);
			String windowHandle1 = windows1.get(1);
			
			driver.switchTo().window(windowHandle1);
			//WebElement findElement2 = driver.findElement(By.xpath("//input[@class='form-control']"));
			driver.findElement(
			By.xpath("//div[@id='treenode_0']/div[1]/div[1]/div[29]/table[1]/tbody[1]/tr[1]/td[1]/img[1]")).click(); 
			WebElement assignedGrp = driver.findElement(By.cssSelector( "div#treenode_0>div>div>div:nth-of-type(29)>div>div:nth-of-type(5)>table>tbody>tr>td:nth-of-type(3)>a"));
			assignedGrp.click();
			
			driver.switchTo().window(windows1.get(0));
			driver.switchTo().frame(0);
			driver.findElement(By.xpath("//button[@data-for='sys_display.change_request.assigned_to']//span[1]")).click();
			windows = driver.getWindowHandles();
			windows1 = new ArrayList<String>(windows);
			driver.switchTo().window(windows1.get(1));
			
			WebElement findElement4 = driver.findElement(By.xpath("//input[@placeholder='Search']"));
			findElement4.click();
			findElement4.sendKeys("ITIL User");
			findElement4.sendKeys(Keys.ENTER);
			driver.findElement(By.linkText("ITIL User")).click();	
			driver.switchTo().window(windows1.get(0));
			driver.switchTo().frame(0);
			
			driver.findElement(By.id("sysverb_update")).click();
			
			String state = driver.findElement(By.xpath("//td[text()='Assess']")).getText();
				
			if(state .equals("Assess")) {
				System.out.println("State updated as Assess successfully");
			}
			String assignedTo = driver.findElement(By.xpath("(//a[@class='linked'])[2]")).getText();	
			
			if(assignedTo .equals("ITIL User")) {
				System.out.println("Assigned To updated as ITIL User successfully");
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
