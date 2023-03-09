package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWait;
import utilities.GeneralUtilities;

public class ManageUsersPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	ExplicitWait ew = new ExplicitWait();

	public ManageUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-user'][normalize-space()='More info']")
	WebElement manageUsersPagesButton;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;

	@FindBy(id = "st")
	WebElement selectStatusDropDown;

	@FindBy(id = "un")
	WebElement nameOption;

	@FindBy(xpath = "//center[contains(text(),'......RESULT NOT FOUND.....')]")
	WebElement alertmessage;

	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchAfterEnterButton;

	public void enterManageUsers() {
		manageUsersPagesButton.click();
	}

	public void selectSearchButton() {
		searchButton.click();
	}

	public String selectStatusValueFromDropDown(int value) {
		return gu.getselectValueFromDropDown(selectStatusDropDown, value);
	}

	public void selectNameOption(String nm) {
		nameOption.sendKeys(nm);
	}

	public void selectSearchAfterEnterButton() {
		 searchAfterEnterButton.click();
	}

	public String alertMessageAfterInvalidNameEnter() {
		return gu.getElementText(alertmessage);
	}

}
