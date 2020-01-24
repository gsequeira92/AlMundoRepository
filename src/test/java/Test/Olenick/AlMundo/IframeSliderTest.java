package Test.Olenick.AlMundo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class IframeSliderTest {

	WebDriver driver;

	@Before
	public void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver", "./src/resources/chromedriver/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.jqueryui.com/slider/");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();

	}

	@Test
	public void test() throws InterruptedException {

		//Thread.sleep(4000);

		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(iframe);
		WebElement slider = driver.findElement(By.cssSelector("span.ui-slider-handle.ui-corner-all.ui-state-default"));

		Actions slide = new Actions(driver);

		slide.clickAndHold(slider);
		slide.moveByOffset(400, 150);
		slide.build().perform();

		// assertTrue(false);
	}

}
