package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import actions.Engine;
import base.Base;

public class CartPage extends Base{

	Engine aDriver;

	public static By deleteIcon = By.xpath(loc.getProperty("deleteIcon"));
	public static By placeOrderBtn = By.xpath(loc.getProperty("placeOrderBtn"));

	public CartPage() {
		PageFactory.initElements(driver, this);
		aDriver = new Engine();
	}

	public void removeItem() throws Exception {
		aDriver.waitUntilEleIsVisiable("deleteIcon");
		aDriver.isElePresent(deleteIcon, "deleteIcon");
		aDriver.click(deleteIcon, "deleteIcon");
	}

	public CheckOutPage clickOnPlaceOrder() throws Exception {
		Thread.sleep(2000);
		aDriver.waitUntilEleIsVisiable("placeOrderBtn");
		aDriver.isElePresent(placeOrderBtn, "placeOrderBtn");
		aDriver.click(placeOrderBtn, "placeOrderBtn");
		return new CheckOutPage();
	}
}
