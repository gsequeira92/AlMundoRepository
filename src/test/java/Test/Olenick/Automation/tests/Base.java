package Test.Olenick.Automation.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Base {

	public WebDriver driver;

	public Base(WebDriver driver) {

		this.driver = driver;

	}

	public void wait(WebElement element) {

		new WebDriverWait(this.driver, 2).until(ExpectedConditions.visibilityOf(element));

	}

	public void dropdownByIndex(int index, By locator) {

		Select dropdown = new Select(driver.findElement(locator));
		dropdown.selectByIndex(index);

	}

	public abstract void getUrl(String url);

}
