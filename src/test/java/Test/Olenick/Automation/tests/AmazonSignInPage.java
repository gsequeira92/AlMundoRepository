package Test.Olenick.Automation.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonSignInPage extends Base {

	public AmazonSignInPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(css = "input[id=continue]")
	WebElement signInBtn;

	public boolean signInPageDisplayed() {

		return signInBtn.isDisplayed();

	}

	public void waitForPage() {

		this.wait(signInBtn);
	}

	@Override
	public void getUrl(String url) {
		
		
	}

}
