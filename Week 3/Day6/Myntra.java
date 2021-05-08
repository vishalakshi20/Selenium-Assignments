package week3.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {
	

	public static void main(String[] args) throws InterruptedException {
		
		/*1) Open https://www.myntra.com/
			2) Mouse over on WOMEN 
			3) Click Jackets & Coats
			4) Find the total count of item 
			5) Validate the sum of categories count matches
			6) Check Coats
			7) Click + More option under BRAND	
			8) Type MANGO and click checkbox
			9) Close the pop-up x
			10) Confirm all the Coats are of brand MANGO
			11) Sort by Better Discount
			12) Find the price of first displayed item
			13) Mouse over on size of the first item
			14) Click on WishList Now
			15) Close Browser */
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement findElement = driver.findElement(By.xpath("//a[@data-group='women'][1]"));
		Actions builder = new Actions(driver);
		builder.moveToElement(findElement).build().perform();
		
		driver.findElement(By.linkText("Jackets & Coats")).click();
		
		String items = driver.findElement(By.className("title-count")).getText();
		items = items.replaceAll("\\D", "");
		int itemstotal = Integer.parseInt(items);
		System.out.println("Total count of items:" + itemstotal);
		
		String jackets = driver.findElement(By.xpath("//span[@class='categories-num']")).getText();
		String coats = driver.findElement(By.xpath("(//span[@class='categories-num'])[2]")).getText();
		
		jackets= jackets.replaceAll("\\D", "");
		coats= coats.replaceAll("\\D", "");
		int jackets1 = Integer.parseInt(jackets);
		int coats1 = Integer.parseInt(jackets);
		int total = jackets1 + coats1;
		if (itemstotal == total) {
			
			System.out.println("Jackets and Coats count matches with total ");
		}
			else {
				System.out.println("Count Mismatch");
			}
		
		driver.findElement(By.xpath("(//div[@class='common-checkboxIndicator'])[2]")).click();
		
		driver.findElement(By.className("brand-more")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.className("FilterDirectory-searchInput")).sendKeys("Mango");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='FilterDirectory-count']/following-sibling::div[1]")).click();
		
		driver.findElement(By.xpath("//span[contains(@class,'myntraweb-sprite FilterDirectory-close')]")).click();
		
		List<WebElement> brand = driver.findElements(By.xpath("//div[@class='search-searchProductsContainer row-base']"));

		for (WebElement eachBrand : brand) {
			String brand1 = eachBrand.getText();
			System.out.println("BrandName:" + brand1);
		}
		driver.findElement(By.xpath("//span[text()='Recommended']")).click();
		driver.findElement(By.xpath("(//label[@class='sort-label '])[3]")).click();
		Thread.sleep(3000);
		
		String price = driver.findElement(By.xpath("(//span[(@class='product-discountedPrice')])")).getText();
		System.out.println("First item price is : " +price);
		
		WebElement findElement1 = driver.findElement(By.xpath("//div[@class='product-price']//span[1]"));
		Actions builder1 = new Actions(driver);
		builder.moveToElement(findElement1).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(@class,'product-wishlistFlex product-actionsButton')]")).click();
		
		
		
		driver.close();
}
	}












