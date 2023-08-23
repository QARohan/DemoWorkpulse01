package roughPage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public  class DemoLogin {
	

	public static WebDriver driver ;
	//@SuppressWarnings("deprecation")
	public DemoLogin() { //Constructor of the class
    
		try {
			System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32 (3)\\chromedriver.exe");
			ChromeOptions chromeOptions = new ChromeOptions();
	        chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
	        driver = new ChromeDriver(chromeOptions);
      // driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS); // implicitlyWait declared on globally 
			
		
 
		}
		catch (Exception e)
		{
			System.out.println("IllegalStateException");
			System.out.println("Driver aren't working");
		
			
		}
		
	}
	
	public static void brokenLinkHomePage() throws MalformedURLException, IOException

	{
		 SoftAssert a =new SoftAssert();
		   List<WebElement> links =  driver.findElements(By.xpath("//div[@class='login-right-main-table-cell'] //a"));
		   for(WebElement link : links)
		 {
			 String url = link.getAttribute("href");
			 HttpURLConnection   conn= (HttpURLConnection)new URL(url).openConnection();

	          conn.setRequestMethod("HEAD");

	          conn.connect();

	          int respCode = conn.getResponseCode();

	          System.out.println(" Links are not broken on the page : " +respCode);

	          a.assertTrue(respCode<400, "The link with Text"+link.getText()+" is broken with code" +respCode);
		 }
		 a.assertAll();
		 
		
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		DemoLogin obj = new DemoLogin();
		driver.get("http://opssite.workpulse.com/");
		driver.manage().window().maximize();
		String gettittle = driver.getTitle();
		
		System.out.println(gettittle);
				
		if (driver.getTitle() == gettittle)
		{
			driver.close();
			
		}
		Thread.sleep(5000);
		DemoLogin.brokenLinkHomePage();
		LoginUser.getLogin(); // login methos 
		Thread.sleep(5000);
		LoginUser.dashboardtitle(); // get logged in user title to verify.
		Thread.sleep(2000);
		LoginUser.checkAllOptions();
		//LoginUser.Scrolldown(); // this is the method of scroll down and we can user any there of the class.
		//LoginUser.logout();
		
		
		AdminPage.clickOnAdmin();// Another class of the get all details of the Admin page.
		//AdminPage.searchedUser(); // Search any user from the list.
		AdminPage.identifiedMenuName();
		//AdminPage.checkAllCheckbox(); //need to more concept for the methods
		AdminPage.organizationTab();
		//iFrame.helpPage();
		

	}

}
