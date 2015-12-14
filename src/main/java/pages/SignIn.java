package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignIn extends BasePage {
	
	@FindBy(name = "email")
	private static WebElement email; 
	@FindBy(name = "password")
	private static WebElement password; 
	@FindBy(name = "remember-me")
	private static WebElement rememberMe; 
	@FindBy(id = "submit")
	private static WebElement submit; 
	@FindBy(id = "reset")
	private static WebElement reset; 

	public SignIn(WebDriver driver) {
		super(driver);
	}

	public void setEmail(String strEmail) {
		email.sendKeys(strEmail);
	}
	
	public void setPassword(String strPassword) {
		password.sendKeys(strPassword);
	}

	public void rememberMe() {
		rememberMe.click();
	}

	public void clickSignIn() {
		submit.click();
	}
	
	public void clickReset() {
		reset.click();
	}
	
	public void signIn(String strEmail, String strPassword, Boolean willRememberMe) {
		this.clickSignInLink();
		this.setEmail(strEmail);
		this.setPassword(strPassword);
		if (willRememberMe) {
			this.rememberMe();
		}
		this.clickSignIn();
	}
}