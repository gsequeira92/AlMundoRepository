package Test.Olenick.Automation.tests;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonHomePage extends Base {

	String url = "https://www.amazon.es/ref=nav_logo";

	public AmazonHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);

	}

	@FindBy(css = "input[class=nav-input]")
	WebElement confirmSearch;

	@FindBy(id = "twotabsearchtextbox")
	WebElement searchBoxField;

	@FindBy(css = "select#searchDropdownBox")
	WebElement departmentButton;

//	By searchBoxField = By.id("twotabsearchtextbox");
//	By HpBrandCheckbox = By.xpath("//*[@id=\"p_89/HP\"]/span/a/div/label/i");
//	By ConditionSelector = By.xpath("//*[@id=\"p_n_condition-type/6461716011\"]/span/a/span");
//	By ProductSelector = By
//			.cssSelector("img[src=\"https://m.media-amazon.com/images/I/41q8ZrzTpyL._AC_UY218_ML3_.jpg\"]");
//	By ConfirmSearch = By.cssSelector("input.nav-input");
//	By SignInLocator = By.cssSelector("input#continue");
//	By BuyNowBtn = By.id("buy-now-button");
//	By departmentButton = By.cssSelector("select#searchDropdownBox");

	public void textSearchProduct(String product) {

		searchBoxField.click();

		searchBoxField.sendKeys(product);

		confirmSearch.click();

	}

	public void searchByDepartament(String aDepartment) {

		departmentButton.click();

		Select dropdown = new Select(departmentButton);
		dropdown.selectByVisibleText(aDepartment);

	}

	public boolean departmentNameIsDisplayed() {

		return confirmSearch.isDisplayed();

	}

	@Override
	public void getUrl(String url) {

	}

}
