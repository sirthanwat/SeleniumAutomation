package listeners;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class EventTestCase {
	WebDriver driver;

	@BeforeMethod
	public void initiatBrowser() {				
		driver = new ChromeDriver(); 
		
		//Step 2	
		EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver); //logging purposes.
		
		//Step 3	
		EventListener listener = new EventListener();
		
		//Step 4	
		eventDriver.register(listener);
		
		eventDriver.navigate().to("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

	@Test
	public void test() {
		driver.findElement(By.id("email")).sendKeys("hello");
	}
}
