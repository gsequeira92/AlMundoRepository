package Test.Olenick.AlMundo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AlMundoAccommodationPage extends Base {

	public AlMundoAccommodationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	// Destination and date elements

	@FindBy(css = "input[formcontrolname='origin']")
	WebElement originInput;

	@FindBy(css = "div#cdk-overlay-3")
	WebElement hotelSubMenu;

	@FindBy(css = "am-icon[icon='arrow-left']")
	WebElement previousMonthButton;

	@FindBy(css = "button.next")
	WebElement nextMonthButton;

	@FindBy(xpath = "//div[@class='nav-title']")
	WebElement calendarTitleLocator;

	@FindBy(css = "input[formcontrolname ='departureDate']")
	WebElement departureDateSelector;

	@FindBy(css = "input[formcontrolname ='arrivalDate']")
	WebElement arrivalDateSelector;

	@FindBy(css = "table[class='calendar-table']")
	WebElement calendarLocator;

	// Room and passenger elements

	@FindBy(css = "input[data-au='guests']")
	WebElement guestInputDropdown;

	@FindBy(css = "am-passengers-dialog-selector[data-au='adults'] div.selector-content am-icon[data-au='plus']")
	WebElement addAdultButton;

	@FindBy(css = "am-passengers-dialog-selector[data-au='children'] div.selector-content am-icon[data-au='plus']")
	WebElement addMinorButton;

	@FindBy(css = "svg#sub")
	WebElement subAdultButton;

	@FindBy(css = "button[data-au='done']")
	WebElement childDoneButton;

	@FindBy(css = "select[data-au='age-child']:nth-of-type(1)")
	WebElement childAgeSelector;

	@FindBy(css = "am-icon[data-au='minus']")
	WebElement subRoomButton;

	@FindBy(css = "am-icon[data-au='plus']")
	WebElement addRoomButton;

	// Submit search btn element

	@FindBy(css = "button.search-box-button")
	WebElement submitSearchButton;

	// Test Method

	public void searchForAccommodation(Hotel hotel) {

		searchHotel(hotel.getHotelLocation(), hotel.getTypeFrom(), hotel.getHotelLocation());
		searchForDate(hotel.getMonthFrom(), hotel.getDateFrom());
		searchForDate(hotel.getMonthTo(), hotel.getDateTo());
		setPassengersAndRooms(hotel.getAdultNumber(), hotel.getChildrenNumber(), hotel.getChildIndex(),
				hotel.getRooms());
		submmitSearch();

	}

	// Search and set methods

	// There're 3 types for search: City,neighborhood and Hotel
	public void searchHotel(String destination, String locationType, String location) {

		originInput.click();
		originInput.sendKeys(destination);
		waitForHotelSuboption();
		selectHotelSubmenuOption(locationType, location);

	}

	public void searchForDate(String month, String date) {

		selectSpecificMonthFrom(month);
		selectSpecificDate(date);

	}

	public void setPassengersAndRooms(int adults, int minors, int option, int rooms) {

		openPassengersDropdown();
		addRooms(rooms);
		addAdultPassengers(adults);
		addMinorPassengers(minors);
		waitForMinorSubmenu();
		selectChildOption(minors, option);

	}

	public void submmitSearch() {

		submitSearchButton.click();

	}

	// Other methods

	public void waitForHotelSuboption() {
		this.wait(hotelSubMenu);
	}

	public void selectHotelSubmenuOption(String type, String location) {

		WebElement newOptionSelector = driver.findElement(
				By.xpath("//div[@data-au='" + type + "']/div[@data-au='entity'][contains(.,'" + location + "')])"));

		newOptionSelector.click();
	}

	public void selectSpecificMonthFrom(String month) {

		while (!calendarTitleLocator.getText().equals(month)) {
			nextMonthButton.click();

		}
	}

	public void selectSpecificMonthTo(String month) {

		while (!calendarTitleLocator.getText().equals(month)) {
			nextMonthButton.click();

		}
	}

	public void selectSpecificDate(String date) {

		driver.findElement(
				By.xpath("//table[@class='calendar-table']//button[@class='calendar-button']/*[.='" + date + "']"))
				.click();

	}

	public void openPassengersDropdown() {

		guestInputDropdown.click();
		this.wait(guestInputDropdown);
	}

	public void addAdultPassengers(int adults) {

		int controlNumber = 0;

		while (controlNumber != adults - 2) {
			addAdultButton.click();
			controlNumber++;
		}

	}

	public void addMinorPassengers(int minors) {
		int controlNumber = 0;

		while (controlNumber != minors) {
			addMinorButton.click();
			controlNumber++;
		}
	}

	public void addRooms(int rooms) {

		int controlNumber = 0;

		while (controlNumber != rooms - 1) {
			addRoomButton.click();
			controlNumber++;
		}

	}

	public void selectChildOption(int childNumber, int option) {

		for (int i = 0; i < childNumber; i++) {

			WebElement newChildDropdown = driver
					.findElement(By.cssSelector("select[data-au='age-child-0]:nth-of-type(" + i + ")"));
			Select dropDown = new Select(newChildDropdown);
			dropDown.selectByIndex(option);
		}

	}

	public void waitForMinorSubmenu() {
		this.wait(childDoneButton);
	}

	@Override
	public void getUrl() {
		// TODO Auto-generated method stub

	}

}
