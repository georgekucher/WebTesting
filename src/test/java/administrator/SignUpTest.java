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
	private static final String REQUIRED_FIELD_ERROR
								= PropertiesProvider.getProperty("crsms.error.field.required");	
	private static final String NON_EQUAL_FIELD_ERROR
								= PropertiesProvider.getProperty("crsms.error.password.not.equals");	

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
	
	@Test
	public void testEmptySignUp() {
		signUp.signUp(null, null, null, false);
		AssertJUnit.assertTrue(signUp.getPasswordErrorText().equals(REQUIRED_FIELD_ERROR));
		AssertJUnit.assertTrue(signUp.getEmailErrorText().equals(REQUIRED_FIELD_ERROR));
	}

	@Test
	public void testNonEqualPasswords() {
		signUp.signUp(null, USER_PASSWORD, null, false);
		AssertJUnit.assertTrue(signUp.getConfPasswordErrorText().equals(NON_EQUAL_FIELD_ERROR));
	}
}
