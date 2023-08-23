package Practise;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class StreamSearching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = null;
		try
		{
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32 (3)\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
        driver = new ChromeDriver(chromeOptions);
		}
		catch  (Exception e)
		{
			System.out.println("Driver isn't working");
			
		}
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys("Rice");
		
	    List<WebElement> veggies= driver.findElements(By.xpath("//tr//td[1]"));
	    System.out.println(veggies.size());
	    List<WebElement> filteredList= veggies.stream().filter(veggie->veggie.getText().contains("Rice")).collect(Collectors.toList());
	    System.out.println(filteredList.size());
	    Assert.assertEquals(veggies.size(),filteredList.size());
	    

	}

}
