package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Base;
import pages.HomePage;
import pages.LoginPage;
import pages.SignUpPage;

public class TC1_ValidateSignUp extends Base{



	@Test(priority = 1)
	public static void SignUp() throws Exception {
		HomePage homePage = new HomePage();
		SignUpPage signUpPage = new SignUpPage();

		Base.childTest = Base.parentTest.createNode("startTest");
		homePage.clickOnSignUp();
		signUpPage.creatUser(prop.getProperty("username"), prop.getProperty("password"));

	}

}
