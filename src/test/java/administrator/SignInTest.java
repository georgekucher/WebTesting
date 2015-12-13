package administrator;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pages.SignIn;
import tools.BaseTest;
import tools.PropertiesProvider;

public class SignInTest extends BaseTest {
	private static final String USER_EMAIL = PropertiesProvider.getProperty("user.email");
	private static final String USER_PASSWORD = PropertiesProvider.getProperty("user.password");
	private static final String SIGN_IN_TEXT = PropertiesProvider.getProperty("crsms.button.signin");
	
	private SignIn signIn;
	
	@Test
	public void testSignIn() {
		signIn = new SignIn(driver);
		signIn.signInToCRSMS(USER_EMAIL, USER_PASSWORD, false);
		assertTrue(signIn.getUserMenuText().contains(USER_EMAIL));
	}

	@Test
	public void testSignOut() {
		signIn = new SignIn(driver);
		signIn.signInToCRSMS(USER_EMAIL, USER_PASSWORD, false);
		signIn.signOutFromCRSMS();
		assertTrue(signIn.getSignInText().contains(SIGN_IN_TEXT));
	}
}
