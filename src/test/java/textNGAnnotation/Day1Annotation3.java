package textNGAnnotation;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day1Annotation3 {
	
	@Test(dependsOnMethods= {"setdata"})// If one method depends on another, we can use the dependsOnMethod option under the annotation and add the method name.
	public void getdata()
	{
		System.out.println("Data is GET");		
	}
	
	@Test(groups = {"Smoke"}) // If customer wants execute few test cases under the project so we can user group option under the annotation and validate few test cases.
	public void setdata()
	{
		System.out.println("Data is SET");		
	}
	@Parameters({"variableName1", "variableName4"}) // It's Parameter declare in test cases level under the textng.xml suite.
	@Test
	public void mapData(String url, String pass)
	{
		System.out.println("Paramter values from the test level :"+url);
		System.out.println("Paramter values from the test level :"+pass);
	}
	@AfterSuite
	public void aeforeSuite()
	{
		System.out.println("I will execute after after all test cases has been done under the suite !!");
		
	}
	
	
}
