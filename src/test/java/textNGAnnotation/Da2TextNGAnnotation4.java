package textNGAnnotation;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Da2TextNGAnnotation4 {
	
	@Test
	public void Valueputdata()
	{
		System.out.println("Data is appearin from the method of Valueputdata under the class Da2TextNGAnnotation4  ");		
	}
	
	@Test
	public void putdata1()
	{
		System.out.println("Data is appearin from the method of putdata1 under the class Da2TextNGAnnotation4");		
	}
	
	@Test(dataProvider="getData") // add method name which data you want to run multiple time.
	public void putmobile1(String name, String pass)
	{
		System.out.println("Data is appearin from the method of putmobile1 under the class Da2TextNGAnnotation4");	
		System.out.println(name);
		System.out.println(pass);
	}


	@Test(groups = {"Smoke"})
	public void putmobile2()
	{
		System.out.println("Data is appearin from the method of putmobile2 under the class Da2TextNGAnnotation4 ");		
	}
	@AfterTest
	public void lastExecution()
	{
		System.out.println("I will execute last !! ");	
	}
	
	@DataProvider
	// Declare  data provider method under the class level and we can also declare DataProvider on the Testng.xml site
	// We need the explore data provider on google site.
	public Object[][] getData()
	{
		
		Object [] [] data= new Object[3][2]; // this are the combination of rows and columns
		data[0][0] = "firstUserName";
		data[0][1] = "firstPassword";
		// Columns in the row are nothing but the values for that  particular combination (row).
		
		data[1][0] = "secondUserName";
		data[1][1]  = "secondPassword";
		
		data[2][0]= "thirdUserName";
		data[2][1]= "thirdPassword";
		
		return data;
		
	}
	
	
	
	
}
