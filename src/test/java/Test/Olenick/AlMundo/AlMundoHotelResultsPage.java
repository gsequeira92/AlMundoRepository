package Test.Olenick.AlMundo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlMundoHotelResultsPage extends Base {

	public AlMundoHotelResultsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(css = "div.hotels-results")
	WebElement hotelResultsLocator;

	public boolean isDisplayed() {

		boolean result = false;

		if (hotelResultsLocator.isDisplayed()) {
			result = true;
		}

		return result;
	}

	@Override
	public void getUrl() {
		// TODO Auto-generated method stub

	}

}
