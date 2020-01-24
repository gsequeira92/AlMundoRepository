package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Test.Olenick.AlMundo.AlMundoFlightsHomePage;
import Test.Olenick.AlMundo.AlMundoResultsPage;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class CommonStepDefinitions {

	WebDriver driver;
	AlMundoFlightsHomePage alMundoHome;
	AlMundoResultsPage alMundoResults;

	@Given("the user is at AlMundo flight search page")
	public void first_flight_search_of_AlMundo_home_page() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.almundo.com.ar");
		alMundoHome = new AlMundoFlightsHomePage(driver);

	}

}
