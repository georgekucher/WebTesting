package pages.teacher;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pages.BasePage;

public class MyCourses extends BasePage {

	@FindBy(id = "add")
	private static WebElement addCourse;
	@FindBy(xpath = "//tbody/tr[last()]/td[1]")
	private static WebElement lastCourseName;
	@FindBy(xpath = "//tbody/tr[last()]/td[last()]//a[contains(@href, '/delete')]")
	private static WebElement deleteLastCourse;
	@FindBy(xpath = "//tbody/tr[last()]/td[last()]//a[contains(@href, '/modules/')]")
	private static WebElement lastCourseModules;
	
	public MyCourses(WebDriver driver) {
		super(driver);
	}

	public void clickAddCourse() {
		addCourse.click();
	}
	
	public String lastCourseNameText() {
		return lastCourseName.getText();
	}
	
	public void clickDeleteLastCourse() {
		deleteLastCourse.click();
	}
	
	public void clickLastCourseModules() {
		lastCourseModules.click();
	}
}