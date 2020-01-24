package stepDefinitions;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Test.Olenick.AlMundo.AccommodationContext;
import Test.Olenick.AlMundo.AlMundoAccommodationPage;
import Test.Olenick.AlMundo.AlMundoHotelResultsPage;
import Test.Olenick.AlMundo.ContextRepository;
import Test.Olenick.AlMundo.HotelBuilder;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AccommodationStepsDef extends CommonStepDefinitions {
	public AccommodationContext getContext() {
		return (AccommodationContext) ContextRepository.get();
	}

	public WebDriver driver;
	AlMundoAccommodationPage accommodationPage;
	AlMundoHotelResultsPage resultsPage;

	@Given("the user is at AlMundo accommodation search page")
	public void first_flight_search_of_AlMundo_home_page() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.almundo.com.ar/Hoteles");
		this.getContext().setAccommodationPage(new AlMundoAccommodationPage(driver));
		this.getContext().setBuilder(new HotelBuilder());

	}

	@Given("^the origin \"([^\"]+)\" is set to \"([^\"]+)\"$")
	public void the_origin_city_is_set_to(String type, String city) {
		this.getContext().getAccommodationPage();

	}

	@Given("^the month\\/Year for departure is \"([^\"]+)\"$")
	public void the_month_Year_for_departure_is(String month) {

		newHotel.hotelMonthFrom(month);
	}

	@Given("^the date from is \"([^\"]+)\"$")
	public void the_date_from_is(String date) {

		newHotel.dateFrom(date);

	}

	@Given("^the room number is set to  \"(\\d+)\"$")
	public void the_room_number_is(int rooms) {
		newHotel.numberOfRooms(rooms);

	}

	@Given("^the adult number is set to \"(\\d+)\"$")
	public void the_adult_number_is(int adults) {

		newHotel.adultNumber(adults);

	}

	@Given("^the children number is set to \"(\\d+)\"$")
	public void the_children_number_is(int childs) {

		newHotel.childNumber(childs);
	}

	@Given("^the option given for children is \"(\\d+)\"$")
	public void the_option_given_for_children_is(int option) {

		newHotel.childAgeOption(option);

	}

	@When("^the user submit search$")
	public void the_user_submit_search() {

		accommodationPage.searchForAccommodation(newHotel.build());

	}

	@Then("^the flight results page is displayed$")
	public void the_flight_results_page_is_displayed() throws InterruptedException {

		resultsPage = new AlMundoHotelResultsPage(driver);

		assertTrue(resultsPage.isDisplayed());
		this.driver.quit();

	}

}
