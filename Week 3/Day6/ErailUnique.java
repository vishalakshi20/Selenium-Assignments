package week3.day2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailUnique {

	public static void main(String[] args) throws InterruptedException {
		
//		Set the system property and Launch the URL
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		
//		Click the 'sort on date' checkbox
		driver.findElement(By.id("chkSelectDateOnly")).click();
				
//		clear and type in the from station text field
		
//		clear and type in the to station text field
		
		driver.findElement(By.id("txtStationFrom")).clear();
		driver.findElement(By.id("txtStationFrom")).sendKeys("Chennai");
		driver.findElement(By.xpath("//div[text()=' Egmore']")).click();
			
		driver.findElement(By.id("txtStationTo")).clear();
		driver.findElement(By.id("txtStationTo")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//div[@title='Bangalore Cant']//div[1]")).click();
			
//		Add a java sleep for 2 seconds
		Thread.sleep(3000);
		
//		Store all the train names in a list
		
		List<WebElement> trainNames = driver.findElements(By.xpath("//table[@class = 'DataTable TrainList TrainListHeader']"));
		List <String> list1= new ArrayList<String>();
	 	for (int i = 0; i < trainNames.size(); i++) {
	 		
	 		String list2= trainNames.get(i).getText();
	 		list1.add(list2);
	 		
	 		System.out.println(list1.size());
	 		}
			
//		Add the list into a new Set
	 	HashSet<String> set = new HashSet<String>(list1);
			
//		And print the size of it
	 	for (String trainname1 : list1) 
		{
			

			set.add(trainname1);

		}
		System.out.println(set);
		System.out.println(set.size());

	}

}














