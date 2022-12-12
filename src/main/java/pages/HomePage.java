package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import actions.Engine;
import base.Base;

public class HomePage extends Base{

	Engine aDriver;
	public static By signUpEle = By.id(loc.getProperty("singUp"));
	public static By loginBtn = By.xpath(loc.getProperty("loginBtn"));
	public static By nameofuser = By.id(loc.getProperty("nameofuser"));
	public static By categoriesItems = By.xpath(loc.getProperty("categoriesItems"));
	public static By item1 = By.xpath(loc.getProperty("item1"));
	public static By item2 = By.xpath(loc.getProperty("item2"));
	public static By cartIcon = By.id(loc.getProperty("cartIcon"));

	public HomePage() {
		PageFactory.initElements(driver, this);
		aDriver = new Engine();
	}

	public SignUpPage clickOnSignUp() throws Exception {
		aDriver.waitUntilEleIsVisiable("signUpEle");
		aDriver.click(signUpEle,"signUpEle");
		return new SignUpPage();
	}

	public LoginPage clickOnLogin() throws Exception {
		Thread.sleep(2000);
		aDriver.waitUntilEleIsVisiable("loginBtn");
		aDriver.click(loginBtn,"loginBtn");
		return new LoginPage();
	}

	public boolean isWelcomeMsgPresent() throws Exception {
		aDriver.waitUntilEleIsVisiable("nameofuser");
		return aDriver.isElePresent(nameofuser, "nameofuser");

	}

	public boolean isCategoriesListHasItems() throws Exception {
		aDriver.waitUntilEleIsVisiable("categoriesItems");
		return aDriver.isElePresent(categoriesItems, "categoriesItems");
	}

	public AddToCardPage clickOnItem1() throws Exception {
		aDriver.waitUntilEleIsVisiable("item1");
		Thread.sleep(3000);
		aDriver.click(item1, "item1");	 
		return new AddToCardPage();

	}

	public AddToCardPage clickOnItem2() throws Exception {
		aDriver.waitUntilEleIsVisiable("item2");
		Thread.sleep(3000);
		aDriver.click(item2, "item2");
		return new AddToCardPage();

	}

	public CartPage clickOnCartIcon() throws Exception {
		aDriver.waitUntilEleIsVisiable("cartIcon");
		aDriver.click(cartIcon, "cartIcon");
		return new CartPage();

	}
}
