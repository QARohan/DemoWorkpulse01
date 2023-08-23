package roughPage;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AdminPage extends DemoLogin {
	
	
	public static void clickOnAdmin() throws InterruptedException
	{
		LoginUser.Scrolldown();
		driver.findElement(By.xpath("//a[@href = '/AdminMD'] //img[@class='text-center imgdisplay-sm']")).click(); // Xpath relationShip from parent to child xpath.
        System.out.println("Admin screen has been opened!!");	
       
        
	}
	
	public static void searchedUser() throws InterruptedException
	{
		 //Search any user name there.
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@placeholder= 'Search']")).sendKeys("Rohan ");// Using cssSelector identified the elements
        WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(10)); //Explicitly Wait declared globally & locally as per you need
        wt.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table[class= 'dx-datagrid-table dx-datagrid-table-fixed dx-select-checkboxes-hidden'] span[class='card-label ellipsis']")));
        List<WebElement> options = driver.findElements(By.cssSelector("table[class= 'dx-datagrid-table dx-datagrid-table-fixed dx-select-checkboxes-hidden'] span[class='card-label ellipsis']")); //Below the cssSelector : relationship of the Parent to child cssSelector
        Thread.sleep(5000);
        for(WebElement option : options)
        {	
        	if (option.getText().equalsIgnoreCase("Director Of Operations"))
        	{
        		option.click();
        		break;
        	}
        }
	}
	
	public static void identifiedMenuName() throws InterruptedException
	{
		int menuName =  driver.findElements(By.xpath("//span[@class='menuName']")).size();
		WebElement org = driver.findElement(By.xpath("//span[@class='menuName']"));
		
		for (int i=1; i<=menuName;i++)
		{
			System.out.println(driver.findElement(By.xpath("(//span[@class='menuName'])["+i+"]")).getText());
		}
		
		Actions action = new Actions(driver);
		action.moveToElement(org).perform();
		Thread.sleep(5000);
		
	}
	
	public static void organizationTab() throws InterruptedException
	{
		String[] clickArrow = {"Organization", "Audit", "Asset" , "Book", "Health", "People", "GiSMo", "Desk", "Task", "WOW"};	
		int j=0;
	    List<WebElement> alltabs = driver.findElements(By.xpath("//ul[@id='sidebarDevops'] //span[@class='menuName']"));
		System.out.println(alltabs.size());
		
		for (int i =0; i<=alltabs.size()-1;i++)
		{
			j++;
			String tabName= alltabs.get(i).getText();
			System.out.println("Values of the tanName :" +tabName);
			//Check whether name you extracted is present in the Array or not
			List<String> clickArrowList = Arrays.asList(clickArrow);
			if (clickArrowList.contains(tabName))
			{
				System.out.println(clickArrowList.size());
				//Thread.sleep(2000); because of declared impilicit wait at global level
				driver.findElement(By.xpath("//span[@class='pull-right-container']")).click(); // click on Org arrow there 
				LoginUser.Scrolldown();
				if(j==clickArrow.length)
				{
					break;
				}
					
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void checkAllCheckbox() // Need to improvement on the method
	{
		int checkbox = driver.findElements(By.xpath("//input[@type= 'checkbox']")).size();
		System.out.println("Values of Checkbox :" +checkbox);	
		
		for (int i =1 ; i<=checkbox ; i++)
		{
			driver.findElement(By.xpath("(//input[@type= 'checkbox'])["+i+"]")).click();
			
		}
	}
	

	


}
