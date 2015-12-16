package administrator;

import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.SignIn;
import pages.SignUp;
import tools.BaseTest;
import tools.PropertiesProvider;

public class SignUpTest extends BaseTest {
	private static final String USER_EMAIL = PropertiesProvider.getProperty("user.email");
	private static final String USER_PASSWORD = PropertiesProvider.getProperty("user.password");
	
	private static SignIn signIn;
	private static SignUp signUp;
	
	@BeforeClass
	public static void setUpTest() {
		signIn = new SignIn(driver);
		signUp = new SignUp(driver);
	}
	
	@Test
	public void testDefaultElementsPresence() {
		signIn.clickSignInLink();
		signIn.clickSignUp();
		AssertJUnit.assertTrue(SignUp.getEmail().isDisplayed());
		AssertJUnit.assertTrue(SignUp.getPassword().isDisplayed());
		AssertJUnit.assertTrue(SignUp.getConfPassword().isDisplayed());
		AssertJUnit.assertTrue(SignUp.getTeacher().isDisplayed());
		AssertJUnit.assertTrue(SignUp.getCreate().isDisplayed());
	}

	@Test(enabled = false)
	public void testSignUp() {
		signUp.signUp(USER_EMAIL, USER_PASSWORD, USER_PASSWORD, false);
		signIn.signIn(USER_EMAIL, USER_PASSWORD, false);
		AssertJUnit.assertTrue(signIn.getUserMenuText().contains(USER_EMAIL));
		signIn.signOutFromCRSMS();
	}
}
