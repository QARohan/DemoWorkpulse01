package Practise;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class ScrollPractise {

	public static WebDriver driver ;
	public ScrollPractise()
	{
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
		
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ScrollPractise sp = new ScrollPractise();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,650)") ; // Got Window.scrollBy from the Console site
        Thread.sleep(3000);
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=500"); // Got scroll values from the Console site.
        List<WebElement> values = driver.findElements(By.cssSelector("div[class= 'tableFixHead'] td:nth-child(4)"));
        int sum = 0;
        for(int i = 0; i< values.size();i++)
        {
        	sum =sum + Integer.parseInt(values.get(i).getText());
        }
        System.out.println(sum);
        
        int totalamout = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
        
        Assert.assertEquals(sum, totalamout);
        
       List<WebElement> producttable = driver.findElements(By.xpath("(//table[@id='product'])[1] //tbody //tr //td[3]"));
       int productAmout = 0;
       for(int j = 0; j< producttable.size(); j++)
       {
    	   productAmout = productAmout + Integer.parseInt( producttable.get(j).getText());  
       }
       System.out.println(productAmout);
      
	}
	

}
