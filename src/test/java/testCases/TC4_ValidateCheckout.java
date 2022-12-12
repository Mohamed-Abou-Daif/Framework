package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Base;
import pages.CartPage;
import pages.CheckOutPage;
import pages.HomePage;
import pages.VerifyCheckOutPage;

public class TC4_ValidateCheckout extends Base{

	@Test(priority = 1)
	public static void CheckOut() throws Exception {
		HomePage homePage = new HomePage();
		CartPage cartPage = new CartPage();
		CheckOutPage checkOutPage = new CheckOutPage();
		VerifyCheckOutPage verifyCheckOutPage = new VerifyCheckOutPage();

		homePage.clickOnCartIcon();
		cartPage.removeItem();
		cartPage.clickOnPlaceOrder();
		checkOutPage.fillCheckRequest();
		verifyCheckOutPage.verifyCheckOut();
		boolean result = homePage.isWelcomeMsgPresent();
		Assert.assertTrue(result);
		Thread.sleep(4000);
	}
}
