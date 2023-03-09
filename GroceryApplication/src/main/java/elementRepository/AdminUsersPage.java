package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.RandomUtility;

public class AdminUsersPage {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	RandomUtility rg= new RandomUtility();

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")
	WebElement adminUsersButton;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement usernameSearch;

	@FindBy(name = "Search")
	WebElement usernameSearchButton;

	@FindBy(id = "un")
	WebElement enterUsername;

	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-danger']")
	WebElement usernameSearchClick;

	@FindBy(xpath = "//center[text()='.........RESULT NOT FOUND.......']")
	WebElement alertmessage;

	@FindBy(id = "ut")
	WebElement userTypeDropdown;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;

	@FindBy(id = "username")
	WebElement adminUsername;

	@FindBy(id = "password")
	WebElement adminPassword;

	@FindBy(id = "user_type")
	WebElement userType;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement newUserCreated;

	@FindBy(xpath = "//button[@name='Create']")
	WebElement createButton;

	public void selectAdminUsers() {
		adminUsersButton.click();
	}

	public void clickSearchButton() {
		searchButton.click();
	}

	public void adminUserName(String name) {
		enterUsername.sendKeys(name);
	}

	public void clickSearchUsername() {
		usernameSearchClick.click();
	}

	public String verifyAlertMessage() {
		return gu.getElementText(alertmessage);
	}

	public String dropdownValueOfType(int value) {
		return gu.getselectValueFromDropDown(userTypeDropdown, value);
	}

	public void clickNew() {
		newButton.click();
	}

	public void enterNewUsername(String newName) {
		String randomString=rg.randomPassword();
		adminUsername.sendKeys(newName+randomString);
	}

	public void enterNewPassword(String newPswd) {
		adminPassword.sendKeys(newPswd);
	}

	public void selectNewType(int value) {
		gu.getselectValueFromDropDown(userType, value);
	}

	public void clickCreateButton() {
		createButton.click();
	}

	public String newUserCreatedMessageShown() {
		return gu.getElementText(newUserCreated);
	}
}
