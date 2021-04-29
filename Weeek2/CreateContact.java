package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click();
		driver.findElement(By.id("firstNameField")).sendKeys("Vishalakshi");
		driver.findElement(By.id("lastNameField")).sendKeys("Thanuj");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Vishali");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Thanu");
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("testing");
		driver.findElement(By.id("createContactForm_description")).sendKeys("No comments");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("kjyh@gmail.com");
		
		WebElement statedropdown = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select statedropdown1 = new Select (statedropdown);
		statedropdown1.selectByVisibleText("New York");
		
		driver.findElement(By.name("submitButton")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateContactForm_description")).clear();
		
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Confidential");
		
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		String viewContact = driver.findElement(By.id("sectionHeaderTitle_contacts")).getText();
		if (viewContact.equals("View Contact"));
		{
		System.out.println("Title match - Testcase passed");
		}
		{
		System.err.println("Title mismatch - Testcase Failed");
		}
		
		

	}

}
