package Test.Olenick.AlMundo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AlMundoFlightsHomePage extends Base {

	public AlMundoFlightsHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);

	}

	@FindBy(css = "div.search-box__formContainer")
	WebElement searchBoxForm;

	@FindBy(css = "input[formcontrolname='origin']")
	WebElement fromDestinationLocator;

	@FindBy(css = "input[formcontrolname='destination']")
	WebElement toDestinationLocator;

	@FindBy(css = "input[unique='Pasajero']")
	WebElement passengerNumberAndClassLocator;

	@FindBy(css = "select[formcontrolname='flightClass']")
	WebElement flightClassLocator;

	@FindBy(css = "button.search-box-button")
	WebElement submmitSearchButton;

	@FindBy(id = "switch")
	WebElement switchDestinationButton;

	@FindBy(css = "am-checkbox[formcontrolname='withoutDestination']")
	WebElement noDefinedDestinyCheckbox;

	@FindBy(css = "am-checkbox[formcontrolname='withoutDate']")
	WebElement noDefinedDatesCheckbox;

	@FindBy(css = "am-passengers-dialog-selector[data-au='adults'] div.selector-content am-icon[data-au='plus']")
	WebElement addAdultButton;

	@FindBy(css = "am-passengers-dialog-selector[data-au='children'] div.selector-content am-icon[data-au='plus']")
	WebElement addMinorButton;

	@FindBy(css = "svg#sub")
	WebElement subAdultButton;

	@FindBy(css = "button[data-au='done']")
	WebElement childDoneButton;

	@FindBy(xpath = "//div[@class='options-container']")
	WebElement subMenuCitySelector;

	@FindBy(css = "div.cdk-overlay-pane")
	WebElement cityAndAirportDropdown;

	@FindBy(css = "select[data-au='age-child']:nth-of-type(1)")
	WebElement childAgeSelector;

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

	// Test Method
	public void searchForFlight(Flight flight) {
//		String from, String to, String locationTypeFrom, String locationTypeTo,
// 		String locationFrom, String locationTo, int adultNumber, int minorNumber, int childIndex,
//		String flightClass, String monthFrom, String monthTo, String dateFrom, String dateTo) {

		searchOrigin(flight.getOrigin(), flight.getTypeFrom(), flight.getOrigin());
		searchDestination(flight.getDestination(), flight.getTypeTo(), flight.getDestination());
		departureDateSelector.click();
		searchForDate(flight.getMonthFrom(), flight.getDateFrom());
		searchForDate(flight.getMonthTo(), flight.getDateTo());
		setPassengers(flight.getAdultNumber(), flight.getChildrenNumber(), flight.getChildIndex());
		selectFlightClass(flight.getFlightClass());
		submitSearch();

	}

	public void setPassengers(int adultNumber, int minorNumber, int childIndex) {

		openPassengersDropdown();
		addAdultPassengers(adultNumber);
		addMinorPassengers(minorNumber);
		waitForChildSubMenu();
		fillChildPassengersAge(childIndex, minorNumber);
	}

	public void searchForDate(String month, String date) {

		this.selectSpecificMonthFrom(month);
		this.selectDateFromCalendar(date);
	}

	public void selectDateFromCalendar(String date) {

		driver.findElement(
				By.xpath("//table[@class='calendar-table']//button[@class='calendar-button']/*[.='" + date + "']"))
				.click();

		// List<WebElement> dates = datesOnCalendar.findElements(By.tagName("td"));
		// datesOnCalendar.findElement(By.xpath("//button[@class='calendar-button']/*[.='"
		// + date + "']")).click();
		// cell.findElement(By.cssSelector("button.calendar-button")).click();

	}

	public void selectSpecificMonthFrom(String month) {

		while (!calendarTitleLocator.getText().equals(month)) {
			nextMonthButton.click();
		}

	}

	public void selectSpecificMonthTo(String month) {

		arrivalDateSelector.click();

		while (!calendarTitleLocator.getText().equals(month)) {
			nextMonthButton.click();
		}

	}

	public void waitForCalendar() {

		this.wait(calendarTitleLocator);

	}

	// Return element ()
	public void selectAutocompleteOption(String locationType, String location) {

		WebElement newCitySelector = driver.findElement(By.xpath(
				"//div[@data-au='" + locationType + "']/div[@data-au='entity'][contains(.,'" + location + "')]"));

		newCitySelector.click();

	}

	public int addMinorPassengers(int minorNumber) {

		int minorControlNumber = 0;
		int minorPassengers = 0;

		while (minorControlNumber < minorNumber) {
			addMinorButton.click();
			minorPassengers += 1;
			minorControlNumber++;

		}

		return minorPassengers;

	}

	public void fillChildPassengersAge(int index, int minorNumber) {

		for (int i = 1; i <= minorNumber; i++) {

			WebElement newChildDropDown = driver
					.findElement(By.cssSelector("select[data-au='age-child']:nth-of-type(" + i + ")"));
			Select dropdown = new Select(newChildDropDown);
			newChildDropDown.click();
			dropdown.selectByIndex(index);
		}

		childDoneButton.click();
	}

	public void openPassengersDropdown() {

		passengerNumberAndClassLocator.click();
		waitForPassengerAndClassDropdown();
	}

	public void waitForPassengerAndClassDropdown() {
		this.wait(addAdultButton);
	}

	public void waitForChildSubMenu() {
		this.wait(childDoneButton);
	}

	public void submitSearch() {

		submmitSearchButton.click();
	}

	public void waitForSubOption() {

		this.wait(subMenuCitySelector);
	}

	public void waitForHomePage() {

		this.wait(submmitSearchButton);
	}

	public void searchOrigin(String from, String locationType, String option) {

		fromDestinationLocator.click();
		fromDestinationLocator.sendKeys(from);
		waitForSubOption();
		selectAutocompleteOption(locationType, option);

	}

	public void searchDestination(String to, String locationType, String option) {

		toDestinationLocator.click();
		toDestinationLocator.sendKeys(to);
		waitForSubOption();
		selectAutocompleteOption(locationType, option);

	}

	public void searchDates(String date) {

	}

	public void addAdultPassengers(int adultNumber) {

		int controlNumber = 0;

		while (controlNumber < adultNumber - 1)

		{
			addAdultButton.click();
			controlNumber++;
		}
	}

	public void subAdultPassengers(int subAdultNumber) {

		int controlNumber = 0;

		while (subAdultNumber != controlNumber) {
			subAdultButton.click();
			subAdultNumber--;
		}

	}

	public void subMinorPassengers() {

		passengerNumberAndClassLocator.click();

	}

	public void selectFlightClass(String flightClass) {

		flightClassLocator.click();
		Select dropdown = new Select(flightClassLocator);
		dropdown.selectByVisibleText(flightClass);

	}

	public void noDefinedDates() {

		noDefinedDatesCheckbox.click();
	}

	@Override
	public void getUrl() {

		String url = "https://almundo.com.ar/vuelos";

		driver.get(url);

	}

}
