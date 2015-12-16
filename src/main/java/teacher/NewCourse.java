package teacher;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import pages.BasePage;

public class NewCourse extends BasePage {

	@FindBy(id = "name")
	private static WebElement name;
	@FindBy(id = "description")
	private static WebElement description;
	@FindBy(id = "areas")
	private static Select areas;
	@FindBy(id = "duration")
	private static WebElement duration;
	@FindBy(id = "open")
	private static WebElement open;
	@FindBy(id = "save")
	private static WebElement save;
	
	public NewCourse(WebDriver driver) {
		super(driver);
	}
	
	public void setName(String strName) {
		name.sendKeys(strName);
	}

	public void setDescription(String strDescription) {
		description.sendKeys(strDescription);
	}

	public void setArea(String strAreaValue) {
		areas.selectByValue(strAreaValue);
	}

	public void setDuration(String strDuration) {
		duration.sendKeys(strDuration);
	}

	public void clickOpen() {
		open.click();
	}

	public void clickSave() {
		save.click();
	}

	public void createNewCourse(String strName, String strDescription, String strAreaValue,
								String strDuration, Boolean isOpen) {
		this.setName(strName);
		this.setDescription(strDescription);
		this.setArea(strAreaValue);
		this.setDuration(strDuration);
		if (isOpen) {
			this.clickOpen();
		}
		this.clickSave();
	}
}
