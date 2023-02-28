package TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Constant.Constant;

import elementRepository.LoginPage;
import elementRepository.ManageLocationsPage;
import utilities.ExcelRead;

public class ManageLocationsPageTestCases extends BaseClass {
	LoginPage lp;
	ManageLocationsPage mlp;

	@Test
	public void verifyTheDropDownValueOfCountryFromNewOption() throws IOException {
		lp = new LoginPage(driver);
		mlp = new ManageLocationsPage(driver);
		lp.enterUsername("admin");
		lp.enterPassword("admin");
		;
		lp.clickSignIn();
		mlp.selectManageLocationsPage();
		mlp.enterNewButton();
		String actualresult = mlp.dropdownValueOfCountry(1);
		String expectedresult = "United Kingdom";
		Assert.assertEquals(actualresult, expectedresult, Constant.COMMONERRORMESSAGEMESSAGE);
	}

	@Test
	public void verifyTheDropDownValueOfStaeFromNewOption() {
		lp = new LoginPage(driver);
		mlp = new ManageLocationsPage(driver);
		lp.enterUsername("admin");
		lp.enterPassword("admin");
		lp.clickSignIn();
		mlp.selectManageLocationsPage();
		mlp.enterNewButton();
		String actualresult = mlp.dropdownValueOfStateOption(8);
		String expectedresult = "Birmingham";
		Assert.assertEquals(actualresult, expectedresult, Constant.COMMONERRORMESSAGEMESSAGE);
	}

	@Test
	public void verifyIftMessageIsShownWhenNewLocationIsCreated() {
		lp = new LoginPage(driver);
		mlp = new ManageLocationsPage(driver);
		lp.enterUsername("admin");
		lp.enterPassword("admin");
		lp.clickSignIn();
		mlp.selectManageLocationsPage();
		mlp.enterNewButton();
		mlp.dropdownValueOfCountry(1);
		mlp.dropdownValueOfStateOption(8);
		mlp.enterLocationvalue("Kerala");
		mlp.enterDeliveryChargevalue("100");
		mlp.enterSaveButton();
		String actualresult = mlp.newLocationCreatedMessageShown();
		String expectedresult = "×\n" + "Alert!\n" + "Location Created Successfully";
		Assert.assertEquals(actualresult, expectedresult, Constant.COMMONERRORMESSAGEMESSAGE);
	}

	@Test
	public void verifyTheStateOfTheUserAccordingToTheLocation() {
		lp = new LoginPage(driver);
		mlp = new ManageLocationsPage(driver);
		lp.enterUsername("admin");
		lp.enterPassword("admin");
		lp.clickSignIn();
		mlp.selectManageLocationsPage();
		String locator = mlp.getLocator();
		WebElement state = driver.findElement(By.xpath(locator));
		String actualresult = state.getText();//change it
		String expectedresult = "Cambridge";
		Assert.assertEquals(actualresult, expectedresult, Constant.COMMONERRORMESSAGEMESSAGE);

	}

}
