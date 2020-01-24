package Test.Olenick.AlMundo;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class OtherSliderTest {

	WebDriver driver;

	@Before
	public void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver", "./src/resources/chromedriver/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rangeslider.js.org/");

	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() {

		// This method has an slider with an output with NO iframe
		WebElement slider = driver.findElement(By.xpath("//div[@class='rangeslider__handle']"));

		WebElement output = driver.findElement(By.cssSelector("output#js-output"));

		WebElement button1 = driver
				.findElement(By.xpath("//div[@id='js-example-change-value']//button[@class='button button--small']"));
		WebElement output1 = driver.findElement(By.xpath("//*[@id='js-example-change-value']/output"));

		WebElement textBox = driver
				.findElement(By.xpath("//div[@id='js-example-change-value']//input[@type='number']"));

		WebElement slider1 = driver
				.findElement(By.xpath("//div[@id='js-example-change-value']//div[@class='rangeslider__handle']"));

		Actions act = new Actions(driver);

		// act.dragAndDropBy(slider, -100, 0).perform();
		// String expectedOutput = "600";

		/*
		 * while (!(output.getText().equals(expectedOutput))) {
		 * act.dragAndDropBy(slider, 5, 0).perform(); }
		 * 
		 * if (output.getText().equals(expectedOutput)) {
		 * 
		 * System.out.println("Pass"); } else { System.out.println("Fail"); }
		 * 
		 * System.out.println("After dragging left the output is:" + output.getText());
		 * 
		 * // fail("Not yet implemented"); }
		 */
		String expected = "15";
		String maximum = "100";

		textBox.clear();
		textBox.sendKeys("200");
		button1.click();

		if (output1 != textBox) {

			textBox.clear();
			textBox.sendKeys("35");
			button1.click();

		}
		// Integer.parseInt(output1.getText());

		System.out.println("After click on ''change''the output is: " + output1.getText());

		while (!output1.getText().equals(expected)) {

			act.dragAndDropBy(slider1, 10, 0).build().perform();
			if (output1.getText().equals(maximum)) {
				break;
			}

		}
		while (!output1.getText().equals(expected)) {
			act.dragAndDropBy(slider1, -10, 0).build().perform();
		}

		System.out.println("After draggin the output is: " + output1.getText());

	}

}
