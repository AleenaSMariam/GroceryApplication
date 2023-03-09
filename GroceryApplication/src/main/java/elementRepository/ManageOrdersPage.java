package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageOrdersPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public ManageOrdersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-order']")
	WebElement manageOrdersPageButton;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;

	@FindBy(id = "pt")
	WebElement paymentModeDropDown;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[1]")
	List<WebElement> listOrders;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	WebElement resetButton;

	public void selectManageOrdersPage() {
		manageOrdersPageButton.click();
	}

	public String getLocatorToFindValueOfAmount() {
		int index = gu.getLocatorValueFromTable(listOrders, "679");
		String locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + (index + 1)
				+ "]//td[4]";
		WebElement location = driver.findElement(By.xpath(locator));
		return gu.getElementText(location);

	}

	public String colourOfResetButton(String value) {
		return gu.getColor(resetButton, value);
	}

	public void clickSearchOption() {
		searchButton.click();
	}

	public String paymentModeDropDownValue(int value) {
		return gu.getselectValueFromDropDown(paymentModeDropDown, value);
	}

}
