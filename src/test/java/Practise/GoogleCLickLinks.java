package Practise;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class GoogleCLickLinks {
	static WebDriver driver;
	static WebElement values;
    //Constructor that will be automatically called as soon as created the object of the class.
	public GoogleCLickLinks (WebDriver driver)
	{
		this.driver= driver; // set WebDriver for current page.
	
	}
	
	public void getData(int a)
	{
	System.out.println("Yes");	
	}

	public static void main(String[] args) throws InterruptedException, ArithmeticException {
		// TODO Auto-generated method stub
	
		
		GoogleCLickLinks gc= new GoogleCLickLinks(driver);
		try
		{
		//System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32 (3)\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		}
		catch  (Exception e)
		{
			
			System.out.println("Values of the driver : -> " +e.getCause());
			
		}
		
        int clicks = driver.findElements(By.xpath("//div[@id='SIvCob'] /a")).size(); 
        for(int i=1; i<=clicks-7; i++)
        {
        	driver.findElement(By.xpath("(//div[@id='SIvCob'] /a)["+ i +"]")).click();

        }
         Thread.sleep(2000);
//        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        ((JavascriptExecutor) driver).executeScript("document.getElementsByName('q').values='rohan gupta'",value);
          
         values = driver.findElement(By.xpath("(//a[@class='gb_q'])[1]"));
         System.out.println(values);
        try
        {
        	 Actions action = new Actions(driver);
             action.moveToElement(values).contextClick().build().perform();
             action.moveToElement(driver.findElement(By.xpath("//input[@type='text']"))).click().keyDown(Keys.SHIFT).sendKeys("rohan").doubleClick().build().perform();
             
            
        }
       
        catch(ArithmeticException ae)
        {
        	System.out.println("Values1" );
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
        	System.out.println("Values2" );	
        }
        finally
        {
        	System.out.println("Final values of the Exception !" );	
        	SuperKey sk = new SuperKey(driver);
        	SuperKey.clickOnPath();
        	sk.getData(5);
        	
        }
       
	}

	
}
