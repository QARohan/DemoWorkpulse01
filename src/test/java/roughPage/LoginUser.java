package roughPage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginUser extends DemoLogin {

	static String name = "Rohan";

	public static void getLogin() {
		driver.findElement(By.xpath("//div[@class ='bg-whaite'] //input[@name='username']")).sendKeys(name); // Parent
																												// to
																												// child
																												// Xpath
																												// releationship
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("QAtest123#"); // fild element using Xpath
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("4444"); // Xpath with index if values are
																						// same there.
		driver.findElement(By.cssSelector("button[type='submit']")).click();

	}

	public static void dashboardtitle() {
		String title = driver.findElement(By.xpath(
				"//span[@class = 'navbar-dashboard-greeting navbar-text verticalbar title-padding app-dashboard']"))
				.getText();

		System.out.println("Ttitle values : " + title);

		// String val = "Good morning, "+name+""; also user with instance of String

		if (title.equals("Good morning, " + name + "")) {
			Assert.assertEquals(title, "Good morning, " + name + "");
			System.out.println("Test case has been Passed  = Good morning, " + name + "");

		} else if (title.equals("Good afternoon, " + name + "")) {
			Assert.assertEquals(title, "Good afternoon, " + name + "");
			System.out.println("Test case has been Passed  =  Good afternoon, " + name + "");

		} else if (title.equals("Good evening, " + name + "")) {
			Assert.assertEquals(title, "Good evening, " + name + "");
			System.out.println("Test case has been Passed  =  Good evening, " + name + "");

		}

	}

	public static void Scrolldown() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		js.executeScript("window.scrollBy(0,500)", "");

	}
	
	
	public static void checkAllOptions() throws InterruptedException {
		int URLsize = driver.findElements(By.xpath("//img[@class = 'text-center imgdisplay-sm']")).size(); // Identified
																											// the
																						                 	// counts of
																											// HyperLink
																											// Images.
		for (int i = 1; i <= URLsize-19 ; i++) {
			
			//String clickonlinkTab=Keys.chord(Keys.CONTROL,Keys.ENTER);
			driver.findElement(By.xpath("(//img[@class = 'text-center imgdisplay-sm'])[" + i + "]")).click();
			//driver.findElements(By.xpath("(//img[@class = 'text-center imgdisplay-sm'])[" + i + "]")).get(i).sendKeys(clickonlinkTab);
			Thread.sleep(5000);
			driver.navigate().back();
			Thread.sleep(5000);
			if (i == 13) {
				Scrolldown();
			}
		}
		Set<String> options=driver.getWindowHandles();//4
		Iterator<String> it=options.iterator();
		while(it.hasNext())
		{
			
		   driver.switchTo().window(it.next()); // Switch to others screen and get the title of the screen and validating all values.
		   System.out.println(driver.getTitle());
		
		}
		
		driver.switchTo().defaultContent(); //Switch to default screen of the web-page

	}

	public static void logout() throws InterruptedException {
		// driver.findElement(By.cssSelector("a[id*='navbarDropdo']")).click(); //
		// CssSelector with Regular path using * marked
		driver.findElement(By.xpath("//a[contains(@id,'navbarDropdo')]")).click(); // xpath with Regular path using
																					// contains kewword
		driver.findElement(By.xpath("//a[@title='Log off (rohan)']")).click(); // Click on log off link
		Thread.sleep(5000);
		driver.navigate().refresh();

	}

	

}
