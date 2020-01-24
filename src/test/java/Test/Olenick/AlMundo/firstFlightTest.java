package Test.Olenick.AlMundo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

//@RunWith(value = Parameterized.class)

public class firstFlightTest {

	public WebDriver driver;

	/*
	 * @Parameters public static Iterable<Object[]> getData() {
	 * 
	 * return Arrays.asList(new Object[][] { {"1","2","3"} });
	 * 
	 * List<Object[]> obj = new ArrayList<Object[][]>();
	 * 
	 * obj.add(new Object[] { "Aca van los parametros" }); obj.add(new Object[] {
	 * "Aca van los parametros" }); obj.add(new Object[] { "Aca van los parametros"
	 * }); obj.add(new Object[] { "Aca van los parametros" }); obj.add(new Object[]
	 * { "Aca van los parametros" });
	 * 
	 * return obj; }
	 */

	@Before
	public void setUp() throws Exception {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.almundo.com.ar");

	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {

		AlMundoFlightsHomePage alMundoHome;
		AlMundoResultsPage alMundoResults;

		alMundoHome = new AlMundoFlightsHomePage(driver);
		alMundoResults = new AlMundoResultsPage(driver);

		Flight newTest = new FlightBuilder().flightOrigin("Río de Janeiro, Brasil")
				.flightDestination("Buenos Aires, Argentina").flightTypeFrom("city").flightMonthFrom("Junio 2020")
				.flightDateFrom("10").flightTypeTo("city").flightMonthTo("Septiembre 2020").flightDateTo("20")
				.flightAdultNumber(3).flightChildrenNumber(4).flightAgeIndex(2).flightClass("Business").build();

		alMundoHome.waitForHomePage();
		alMundoHome.searchForFlight(newTest);
		Thread.sleep(6000);
		assertTrue(alMundoResults.isDisplayed());
	}

}
