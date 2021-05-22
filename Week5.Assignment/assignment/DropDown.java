package week5.assignment;

import java.awt.List;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {

	@Test(dataProvider = "TestData")
	public  void dropDown(String dropdown1) throws InterruptedException {
		// Pre condition : Chrome Driver need to be downloaded and set to the path
		WebDriverManager.chromedriver().setup();
		
		//Launch the chrome browser
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		
		//Find the element
		WebElement selectTrainingProgram = driver.findElement(By.id(dropdown1)); 
		
		//convert the Web Element as Select
		Select selectTrainingProgram1 = new Select (selectTrainingProgram);
		
		int size = selectTrainingProgram1.getOptions().size();
		selectTrainingProgram1.selectByIndex(size - 2);
		
		//Choose the dropdown by the index [3]
		
		//selectTrainingProgram1.selectByIndex(3);
	
	}
	@DataProvider(name="TestData")
	public Object[][] fetchData() throws InvalidFormatException, IOException{
		
		String[][] data = ReadExcel.readExcel("DropDown Lead");
		return data;
	}

}
