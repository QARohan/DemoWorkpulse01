package textNGAnnotation;

import org.testng.annotations.Test;

public class Day1Annotation {
	
	@Test(groups = {"Smoke"})
	public void getdata()
	{
		System.out.println("Data is GET");		
	}
	
	@Test(enabled = false)//Everyone knows that fail test case so we can skip the method using enabled of false.
	public void setdata()
	{
		System.out.println("Data is SET");		
	}
	
	
}
