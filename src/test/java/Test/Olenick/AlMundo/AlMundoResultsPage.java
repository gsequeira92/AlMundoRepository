package Test.Olenick.AlMundo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlMundoResultsPage extends Base {

	public AlMundoResultsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);

	}

	@FindBy(css = "div.results__content__matrix")
	public
	WebElement flightOptionsMatrix;

	@FindBy(css = "ul.check-list")
	WebElement originBaggageFilter;

	@FindBy(css = "span.min")
	WebElement minDurationText;

	@FindBy(css = "span.max")
	WebElement maxDurationText;

	@FindBy(xpath = "//div[@id='filter-duration']//div[@class='filter-duration ng-star-inserted']//div[@class='noUi-handle noUi-handle-lower']")
	WebElement flightDurationlowerSlider;

	@FindBy(xpath = "//div[@id='filter-duration']//div[@class='filter-duration ng-star-inserted']//div[@class='noUi-handle noUi-handle-upper']")
	WebElement flightDurationUpperSlider;

	@FindBy(css = "label[for='all-airlines']")
	WebElement selectAllAirlinesCheckbox;

	@FindBy(css = "svg#trash")
	WebElement deleteAllFiltersButton;

	@FindBy(css = "div.inner")
	WebElement pagesIndicator;

	Actions act = new Actions(driver);

	// Test method
	public void refineFlightSearch(String direction, String baggage, String scale, String sorting, String airline,
			String option, CharSequence number) {

		selectFlightCategorySorting(sorting);
		selectScaleOption(scale);
		selectBaggageOption(direction, baggage);
		// selectSpecificAirline(airline);
		// selectAllAirlineOptions();
		deleteAllFiltersButton.click();
		managePagination(option);
		goToPageNumber(number);

	}

	public void goToPageNumber(CharSequence number) {

		driver.findElement(By.xpath("//button[@class='direct ng-star-inserted'][.=" + number + "]")).click();

	}

	// Options: first-last-next-previous
	public void managePagination(String option) {

		driver.findElement(By.xpath("//button[@class='" + option + "")).click();

	}

	// *Más Barato - Recomendado - Más Rápido //
	public void selectFlightCategorySorting(String option) {

		driver.findElement(By
				.xpath("//div[@class='results__content__sortings']//div[@class='sorting-header'][.='" + option + "']"))
				.click();
	}

	public void selectAllAirlineOptions() {
		selectAllAirlinesCheckbox.click();
	}

	public void selectSpecificAirline(String airline) {

		driver.findElement(
				By.xpath("//div[@id='filter-airlines']//div[@class='filters__content']//*[.='" + airline + "']"))
				.click();

	}

	// Method to filter baggage for origin and destination
	public void selectTypeOfBaggageOption(String option, String origin) {

	}

	// Method to select any scale option (FYI: An option could be Direct flight with
	// one scale)
	public void selectScaleOption(String option) {

		driver.findElement(By.xpath("//div[@id='filter-duration']//ul[@class='check-list']/*[.='" + option + "'])"))
				.click();

	}

//	public void selectBaggageOption(String option) {
//		driver.findElement(
//				By.xpath("//ul[@class='check-list']//li[@id='all-segment-0-baggage-input']/*[.='" + option + "']"))
//				.click();

//	}

	public void selectBaggageOption(String direction, String option) {

		if (direction.equals("IDA")) {

			driver.findElement(
					By.xpath("//ul[@class='check-list']//label[@for='all-segment-0-baggage'][.='" + option + "']"))
					.click();

		} else if (option.equals("VUELTA")) {

			driver.findElement(
					By.xpath("//ul[@class='check-list']//li[@id='all-segment-1-baggage-input'][.='" + option + "']"))
					.click();

		}

	}

	// valueText / 60 = visible slide duration -->(class min/max)
	// Each slide is independent
	// Each move changes page content according filter criteria.-
	// Some slide values doesn't display results (because there're no matches)

	public void selectMinFlightDuration(String durationMin) {
		// Duracion minima
		String originDuration = minDurationText.getText();
		// Duracion minima*60 = valueText

		while (durationMin != originDuration) {

			// act.dragAndDropBy(flightDurationlowerSlider, xOffset, yOffset);

		}
	}

	public void selectFlightDurationFromOrTo(String option) {

		driver.findElement(By.xpath(
				"//div[@id='filter-duration']//div[@class='filter-duration ng-star-inserted']/*[.='" + option + "']"));

	}

	public boolean isDisplayed() {

		boolean result = false;

		if (flightOptionsMatrix.isDisplayed()) {

			result = true;
		}

		return result;
	}

	@Override
	public void getUrl() {
		// TODO Auto-generated method stub

	}

}
