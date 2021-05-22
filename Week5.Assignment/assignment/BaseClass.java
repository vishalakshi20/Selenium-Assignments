package week5.assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	ChromeDriver driver;
	@Parameters({"url","username","password"})
	@BeforeMethod
	public void setup (String url, String username, String password) throws InterruptedException {
	
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();
	driver.findElement(By.id("username")).sendKeys(username);
	driver.findElement(By.id("password")).sendKeys(password);
	driver.findElement(By.className("decorativeSubmit")).click();
	
	driver.findElement(By.linkText("CRM/SFA")).click();
	}
	@AfterMethod 
	public void close() {
		driver.close();
		
	}

}
