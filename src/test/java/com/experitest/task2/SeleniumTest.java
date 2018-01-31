package com.experitest.task2;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
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
		
		
		dc.setCapability("accessKey", "eyJ4cC51Ijo4NiwieHAucCI6MiwieHAubSI6Ik1BIiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjE4MzI2MDQ3NzksImlzcyI6ImNvbS5leHBlcml0ZXN0In0.jQiiUT4kDAy1p4UKYY-tUSA289P6yqr5Fz1lou9ckrM");
		dc.setCapability("generateReport", true);
		dc.setCapability("testName", "ATB");
		dc.setCapability("newSessionWaitTimeout", 90);		
		dc.setCapability("newCommandTimeout", 120);
		
		driver = new RemoteWebDriver(new URL("https://sales.experitest.com/wd/hub/"), dc);
		
	} 
	
	
	
	@Test
	public void ActualTest() throws InterruptedException{
		driver.get("https://www.atb.com");
        Thread.sleep(3000);
		System.out.println(driver.getTitle());
        driver.findElement(By.xpath("//*[@class='online_signin_btn']")).click();
        driver.findElement(By.xpath("//*[@nodeName='A' and @width>0 and ./*[@text='ATB ONLINE']]")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	} 
	
	
	@AfterTest
	public void TearDown(){
		driver.quit();
		
	} 
	
	

}
