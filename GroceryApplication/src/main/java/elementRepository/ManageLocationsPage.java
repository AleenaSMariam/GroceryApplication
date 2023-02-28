package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageLocationsPage {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public ManageLocationsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-location']")
	WebElement manageLocationsButton;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;

	@FindBy(id = "country_id")
	WebElement dropdownCountryOption;

	@FindBy(id = "st_id")
	WebElement dropdownStateOption;

	@FindBy(id = "location")
	WebElement enterLocation;

	@FindBy(id = "delivery")
	WebElement enterDeliveryCharge;

	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement saveButton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement newLocationCreated;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[2]//td[1]")
	List<WebElement> locations;

	public void selectManageLocationsPage() {
		manageLocationsButton.click();
	}

	public void enterNewButton() {
		newButton.click();
	}

	public String dropdownValueOfCountry(int value) {
		return gu.getselectValueFromDropDown(dropdownCountryOption, value);
	}

	public String dropdownValueOfStateOption(int value) {
		return gu.getselectValueFromDropDown(dropdownStateOption, value);
	}

	public void enterLocationvalue(String loct) {
		enterLocation.sendKeys(loct);
	}

	public void enterDeliveryChargevalue(String delchrg) {
		enterDeliveryCharge.sendKeys(delchrg);
	}

	public void enterSaveButton() {
		saveButton.click();
	}

	public String newLocationCreatedMessageShown() {
		return gu.getElementText(newLocationCreated);
	}

	public String getLocator() {
		int index = gu.getLocatorValueFromTable(locations, "Kerala");
		String locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + (index + 1)
				+ "]//td[3]";
	   
		return locator;
	}

}
