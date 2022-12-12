package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import base.Base;
import pages.HomePage;
import pages.LoginPage;

public class TC2_ValidateLogin extends Base{

	@Test(priority = 1)
	public static void Login() throws Exception {
		HomePage homePage = new HomePage();
		LoginPage loginPage = new LoginPage();
		
		Base.childTest = Base.parentTest.createNode("startTest");
		boolean result1 = homePage.isWelcomeMsgPresent();
		Assert.assertTrue(result1);
		homePage.clickOnLogin();
		System.out.println(driver.getTitle());
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean result = homePage.isWelcomeMsgPresent();
		Assert.assertTrue(result);
		boolean result2 = homePage.isCategoriesListHasItems();
		Assert.assertTrue(result2);
		
	}
	
}
