package elementRepository;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GeneralUtilities;

public class ManagePagesPage {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public ManagePagesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-page'][normalize-space()='More info']")
	WebElement managePagesButton;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;

	@FindBy(xpath = "//button[@aria-label='Style']")
	WebElement styleToolTipInDescription;

	@FindBy(xpath = "//button[@aria-label='Video']")
	WebElement videoToolTipInDescription;

	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[1]")
	List<WebElement> listPages;
	
	
	
	public void enterManagePages() {
		managePagesButton.click();
	}

	public void clickNewButton() {
		newButton.click();
	}

	public String toolTipValueOfStyleInDescription(String attvalue) {
		return gu.getToolTipValue(styleToolTipInDescription, attvalue);
	}

	public String toolTipValueOfVideoInDescription(String value) {
		return gu.getToolTipValue(videoToolTipInDescription, value);
	}
	
	public String getLocatorToFindValueOfPage() {
		int index = gu.getLocatorValueFromTable(listPages,"citrus");
		String locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + (index + 1)+ "]//td[4]";
		WebElement location = driver.findElement(By.xpath(locator));
		return gu.getElementText(location);

	}

}
