package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWait;
import utilities.GeneralUtilities;

public class ManageProductPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	ExplicitWait ew= new ExplicitWait();

	public ManageProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product']")
	WebElement clickManageProducts;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;

	@FindBy(id = "w_unit")
	WebElement weightUnitDropDown;

	@FindBy(xpath = "//input[@value='Nonveg']")
	WebElement productTypeRadioButton;

	@FindBy(xpath = "//input[@value='litre']")
	WebElement priceTypeRadioButton;

	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement unlimitedStockCheckBox;

	@FindBy(id = "grp_id")
	WebElement groupDropDown;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;

	@FindBy(xpath = "//input[@name='cd']")
	WebElement productCode;

	@FindBy(xpath = "//center[contains(.,'......RESULT NOT FOUND.....')]")
	WebElement alertmessage;

	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	WebElement searchCode;

	public void enterManageProductPage() {
		clickManageProducts.click();
	}

	public void clickNew() {
		newButton.click();
	}

	public String dropdownValueOfType(int value) {
		return gu.getselectValueFromDropDown(weightUnitDropDown, value);
	}

	public String dropdownvalueofGroup(int index) {
		return gu.getselectValueFromDropDown(groupDropDown, index);
	}

	public void clickProductTypeRadioButton() {
		productTypeRadioButton.click();
	}

	public boolean productTypeRadioButtonValue() {
		return gu.isradioButtonSelected(productTypeRadioButton);
	}

	public void clickPriceTypeRadioButton() {
		priceTypeRadioButton.click();
	}

	public boolean priceTypeRadioButtonValue() {
		return gu.isradioButtonSelected(priceTypeRadioButton);
	}

	public boolean ifunlimitedStockCheckBoxIsSelected() {
		return gu.isCheckboxSelected(unlimitedStockCheckBox);
	}

	public void clickSearchButton() {
		ew.waitForElementToBeClickable(driver, searchButton);
	}

	public void enterProductCode(String code) {
		productCode.sendKeys(code);
	}

	public void clickSearchCodeButton() {
		searchButton.click(); 
	}

	public String alertMessageAfterInvalidProductCodeIsEntered() {
		return gu.getElementText(alertmessage);
	}

}
