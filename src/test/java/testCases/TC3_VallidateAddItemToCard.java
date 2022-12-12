package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Base;
import pages.AddToCardPage;
import pages.CartPage;
import pages.CheckOutPage;
import pages.HomePage;
import pages.VerifyCheckOutPage;

public class TC3_VallidateAddItemToCard extends Base{

	@Test(priority = 1)
	public static void AddItemToCard() throws Exception {
		HomePage homePage = new HomePage();
		AddToCardPage addToCardPage = new AddToCardPage();

		Base.childTest = Base.parentTest.createNode("startTest");
		boolean result = homePage.isWelcomeMsgPresent();
		Assert.assertTrue(result);
		boolean result2 = homePage.isCategoriesListHasItems();
		Assert.assertTrue(result2);
		homePage.clickOnItem1();
		addToCardPage.validateAddToCard();
		addToCardPage.backToHome();
		boolean result3 = homePage.isWelcomeMsgPresent();
		Assert.assertTrue(result3);
		homePage.clickOnItem2();
		addToCardPage.validateAddToCard();
		addToCardPage.backToHome();
		boolean result4 = homePage.isWelcomeMsgPresent();
		Assert.assertTrue(result4);

	}

}
