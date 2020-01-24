package Test.Olenick.Automation.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAmazonSearch {

	public WebDriver driver;
	
	@Before
	public void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver", "./src/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.es/ref=nav_logo");
		driver.manage().window().maximize();

	}

	@Test
	public void test() throws InterruptedException {

		AmazonHomePage homePage;
		AmazonProductListPage productListPage;
		AmazonProductDetailPage productDetailPage;
		AmazonSignInPage signInPage;
		
		
		homePage = new AmazonHomePage(driver);
		productListPage = new AmazonProductListPage(driver);
		productDetailPage = new AmazonProductDetailPage(driver);
		

		
		homePage.searchByDepartament("Informática");
		homePage.textSearchProduct("mouse");
		productListPage.filterByPrime();
		productListPage.filterByBrand();
		productListPage.selectProduct();
		productDetailPage.selectQty("3");
		signInPage = productDetailPage.buyProductNow();
		signInPage.waitForPage();
		assertTrue(signInPage.signInPageDisplayed());

	}

	@After
	public void tearDown() throws Exception {
		driver.quit();

	}

}