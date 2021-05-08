package week3.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailSort {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		// Set the property
		//2) Initiate ChromeDriver class
		//3) Launch the URL - https://erail.in/
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
	
//4) Maximize the browser
		
		driver.manage().window().maximize();
	
//5) Add implicityWait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
	
//6) Clear and type in the from station
		driver.findElement(By.id("txtStationFrom")).clear();
		Thread.sleep(3000);
		driver.findElement(By.id("txtStationFrom")).sendKeys("Chennai");
		driver.findElement(By.xpath("//div[text()=' Egmore']")).click();
	
//7) Clear and type in the to station
		driver.findElement(By.id("txtStationTo")).clear();
		driver.findElement(By.id("txtStationTo")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//div[@title='Bangalore Cant']//div[1]")).click();
//8) Uncheck the 'Sort on Date' checkbox		
		
		driver.findElement(By.id("chkSelectDateOnly")).click();
		Thread.sleep(3000);
		
	
//9) Find all the train names using xpath and store it in a list
		List<WebElement> traintable = driver.findElements(By.xpath("//table[@class = 'DataTable TrainList TrainListHeader']//td[2]/a"));
		
		List <String> list1= new ArrayList<String>();
		 	for (int i = 0; i < traintable.size(); i++) {
		 		
		 		String list2= traintable.get(i).getText();
		 		list1.add(list2);
		 		
		 		System.out.println(list2);
		 		}
	//10) Use Java Collections sort to sort it and then print it	 
		 	Collections.sort(list1);
        	System.out.println(list1);
			}
	
	
	        
}
