package page;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public int generateRandomNum(int bounderyNum) {
		Random rnd = new Random();
		int RanNum = rnd.nextInt(bounderyNum);
		return RanNum;
	}
	
	public void selectFromDropDown(WebElement webElement, String visibleText) {
		Select sel = new Select(webElement);
		sel.selectByVisibleText(visibleText);
	}
	
	public void waitForElement(WebDriver driver, int timeInSeconds, WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}


}