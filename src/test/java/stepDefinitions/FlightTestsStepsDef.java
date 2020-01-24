package stepDefinitions;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Test.Olenick.AlMundo.AlMundoFlightsHomePage;
import Test.Olenick.AlMundo.AlMundoResultsPage;
import Test.Olenick.AlMundo.FlightBuilder;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FlightTestsStepsDef {

	public WebDriver driver;
	AlMundoFlightsHomePage alMundoHome;
	AlMundoResultsPage alMundoResults;
	FlightBuilder createdFlight = new FlightBuilder();

	@Given("^the origin \"([^\"]+)\" is set to \"([^\"]+)\"$")
	public void the_origin_city_is_set_to(String type, String city) {

		createdFlight.flightTypeFrom(type).flightOrigin(city);

	}

	@Given("^the destination \"([^\"]+)\" is set to \"([^\"]+)\"$")
	public void the_destination_city_is_set_to(String type, String city) {

		createdFlight.flightTypeTo(type).flightDestination(city);

	}

	@Given("^the month\\/Year for departure is \"([^\"]+)\"$")
	public void the_month_Year_for_departure_is(String month) {

		createdFlight.flightMonthFrom(month);

	}

	@Given("^the date from is \"([^\"]+)\"$")
	public void the_date_from_is(String date) {

		createdFlight.flightDateFrom(date);

	}

	@Given("^the month\\/Year for arrival is \"([^\"]+)\"$")
	public void the_month_Year_for_arrival_is(String month) {

		createdFlight.flightMonthTo(month);

	}

	@Given("^the date is set to \"([^\"]+)\"$")
	public void the_date_to_is(String date) {

		createdFlight.flightDateTo(date);

	}

	@Given("^the adult number is set to \"(\\d+)\"$")
	public void the_adult_number_is(int adults) {

		createdFlight.flightAdultNumber(adults);

	}

	@Given("^the children number is set to \"(\\d+)\"$")
	public void the_children_number_is(int childs) {

		createdFlight.flightChildrenNumber(childs);

	}

	@Given("^the option given for children is \"(\\d+)\"$")
	public void the_option_given_for_children_is(int option) {
		createdFlight.flightAgeIndex(option);

	}

	@Given("^the flight class is set to \"([^\"]+)\"$")
	public void the_flight_class_is_set_to(String flightClass) {

		createdFlight.flightClass(flightClass);

	}

	@When("^the user submit search$")
	public void the_user_submit_search() {
		alMundoHome.searchForFlight(createdFlight.build());

	}

	@Then("^the flight results page is displayed$")
	public void the_flight_results_page_is_displayed() throws InterruptedException {

		alMundoResults = new AlMundoResultsPage(driver);
		alMundoResults.wait(alMundoResults.flightOptionsMatrix);
		assertTrue(alMundoResults.isDisplayed());
		this.driver.quit();

	}

}
