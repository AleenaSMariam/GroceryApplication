package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageProductPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

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

	public void enterManageProductPage() {
		clickManageProducts.click();
	}

	public void clickNew() {
		newButton.click();
	}

	public String dropdownValueOfType(int value) {
		return gu.getselectValueFromDropDown(weightUnitDropDown, value);
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

}
