package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		/*1) Go to https://www.nykaa.com/
			2) Mouseover on Brands and Mouseover on Popular
			3) Click L'Oreal Paris
			4) Go to the newly opened window and check the title contains L'Oreal Paris
			5) Click sort By and select customer top rated
			6) Click Category and click Shampoo
			7) check whether the Filter is applied with Shampoo
			8) Click on L'Oreal Paris Colour Protect Shampoo
			9) GO to the new window and select size as 175ml
			10) Print the MRP of the product
			11) Click on ADD to BAG
			12) Go to Shopping Bag 
			13) Print the Grand Total amount
			14) Click Proceed
			15) Click on Continue as Guest
			16) Check if this grand total is the same in step 13
			17) Close all windows */

		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement findElement = driver.findElement(By.xpath("//li[@class = 'menu-dropdown-icon']/a"));
		Actions builder = new Actions(driver);
		builder.moveToElement(findElement).build().perform();
		
		WebElement findElement1 = driver.findElement(By.xpath("//div[@class = 'BrandsCategoryHeading']/a"));
		builder.moveToElement(findElement1).build().perform();
		
		driver.findElement(By.xpath("//div[@id='brandCont_Popular']/ul[1]/li[5]/a[1]/img[1]")).click();
		
		Set<String> windows = driver.getWindowHandles();
				
		List<String> windows1 = new ArrayList<String>(windows);
		driver.switchTo().window(windows1.get(1));
		Thread.sleep(5000);
		String title = (driver.getTitle());
		if(title.contains("L'Oreal Paris"))
		{
			System.out.println("Tile is displayed as L'Oreal Paris");
		}
		
		driver.findElement(By.xpath("//span[@title='POPULARITY']")).click();
		driver.findElement(By.xpath("//input[@id='3']/following-sibling::div[1]")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='clearfix'])[2]")).click();
		driver.findElement(By.xpath("//li[@class='filter-list-header  ']")).click();
		driver.findElement(By.xpath("(//div[@class='category-wrap-top']//li)[3]")).click();
		driver.findElement(By.xpath("//div[@class='control__indicator']")).click();
		
		String filtersApplied = driver.findElement(By.xpath("//span[text()='filters applied']")).getText();
		String shampooclose = driver.findElement(By.xpath("//li[text()='Shampoo']")).getText();
		
		if (shampooclose.contains("Shampoo")){
			System.out.println("Filter is applied for Shampoo");
		}
		
		driver.findElement(By.xpath("//div[@id='listingContainer']/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[10]/div[1]/a[1]/div[1]/div[2]/div[1]/h2[1]/span[1]")).click();
		Thread.sleep(2000);
		windows = driver.getWindowHandles();
		windows1 = new ArrayList<String>(windows);
		driver.switchTo().window(windows1.get(2));
		
		driver.findElement(By.xpath("//span[text()='175ml']")).click();
		String Mrp = driver.findElement(By.xpath("//span[text()='135']")).getText();
		Mrp = Mrp.replaceAll("//D", " ").trim();
		
		System.out.println("The Shampoo MRP is " +Mrp);
		
		
		driver.findElement(By.xpath("//button[contains(@class,'combo-add-to-btn prdt-des-btn')]")).click();
		
		driver.findElement(By.xpath("//div[@class='cursor-hand arrowup-tooltip']//div[1]")).click();
		Thread.sleep(2000);
		
		String GrandTotal = driver.findElement(By.xpath("//div[text()='205']")).getText();
		GrandTotal = GrandTotal.replaceAll("//D", " ").trim();
	
		System.out.println("Grand total of the bill : " +GrandTotal);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@type='button']//span[1]")).click();
		
		driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();
		
		String GrandTotal2 = driver.findElement(By.xpath("(//div[@class='value']//span)[2]")).getText();
		GrandTotal2 = GrandTotal2.replaceAll("//D", " ").trim();
		System.out.println("Grand total of the bill : " +GrandTotal2);
		
		if(GrandTotal.equals(GrandTotal2)) {
			System.out.println("The total is same");
		}
		else {
			System.out.println("The total is incorrect");
		}
		driver.close();
		driver.switchTo().window(windows1.get(1)).close();
		driver.switchTo().window(windows1.get(0)).close();
	}
	
}
