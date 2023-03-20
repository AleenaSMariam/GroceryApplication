package TestCases;

import org.testng.annotations.Test;

import Constant.Constant;
import utilities.ScreenShotUtility;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseClass {
	public static Properties prop;
	ScreenShotUtility ss;

	public void testBasic() throws IOException {
		prop = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+(Constant.CONFIG_PATH));
		prop.load(ip);
	}

	WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void beforeMethod(String browser) throws IOException {  
		testBasic();
		if (browser.equals(Constant.CHROME_BROWSER)) {
			ChromeOptions option = new ChromeOptions();
            option.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(option);
		} 
		else if (browser.equals(Constant.FIREFOX_BROWSER)) {
		driver = new FirefoxDriver();
		}
		driver.get(prop.getProperty("BaseURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult itestResult) throws IOException {
		if (itestResult.getStatus() == ITestResult.FAILURE) {
			ss = new ScreenShotUtility();
			ss.captureFailureScreenShot(driver, itestResult.getName());
		}

		driver.quit();
	}
}
