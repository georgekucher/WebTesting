package teacher;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.SignIn;
import pages.teacher.MyCourses;
import pages.teacher.NewCourse;
import tools.BaseTest;
import tools.PropertiesProvider;

public class CourseTest extends BaseTest {
	private static final String USER_EMAIL = PropertiesProvider.getProperty("user.email");
	private static final String USER_PASSWORD = PropertiesProvider.getProperty("user.password");
	private static final String COURSE_NAME = PropertiesProvider.getProperty("course.name");
	private static final String COURSE_DESCRIPTION
								= PropertiesProvider.getProperty("course.description");
	private static final String COURSE_AREA = PropertiesProvider.getProperty("course.area");
	private static final String COURSE_DURATION = PropertiesProvider.getProperty("course.duration");
	
	private static SignIn signIn;
	private static MyCourses myCourses;
	private static NewCourse newCourse;
	
	@BeforeClass
	public static void setUpTest() {
		signIn = new SignIn(driver);
		myCourses = new MyCourses(driver);
		newCourse = new NewCourse(driver);
	}
	
	@Test
	public void testCousreCreation() {
		signIn.signIn(USER_EMAIL, USER_PASSWORD, false);
		myCourses.clickAddCourse();
		newCourse.createNewCourse(COURSE_NAME, COURSE_DESCRIPTION,
								COURSE_AREA, COURSE_DURATION, true);
		AssertJUnit.assertTrue(myCourses.lastCourseNameText().contains(COURSE_NAME));
		myCourses.clickDeleteLastCourse();
	}
}