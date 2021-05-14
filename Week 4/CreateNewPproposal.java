package week4assignments_proposal;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateNewPproposal {

	public static void main(String[] args) throws InterruptedException {
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
		findElement.sendKeys("Proposal");
		Thread.sleep(3000);
		findElement.sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//div[text()='My Proposals']")).click();
		
		
		driver.switchTo().frame(0);
		driver.findElement(By.id("sysverb_new")).click();
		
		WebElement findElement2 = driver.findElement(By.id("std_change_proposal.short_description"));
		findElement2.click();
		findElement2.sendKeys("test");
		
		driver.findElement(By.id("sysverb_insert")).click();	
		System.out.println("New proposal created");
		
		
		

	}

}
