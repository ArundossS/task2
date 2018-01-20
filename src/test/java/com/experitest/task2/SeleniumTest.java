package com.experitest.task2;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

/**
 * Unit test for simple App.
 */
public class SeleniumTest 
{
    protected WebDriver driver;
    
    public static String getTestNGparameters (ITestContext context, String Key){
    	return context.getCurrentXmlTest().getParameter(Key);
    }
    

	@BeforeTest
	public void SetUp(ITestContext context) throws MalformedURLException{
		
		DesiredCapabilities dc = new DesiredCapabilities();
		
		String Platform = getTestNGparameters(context, "Platform");
		
		if (Platform.equalsIgnoreCase("chrome")){
			dc = DesiredCapabilities.chrome();
			dc.setCapability("platformName", "chrome");
		}
		else if (Platform.equalsIgnoreCase("firefox")){
			dc = DesiredCapabilities.firefox();
			dc.setCapability("platformName", "firefox");
		}
		else if (Platform.equalsIgnoreCase("ie")){
			dc = DesiredCapabilities.internetExplorer();
			dc.setCapability("platformName", "ie");
		}
		else if (Platform.equalsIgnoreCase("android")){
			dc = DesiredCapabilities.chrome();
			dc.setCapability("platformName", "android");
		}
		else if (Platform.equalsIgnoreCase("ios")){
			dc = DesiredCapabilities.iphone();
			dc.setCapability("platformName", "ios");
		}
		
		
		dc.setCapability("accessKey", "eyJ4cC51IjoxMDcsInhwLnAiOjIsInhwLm0iOiJNVFV4TlRNMU16RTNOelUwTVEiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE4MzE1NjcwNDgsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.Lc09vFOq15vCaxzu5fr140-GuC0mBT3BnpSlpGZxYBk");
		dc.setCapability("generateReport", true);
		dc.setCapability("testName", "Task2_selenium");
		dc.setCapability("newSessionWaitTimeout", 90);		
		dc.setCapability("newCommandTimeout", 120);
		
		driver = new RemoteWebDriver(new URL("https://sales.experitest.com/wd/hub/"), dc);
		
	} 
	
	
	
	@Test
	public void ActualTest(){
		driver.get("https://www.facebook.com");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(driver.getTitle());
		
	} 
	
	
	@AfterTest
	public void TearDown(){
		
	} 
	
	

}
