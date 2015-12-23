package pages.teacher;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pages.BasePage;

public class NewModule extends BasePage {

	@FindBy(name = "name")
	private static WebElement name;
	@FindBy(name = "description")
	private static WebElement description;
	@FindBy(name = "available")
	private static WebElement available;
	@FindBy(id = "save")
	private static WebElement save;

	public NewModule(WebDriver driver) {
		super(driver);
	}

	public void setName(String strName) {
		name.sendKeys(strName);
	}

	public void setDescription(String strDescription) {
		description.sendKeys(strDescription);
	}

	public void clickAvailable() {
		available.click();
	}

	public void clickSave() {
		save.click();
	}

	public void createNewCourse(String strName, String strDescription, Boolean isAvailable) {
		this.setName(strName);
		this.setDescription(strDescription);
		if (isAvailable) {
			this.clickAvailable();
		}
		this.clickSave();
	}	
}
