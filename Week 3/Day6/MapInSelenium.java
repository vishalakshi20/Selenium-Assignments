package week3.day2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MapInSelenium {

	public static void main(String[] args) throws InterruptedException {
//		1) Set the property
		
//		2) Initiate ChromeDriver class

//		3) Launch the URL - https://erail.in/
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
			
//		4) Maximize the browser
		driver.manage().window().maximize();
		
			
//		5) Add implicityWait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
		
			
//		6) Clear and type in the from station
		driver.findElement(By.id("txtStationFrom")).clear();
		Thread.sleep(3000);
		driver.findElement(By.id("txtStationFrom")).sendKeys("Chennai");
		driver.findElement(By.xpath("//div[text()=' Egmore']")).click();
			
//		7) Clear and type in the to station
		driver.findElement(By.id("txtStationTo")).clear();
		driver.findElement(By.id("txtStationTo")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//div[@title='Bangalore Cant']//div[1]")).click();
			
//		8) Uncheck the 'Sort on Date' checkbox	
		driver.findElement(By.id("chkSelectDateOnly")).click();
		Thread.sleep(3000);
		
		
//		9) Declare a Map
		
		Map<String, String> map = new HashMap<String, String>();
		
//		10) Store the table in a web element
		
		List<WebElement> traintable = driver.findElements(By.xpath("//table[@class = 'DataTable TrainList TrainListHeader']"));
					
//		11) Iterate the rows and store all the columns in a List
//		13) Check and get the values that start with 'S'
//		14) If the condition satisfies add it into the map as key & 	value

//		15) Print those values by iterating the map
			
		for (WebElement trainList : traintable) {
			
			List<WebElement> trainList1 = trainList.findElements(By.xpath("//table[@class = 'DataTable TrainList TrainListHeader']//td"));
			for (WebElement List1 : trainList1) {
				if (List1.getText().startsWith("S")) 
				{

					map.put(List1.getText(), List1.getText());
				
			}
		}
		}
			{
				System.out.println(map.values());	
			}

		
		
		
		
		
		
		
		
		
		
		

	}

}
