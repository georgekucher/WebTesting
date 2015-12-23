package administrator;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.SignIn;
import tools.BaseTest;
import tools.PropertiesProvider;

public class SignInTest extends BaseTest {
	private static final String USER_EMAIL = PropertiesProvider.getProperty("user.email");
	private static final String USER_PASSWORD = PropertiesProvider.getProperty("user.password");
	private static final String SIGN_IN_TEXT
						= PropertiesProvider.getProperty("crsms.button.signin");
	
	private static SignIn signIn;
	
	@BeforeClass
	public static void setUpTest() {
		signIn = new SignIn(driver);
	}
	
	@Test
	public void testSignIn() {
		signIn.signIn(USER_EMAIL, USER_PASSWORD, false);
		AssertJUnit.assertTrue(signIn.getUserMenuText().contains(USER_EMAIL));
		signIn.signOutFromCRSMS();
	}

	@Test
	public void testSignOut() {
		signIn.signIn(USER_EMAIL, USER_PASSWORD, false);
		signIn.signOutFromCRSMS();
		AssertJUnit.assertTrue(signIn.getSignInText().contains(SIGN_IN_TEXT));
	}

	@Test
	public void testDefaultElementsPresence() {
		signIn.clickSignInLink();
		AssertJUnit.assertTrue(SignIn.getEmail().isDisplayed());
		AssertJUnit.assertTrue(SignIn.getPassword().isDisplayed());
		AssertJUnit.assertTrue(SignIn.getRememberMe().isDisplayed());
		AssertJUnit.assertTrue(SignIn.getSubmit().isDisplayed());
		AssertJUnit.assertTrue(SignIn.getReset().isDisplayed());
		AssertJUnit.assertTrue(SignIn.getSignUp().isDisplayed());
	}
}