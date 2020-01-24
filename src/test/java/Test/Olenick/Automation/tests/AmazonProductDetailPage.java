package Test.Olenick.Automation.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AmazonProductDetailPage extends Base {
	
	

	public AmazonProductDetailPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(css = "input[class=nav-input]")
	WebElement confirmSearch;

	@FindBy(id = "twotabsearchtextbox")
	WebElement searchBoxField;

	@FindBy(id = "buy-now-button")
	WebElement buyNowBtn;

	@FindBy(css = "select#searchDropdownBox")
	WebElement departmentButton;
	
	@FindBy(xpath ="//select[@name='quantity']")
	WebElement quantityDropdown;

	public void textSearchProduct(String product) {

		searchBoxField.click();
		searchBoxField.sendKeys(product);
		confirmSearch.click();

	}

	public void searchByDepartament(String department) {

		departmentButton.click();
		Select dropdown = new Select(departmentButton);
		dropdown.selectByVisibleText(department);

	}

	public AmazonSignInPage buyProductNow() {

		buyNowBtn.click();
		return new AmazonSignInPage(driver);

	}
	
	public void selectQty (String Quantity) {
		
		Select dropdown = new Select(quantityDropdown);
		quantityDropdown.click();
		dropdown.selectByVisibleText(Quantity);
		
	}

	@Override
	public void getUrl(String url) {

	}

}
