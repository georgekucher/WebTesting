

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pages.BasePage;
import tools.BaseTest;
import tools.PropertiesProvider;

public class LangSwitchTest extends BaseTest {
	private static final String LOGO_TITLE = PropertiesProvider.getProperty("crsms.text.app.title");

	private BasePage basePage;
	
	@Test
	public void testLangSwith() {
		basePage = new BasePage(driver);
		basePage.langUa();
		basePage.langEn();
		assertTrue(basePage.getLogoTitle().contains(LOGO_TITLE));
	}
}
