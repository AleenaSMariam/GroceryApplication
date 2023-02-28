package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {

	public String getElementText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public String getURLofPage(WebDriver driver) {
		String text = driver.getCurrentUrl();
		return text;
	}

	public String getselectValueFromDropDown(WebElement element, int i) {
		Select obj = new Select(element);
		obj.selectByIndex(i);
		WebElement selectedValue = obj.getFirstSelectedOption();
		String text = selectedValue.getText();
		return text;
	}

	public boolean isCheckboxSelected(WebElement element) {
		boolean bl = element.isSelected();
		return bl;
	}

	public String getToolTipValue(WebElement element, String value) {
		String text = element.getAttribute(value);
		return text;
	}

	public void uploadFiles(WebDriver driver, WebElement element, String filePath) throws AWTException {
		Robot file = new Robot();
		Actions mouse = new Actions(driver);
		mouse.moveToElement(element).click().perform();
		StringSelection ss = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		file.keyPress(KeyEvent.VK_CONTROL);
		file.keyPress(KeyEvent.VK_V);
		file.delay(250);
		file.keyRelease(KeyEvent.VK_CONTROL);
		file.keyRelease(KeyEvent.VK_V);
		file.delay(250);
		file.keyPress(KeyEvent.VK_ENTER);
		file.keyRelease(KeyEvent.VK_ENTER);

	}

	public Boolean isradioButtonSelected(WebElement element) {
		boolean bl = element.isSelected();
		return bl;
	}

	public String getColor(WebElement element, String value) {
		String text = element.getCssValue(value);
		return text;

	}

	public int getLocatorValueFromTable(List<WebElement> element, String value) {
		int index = 0;
		for (int i = 0; i < element.size(); i++) {
			if (element.get(i).getText().equals(value)) {
				index = i;
				break;
			}
		}
		return index;
	}

	public String alertMessage(WebDriver driver) {
		String alert = driver.switchTo().alert().getText();
		return alert;

	}

}