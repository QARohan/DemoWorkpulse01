package roughPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class iFrame extends DemoLogin {
	
	
	public static void helpPage() throws InterruptedException
	{
		Thread.sleep(3000);
		WebElement helpiframe = driver.findElement(By.xpath("//iframe[@src= 'https://opssite.workpulse.com/Support/Docs#!#UserManagement']"));
		helpiframe.click();
		driver.switchTo().frame(helpiframe);
		
	}
	
	

}
