package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUp extends BasePage {

	@FindBy(name = "email")	
	private static WebElement email; 
	@FindBy(name = "password")
	private static WebElement password; 
	@FindBy(name = "confPassword")	
	private static WebElement confPassword; 
	@FindBy(name = "teacher")	
	private static WebElement teacher; 
	@FindBy(id = "create")
	private static WebElement create;
	@FindBy(id = "email-error")
	private static WebElement emailError;
	@FindBy(id = "password-error")
	private static WebElement passwordError;
	@FindBy(id = "confPassword-error")
	private static WebElement confPasswordError;

	public SignUp(WebDriver driver) {
		super(driver);
	}

	public static WebElement getEmail() {
		return email;
	}

	public static WebElement getPassword() {
		return password;
	}

	public static WebElement getConfPassword() {
		return confPassword;
	}

	public static WebElement getTeacher() {
		return teacher;
	}

	public static WebElement getCreate() {
		return create;
	}

	public void setEmail(String strEmail) {
		email.sendKeys(strEmail);
	}
	
	public void setPassword(String strPassword) {
		password.sendKeys(strPassword);
	}

	public void setConfPassword(String strPassword) {
		confPassword.sendKeys(strPassword);
	}

	public void teacher() {
		teacher.click();
	}

	public void clickCreate() {
		create.click();
	}
	
	public void signUp(String strEmail, String strPassword,
				String strConfPassword, Boolean iAmTeacher) {
		this.setEmail(strEmail);
		this.setPassword(strPassword);
		this.setConfPassword(strConfPassword);
		if (iAmTeacher) {
			this.teacher();
		}
		this.clickCreate();
	}
	
	public String getEmailErrorText() {
		return emailError.getText();
	}

	public String getPasswordErrorText() {
		return passwordError.getText();
	}

	public String getConfPasswordErrorText() {
		return confPasswordError.getText();
	}
}
