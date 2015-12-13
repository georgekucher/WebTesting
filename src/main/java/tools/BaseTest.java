package tools;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	private static final String BASEURL = PropertiesProvider.getProperty("base.url");
    private static final int TIMEOUT = Integer.parseInt(PropertiesProvider.getProperty("time.out"));
	protected static WebDriver driver;

	@BeforeClass
	public static void setUp() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		driver.get(BASEURL);
	}
	
	@AfterClass
	public static void tearDown() {
		driver.close();
		driver.quit();
	}
}