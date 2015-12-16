package teacher;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pages.BasePage;

public class MyCourses extends BasePage {

	@FindBy(id = "add")
	private static WebElement addCourse;
	
	public MyCourses(WebDriver driver) {
		super(driver);
	}

	public void clickAddCourse() {
		addCourse.click();
	}
}