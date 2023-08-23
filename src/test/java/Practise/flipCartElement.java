package Practise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class flipCartElement {
	
	

	@SuppressWarnings({ "unchecked", "unlikely-arg-type" })
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//flipCartElement fce = new flipCartElement();
		WebDriver driver = null;
		int count = 0;
		
		try
		{
	//System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32 (3)\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
	ChromeOptions chromeOptions = new ChromeOptions();
      chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
    driver = new ChromeDriver(chromeOptions);			
        driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		}
		catch  (Exception e)
		{
			
			System.out.println("Values of the driver : -> " +e.getCause());
			
		}
		
		Thread.sleep(5000);
		@SuppressWarnings("rawtypes")
		FluentWait wait = new FluentWait(driver);
		WebElement cross = (WebElement) wait.until(
		    ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/button")));
		cross.click();
		
		Thread.sleep(5000);
		List<WebElement> header = driver.findElements(By.xpath("//div[@class='_331-kn _2tvxW'] //div[@class='_37M3Pb'] //div[@class='eFQ30H'] //div[@class='xtXmba']"));
		for(int i = 1; i<=header.size();i++)
		{
			String prod = driver.findElement(By.xpath("(//div[@class='_331-kn _2tvxW'] //div[@class='_37M3Pb'] //div[@class='eFQ30H'] //div[@class='xtXmba'])["+i+"]")).getText();
			
			if(prod.equals("Fashion"))
			{
				WebElement fashion = driver.findElement(By.xpath("(//div[@class='_331-kn _2tvxW'] //div[@class='_37M3Pb'] //div[@class='eFQ30H'] //div[@class='xtXmba'])["+i+"]"));
				Actions action = new Actions(driver);
				action.moveToElement(fashion).build().perform();
				//String kids = driver.findElement(By.xpath("(//a[@class='_6WOcW9 _2-k99T'])")).getText();
				//String kids = driver.findElement(By.linkText("Kids")).getText();
				
				List<WebElement> fashtionOptions = driver.findElements(By.xpath("//div[@class='ZEl_b_ _3joddx _2ogGYG _23xUYh _3pAV4E'] //a"));
				for(int j = 1 ;j<=fashtionOptions.size()-1; j++)
				{
					
				//String optionText = driver.findElement(By.xpath("//div[@class='ZEl_b_ _3joddx _2ogGYG _23xUYh _3pAV4E']) //a")).getText();
				String optionText = fashtionOptions.get(j).getText();
				System.out.println(optionText);
				if(optionText.equals("Kids"))
				{
				   
				   System.out.println("Values  :"+driver.findElement(By.linkText(optionText)).getText());
				   driver.findElement(By.linkText(optionText)).click();
				   
				   List<WebElement> allKids =   driver.findElements(By.xpath("//div[@class='_3Il5oO dwRsDN'] //span"));
				   Thread.sleep(2000);
				   for (int k =0 ; k<=allKids.size()-1;k++)
				   {
					   WebElement kidsOptions =  allKids.get(k);
					   action.moveToElement(kidsOptions).build().perform();
					   kidsOptions.click();
					   Thread.sleep(5000);
					   System.out.println("Verify all option os Kids section : " +kidsOptions.getText());
					   
				   }
			          
				   break;
				   
				}
				
				
				
				}break;
			
				
			}
	
			
		}
		
		
	
		
		
		

	}

}
