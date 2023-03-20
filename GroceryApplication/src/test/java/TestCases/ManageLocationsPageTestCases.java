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
		lp.enterUsername(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 0));
		lp.enterPassword(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 1));
		lp.clickSignIn();
		mlp.selectManageLocationsPage();
		mlp.enterNewButton();
		String actualresult = mlp.dropdownValueOfCountry(Constant.COUNTRY_VALUE);
		String expectedresult = Constant.COUNTRY_NAME;
		Assert.assertEquals(actualresult, expectedresult, Constant.ASSERTIONMESSAGE);
	}

	@Test
	public void verifyTheDropDownValueOfStaeFromNewOption() throws IOException {
		lp = new LoginPage(driver);
		mlp = new ManageLocationsPage(driver);
		lp.enterUsername(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 0));
		lp.enterPassword(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 1));
		lp.clickSignIn();
		mlp.selectManageLocationsPage();
		mlp.enterNewButton();
		String actualresult = mlp.dropdownValueOfStateOption(Constant.STATE_VALUE);
		String expectedresult = Constant.STATE_NAME;
		Assert.assertEquals(actualresult, expectedresult, Constant.ASSERTIONMESSAGE);
	}

	@Test
	public void verifyIftMessageIsShownWhenNewLocationIsCreated() throws IOException {
		lp = new LoginPage(driver);
		mlp = new ManageLocationsPage(driver);
		lp.enterUsername(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 0));
		lp.enterPassword(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 1));
		lp.clickSignIn();
		mlp.selectManageLocationsPage();
		mlp.enterNewButton();
		mlp.dropdownValueOfCountry(Constant.COUNTRY_VALUE);
		mlp.dropdownValueOfStateOption(Constant.STATE_VALUE);
		mlp.enterLocationvalue(Constant.SAMPLE_LOCATION);
		mlp.enterDeliveryChargevalue(Constant.SAMPLE_DELIVERYCHARGE);
		mlp.enterSaveButton();
		String actualresult = mlp.newLocationCreatedMessageShown();
		String expectedresult =Constant.ALERT_MESSAGE_FOR_CREATING_LOCATION;
		Assert.assertEquals(actualresult, expectedresult, Constant.ASSERTIONMESSAGE);
	}

	@Test
	public void verifyTheStateOfTheUserAccordingToTheLocation() throws IOException {
		lp = new LoginPage(driver);
		mlp = new ManageLocationsPage(driver);
		lp.enterUsername(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 0));
		lp.enterPassword(ExcelRead.readStringData(prop.getProperty("LoginExcel"), prop.getProperty("LoginExcelSheet"), 1, 1));
		lp.clickSignIn();
		mlp.selectManageLocationsPage();
		String actualresult = mlp.getLocatorToFindValueOfLocation();
		String expectedresult =Constant.VALUE_OF_LOCATION;
		Assert.assertEquals(actualresult, expectedresult, Constant.ASSERTIONMESSAGE);

	}

}
