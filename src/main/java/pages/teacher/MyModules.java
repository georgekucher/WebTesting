package pages.teacher;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pages.BasePage;

public class MyModules extends BasePage {
	
	@FindBy(id = "add")
	private static WebElement addModule;
	@FindBy(xpath = "//tbody/tr[last()]/td[1]")
	private static WebElement lastModuleName;
	@FindBy(xpath = "//tbody/tr[last()]/td[last()]//a[contains(@href, '/delete')]")
	private static WebElement deleteLastModule;

	public MyModules(WebDriver driver) {
		super(driver);
	}
	
	public void clickAddModule() {
		addModule.click();
	}

	public String lastModuleNameText() {
		return lastModuleName.getText();
	}
	
	public void clickDeleteLastModule() {
		deleteLastModule.click();
	}
}
