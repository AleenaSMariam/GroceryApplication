package TestCases;

import org.testng.annotations.Test;
import utilities.ScreenShotUtility;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseClass {
	public static Properties prop;
	ScreenShotUtility ss;

	public void testBasic() throws IOException {
		prop = new Properties();
		FileInputStream ip = new FileInputStream(
				"/Users/jeswingeorge/eclipse-workspace/GroceryApplication/src/main/resources/Config.properties");
		prop.load(ip);
	}

	WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void beforeMethod(String browser) {            
		if (browser.equals("Chrome")) {
		driver = new ChromeDriver();
		} 
		else if (browser.equals("Firefox")) {
		driver = new FirefoxDriver();
		}
        //driver=new ChromeDriver();
		driver.get("https://groceryapp.uniqassosiates.com/admin/login"); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	}

	@AfterMethod (alwaysRun = true)
	public void afterMethod(ITestResult itestResult) throws IOException {
		if (itestResult.getStatus() == ITestResult.FAILURE) {
			ss = new ScreenShotUtility();
			ss.captureFailureScreenShot(driver, itestResult.getName());
		}

		driver.quit();
	}
}
