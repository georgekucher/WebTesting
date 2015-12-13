package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	protected WebDriver driver;
	
	@FindBy(linkText = "EN")
	protected static WebElement langEn;
	@FindBy(linkText = "UA")
	protected static WebElement langUa;
	@FindBy(id = "logo-app-title")
	protected static WebElement logoTitle;
	@FindBy(xpath = "//a[@href='/crsms/signin']")
	protected static WebElement signIn;
	@FindBy(id = "dLabel")
	protected static WebElement userMenu;
	@FindBy(xpath = "//a[@href='/crsms/signout']")
	protected static WebElement signOut;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void langEn() {
		langEn.click();
	}
	
	public void langUa() {
		langUa.click();
	}
	
	public String getLogoTitle() {
		return logoTitle.getText();
	}
	
	public void toMainPage() {
		logoTitle.click();
	}
	
	public String getSignInText() {
		return signIn.getText();
	}
	
	public void clickSignInLink() {
		signIn.click();
	}

	public String getUserMenuText() {
		return userMenu.getText();
	}

	public void clickUserMenu() {
		userMenu.click();
	}

	public void clickSignOut() {
		signOut.click();
	}
	
	public void signOutFromCRSMS() {
		this.clickUserMenu();
		this.clickSignOut();
	}
}