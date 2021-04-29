package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

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
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("(//span[@class='x-tab-strip-text '])[3]")).click();
		driver.findElement(By.xpath("//label[text()='Email Address:']/following::input")).sendKeys("xyz@gmail.com");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		String tESTONE = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']")).getText();
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a[1]")).click();
		Thread.sleep(2000);
	
		driver.findElement(By.linkText("Duplicate Lead")).click();
		String title = driver.findElement(By.id("sectionHeaderTitle_leads")).getText();
		driver.findElement(By.className("smallSubmit")).click();
		
		String tESTONE1 = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		if (tESTONE .contentEquals(tESTONE1)) {
			System.out.println("Duplicate Lead name captured");
			}
		else
		{System.out.println("Duplicate Lead name not captured");
		
		}
			
		driver.close();
		
	}

	}


