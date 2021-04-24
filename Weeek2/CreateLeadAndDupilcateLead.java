package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLeadAndDupilcateLead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*1. Launch URL "http://leaftaps.com/opentaps/control/login"
2. Enter UserName and Password Using Id Locator
3. Click on Login Button using Class Locator
4. Get the Title and verify it
4. Click on CRM/SFA Link
5. Click on Leads Button
6. Click on Create Lead Button
7. Fill all the fields Except Parent Account
   (Note : Enter Date in Date of Birth field by using sendKeys)
8. Click on create Lead Button 
9. Click on Duplicate Lead button
10. Clear the Existing Company name And Enter the New Company name
11. Click on the Create Lead button.
12. Get The Duplicate Company name and Verify it.
13. Close the Browser.*/
		

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		String title = driver.getTitle();
		if (title.equals("Leaftaps - TestLeaf Automation Platform"));{
		System.out.println("Title match - Testcase passed");
		}
		{
		System.err.println("Title mismatch - Testcase Failed");
		}
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Atos");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Vishalakshi");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Thanuj");
		
		WebElement srcdropdown = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select srcdropdown1 = new Select (srcdropdown);
		srcdropdown1.selectByVisibleText("Employee");
		
		WebElement Mrkdropdown = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select Mrkdropdown1 = new Select (Mrkdropdown);
		Mrkdropdown1.selectByVisibleText("Demo Marketing Campaign");
		
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Vishali");
		driver.findElement(By.id("createLeadForm_lastNameLocal")).sendKeys("Thanu");
		driver.findElement(By.id("createLeadForm_personalTitle")).sendKeys("Mrs");
		driver.findElement(By.id("createLeadForm_birthDate")).sendKeys("05/20/88");
		
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("Profile Details");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Testing");
		
		driver.findElement(By.id("createLeadForm_annualRevenue")).sendKeys("1000000");
		
		WebElement prfcurdropdown = driver.findElement(By.id("createLeadForm_currencyUomId"));
		Select prfcurdropdown1 = new Select (prfcurdropdown);
		prfcurdropdown1.selectByVisibleText("INR - Indian Rupee");
		
		WebElement inddropdown = driver.findElement(By.id("createLeadForm_industryEnumId"));
		Select inddropdown1 = new Select (inddropdown);
		inddropdown1.selectByVisibleText("Computer Software");
		
		WebElement owndropdown = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select owndropdown1 = new Select (owndropdown);
		owndropdown1.selectByVisibleText("Corporation");
		
		driver.findElement(By.id("createLeadForm_numberEmployees")).sendKeys("5000");
		driver.findElement(By.id("createLeadForm_sicCode")).sendKeys("12345");
		
		
		driver.findElement(By.id("createLeadForm_tickerSymbol")).sendKeys("458$");
		
		driver.findElement(By.id("createLeadForm_description")).sendKeys("No comments");
		driver.findElement(By.id("createLeadForm_importantNote")).sendKeys("NIL");
		
		driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode")).sendKeys("91");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("9940673633");
		driver.findElement(By.id("createLeadForm_primaryPhoneAreaCode")).sendKeys("044");
		driver.findElement(By.id("createLeadForm_primaryPhoneAskForName")).sendKeys("Sharika");
		driver.findElement(By.id("createLeadForm_primaryPhoneExtension")).sendKeys("022");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("visafiza@gmail.com");
		driver.findElement(By.id("createLeadForm_primaryWebUrl")).sendKeys("www.testleaf.com");
		driver.findElement(By.id("createLeadForm_generalToName")).sendKeys("Vishalakshi");
		driver.findElement(By.id("createLeadForm_generalAttnName")).sendKeys("Thanuj");
		driver.findElement(By.id("createLeadForm_generalAddress1")).sendKeys("No.5,ruby flats");
		driver.findElement(By.id("createLeadForm_generalAddress2")).sendKeys("Mogappair");
		driver.findElement(By.id("createLeadForm_generalCity")).sendKeys("chennai");
		
		WebElement statedropdown = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select statedropdown1 = new Select (statedropdown);
		statedropdown1.selectByVisibleText("Alabama");
		
		driver.findElement(By.id("createLeadForm_generalPostalCode")).sendKeys("600037");
		
		WebElement ctrydropdown = driver.findElement(By.id("createLeadForm_generalCountryGeoId"));
		Select ctrydropdown1 = new Select (ctrydropdown);
		ctrydropdown1.selectByVisibleText("India");
		
		driver.findElement(By.id("createLeadForm_generalPostalCodeExt")).sendKeys("600037");
		
		driver.findElement(By.className("smallSubmit")).click();
		
		driver.findElement(By.linkText("Duplicate Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).clear();
		String newcompanyname = "CTS";
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(newcompanyname);
		
		driver.findElement(By.className("smallSubmit")).click();
		
		String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		{
			String text1 = text.replaceAll("[^a-zA-Z]","");
			System.out.println(text1);
			if (text1.equals(newcompanyname)) {
				System.out.println("Duplicate Lead name verified");
			}else
			System.out.println("Duplicate lead name incorrect");
			
		}
		driver.close();
	}
}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	









