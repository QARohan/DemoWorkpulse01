package Practise;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.asserts.SoftAssert;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;


public class LatestFeatures {

	public static void main(String[] args) {
		
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

			System.out.println("Values of the driver : -> " +e.getCause());
			
		}
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		
		//Remember always the code of Scroll of the webPage.
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,400)"); // Got scroll values from the console site. 
		
		WebElement nameEditBox = driver.findElement(By.xpath("(//input[@name='name'])[1]"));
		System.out.println("Label name of the above :" +driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());
		System.out.println("Label name of the below :" +driver.findElement(with(By.tagName("div")).below(nameEditBox)).getText());
		
		WebElement loveIceCream= driver .findElement(By.xpath("//label[@for='exampleCheck1']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(loveIceCream)).click();
		
		WebElement rdb = driver.findElement(By.xpath("//input[@id='inlineRadio1']"));
		System.out.println("Values of right site lable :" +driver.findElement(with(By.tagName("label")).toRightOf(rdb)).getText());
		
		List<WebElement> allLabels = driver.findElements(By.xpath("//label"));
		System.out.println("All values of allLabels :  "+allLabels.size());
	    allLabels.stream().forEach(s -> System.out.println(s.getText()));
	    List<WebElement> values = allLabels.stream().collect(Collectors.toList());
	    System.out.println("All values of values :"+values.size());
	    
		SoftAssert a= new SoftAssert();
		a.assertEquals( allLabels.size(), values.size());
		
		// We will use the WindownHandle functionality, this is the interviwe question.
		//Switching the windown
		//driver.switchTo().newWindow(WindowType.WINDOW); We can also do work on new Windown.
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it= handles.iterator();
		String parentWindownId= it.next();
		String childWindowId= it.next();
		driver.switchTo().window(childWindowId);
		driver.get("https://rahulshettyacademy.com/");
		String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		System.out.println("Course Name  :"+courseName);
		driver.switchTo().window(parentWindownId);
		WebElement name = driver.findElement(By.cssSelector("[name='name']"));
		name.sendKeys(courseName);

		// We will take the screenshot of the particular WebElement, this is the interviwe question.
		File file = name.getScreenshotAs(OutputType.FILE);
		// Need to know more about the FileUtils because of at this time isn't working.
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());
	}

}
