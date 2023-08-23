package textNGAnnotation;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

//ITestListener is an interface which implements testng listeners
public class Listeners implements ITestListener  {
	
	
	@Override		
    public void onFinish(ITestContext result) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onStart(ITestContext result) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestFailure(ITestResult result) {	 // ITestResult it is class and we can use multiple method there,				
        // TODO Auto-generated method stub				
        		
    	System.out.println("test case has been Failure !!" +result.getClass().getPackageName());
    	System.out.println("test case has been Failure !!" +result.getTestClass());
    	System.out.println("test case has been Failure !!" +result.getMethod());
    }		

    @Override		
    public void onTestSkipped(ITestResult result) {					
        // TODO Auto-generated method stub	
    	
    	System.out.println("test case has been Skipped !!");
        		
    }		

    @Override		
    public void onTestStart(ITestResult result) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestSuccess(ITestResult arg0) {					
        // TODO Auto-generated method stub	
    	
    	System.out.println("test case has been passed !!");
        		
    }		
	

}
