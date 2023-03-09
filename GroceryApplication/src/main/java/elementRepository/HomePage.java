package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class HomePage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement adminButton;

	@FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Logout']")
	WebElement logoutButton;

	@FindBy(xpath = "//p[contains(text(),'Sign in to start your session')]")
	WebElement signInPageText;

	@FindBy(xpath = "//i[@class='nav-icon fas fa-money-bill-alt']")
	WebElement manageExpenseDropDownButton;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/expense-category']")
	WebElement expenseCategoryOption;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;

	public void clickAdminButton() {
		adminButton.click();
	}

	public void clickLogoutButton() {
		logoutButton.click();
	}

	public String signInPageTextAfterLogOut() {
		return gu.getElementText(signInPageText);
	}

	public void clickManageExpenseDropDown() {
		manageExpenseDropDownButton.click();
	}

	public void clickExpenseCategory() {
		expenseCategoryOption.click();
	}

	public String bordercolourOfNewButton(String value) {
		return gu.getColor(newButton, value);
	}

}
