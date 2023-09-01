package textNGAnnotation;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Da2TextNGAnnotation {
	
	@BeforeMethod
	public void beoreMethod()
	{
		System.out.println("Before Method  !!");	
	}
	
	@AfterMethod
	public void afteMethod()
	{
		System.out.println("After Method  !!");	
	}
	
	@Test(groups = {"Smoke"})
	public void putdata1()
	{
		System.out.println("Data are present 1!!");	
		Assert.assertTrue(false);
	}
	
	@Parameters({"variableName1", "variableName2"}) // It's Parameter declare in global level under the textng.xml suite.
	@Test
	public void putdata(String url, String pass)
	{
		System.out.println("\"Values form the global suite  !!"+url);
		System.out.println("Values form the global suite  !!"+pass);
	}
	@BeforeTest
	public void prerquired()
	{
		System.out.println("I will execute firstly !!");	
		
	}
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("Firstly i will execute before any text cases suite!!");
		
		System.out.println("Firstly i will execute before any text cases suite!! Sep 9, 2023");
		
	}
	

}
