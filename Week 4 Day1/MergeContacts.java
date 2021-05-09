package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class MergeContacts {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Merge Leads")).click();
		driver.findElement(By.xpath("//span[text()='From Lead']/following::img")).click();
		Thread.sleep(2000);
		Set<String> allWindows =driver.getWindowHandles();
		List<String> allWindows1 = new ArrayList<String>(allWindows);
		driver.switchTo().window(allWindows1.get(1));
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
		driver.switchTo().window(allWindows1.get(0));
		
		driver.findElement(By.xpath("//span[text()='To Lead']/following::img")).click();
		Thread.sleep(3000);
		
		allWindows =driver.getWindowHandles();
		allWindows1 = new ArrayList<String>(allWindows);	
		driver.switchTo().window(allWindows1.get(1));
		
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();
		Thread.sleep(3000);
		driver.switchTo().window(allWindows1.get(0));
		driver.findElement(By.linkText("Merge")).click();
		Alert alert = driver.switchTo().alert();
		
		alert.accept();
		
		System.out.println("Title of the page is : " +driver.getTitle());
		
	}

}
