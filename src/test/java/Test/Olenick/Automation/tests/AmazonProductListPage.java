package Test.Olenick.Automation.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AmazonProductListPage extends Base {

	public AmazonProductListPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);

	}

	@FindBy(css = "input[class=nav-input]")
	WebElement confirmSearch;

	@FindBy(id = "twotabsearchtextbox")
	WebElement searchBoxField;

	@FindBy(xpath = "//*[@id=\"p_89/HP\"]/span/a/div/label/i")
	WebElement hpBrandCheckbox;

	@FindBy(css = "select#searchDropdownBox")
	WebElement departmentButton;

	@FindBy(css = "img[src=\"https://m.media-amazon.com/images/I/61WpR0Uen1L._AC_UY218_ML3_.jpg\"]")
	WebElement productSelector;

	@FindBy(css = "span.a-list-item")
	WebElement primeSelector;

	public void textSearchProduct(String product) {

		searchBoxField.click();

		searchBoxField.sendKeys(product);

		confirmSearch.click();

	}

	public void searchByDepartament(String department) {

		departmentButton.click();

		Select dropdown = new Select(departmentButton);
		dropdown.deselectByVisibleText(department);
	}

	public void filterByBrand() {

		hpBrandCheckbox.click();

	}

	public void selectProduct() {

		productSelector.click();

	}

	public void filterByPrime() {

		primeSelector.click();

	}

	@Override
	public void getUrl(String url) {

	}

}
