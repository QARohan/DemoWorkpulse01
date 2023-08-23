package Practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuperKey extends GoogleCLickLinks  {


	public SuperKey(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static void clickOnPath()

	{
		System.out.println(driver.findElement(By.cssSelector("a[class='gb_e'] path")).getText());
		driver.findElement(By.cssSelector("a[class='gb_e'] path")).click();
		
	}
	
	public void getData(int a)
	{
		super.getData(5);
		System.out.println("No");
		
	}


	
	
	
	



	
	
	
	

}
