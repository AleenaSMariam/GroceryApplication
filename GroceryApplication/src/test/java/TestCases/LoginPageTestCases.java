package TestCases;

import org.testng.annotations.Test;

import Constant.Constant;
import elementRepository.LoginPage;
import utilities.ExcelRead;
import utilities.GeneralUtilities;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginPageTestCases extends BaseClass {

	LoginPage lp;

	@Test
	public void verifyTextOfTheSignInButton() {
		lp = new LoginPage(driver);
		String actualresult = lp.verifySignIn();
		String expectedresult = "Sign In";
		Assert.assertEquals(actualresult, expectedresult, Constant.COMMONERRORMESSAGEMESSAGE);
	}

	@Test
	public void verifyIfRememberMeCheckboxIsSelected() {
		lp = new LoginPage(driver);
		Boolean actualresult = lp.checkRememberMe();
		Boolean expectedresult = false;
		Assert.assertEquals(actualresult, expectedresult, Constant.COMMONERRORMESSAGEMESSAGE);
	}

	@Test(dataProvider="dataProvider",dataProviderClass=DataProviderLoginPageTest.class)

	public void verifySignInWithInvalidCredentials(String user, String paswd) {
		lp = new LoginPage(driver);
		lp.enterUsername(user);
		lp.enterPassword(paswd);
		lp.clickSignIn();
		String actualresult = lp.alertMessageForInvalidUsernamAndPassword();
		String expectedresult = "×\n" + "Alert!\n" + "Invalid Username/Password";
		Assert.assertEquals(actualresult, expectedresult, Constant.COMMONERRORMESSAGEMESSAGE);
	}

	@Test
	public void verifyBackgroundColourOfSignInButton() {
		lp = new LoginPage(driver);
		String color = lp.backgroundColourOfSignInButton("background-color");
		String actualresult = Color.fromString(color).asHex();
		String expectedresult = "#343a40";
		Assert.assertEquals(actualresult, expectedresult, Constant.COMMONERRORMESSAGEMESSAGE);
	}

	@Test
	public void verifyValidCredentoials() throws IOException {
		lp = new LoginPage(driver);
		lp.enterUsername(ExcelRead.readStringData("Sheet1", 1, 0));
		lp.enterPassword(ExcelRead.readStringData("Sheet1", 1, 1));
		lp.clickSignIn();
		String actualresult = lp.adminOptionInHomePage();
		String expectedresult = "Admin";
		Assert.assertEquals(actualresult, expectedresult, Constant.COMMONERRORMESSAGEMESSAGE);

	}

}
