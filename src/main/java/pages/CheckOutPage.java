package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import actions.Engine;
import base.Base;

public class CheckOutPage extends Base{

	Engine aDriver;

	public static By nameField = By.id(loc.getProperty("nameField"));
	public static By countryField = By.id(loc.getProperty("countryField"));
	public static By cityFiled = By.id(loc.getProperty("cityFiled"));
	public static By creditCardFiled = By.id(loc.getProperty("creditCardFiled"));
	public static By monthField = By.id(loc.getProperty("monthField"));
	public static By yearField = By.id(loc.getProperty("yearField"));
	public static By purchaseBtn = By.xpath(loc.getProperty("purchaseBtn"));
	public static By closeBtn = By.xpath(loc.getProperty("closeBtn"));

	public CheckOutPage() {
		PageFactory.initElements(driver, this);
		aDriver = new Engine();
	}

	public VerifyCheckOutPage fillCheckRequest() throws Exception {
		Thread.sleep(2000);
		aDriver.waitUntilEleIsVisiable("nameField");
		aDriver.isElePresent(nameField, "nameField");
		aDriver.type(nameField, "nameField", "nameField");
		Thread.sleep(2000);
		aDriver.type(countryField, "countryField", "countryField");
		aDriver.type(cityFiled, "cityFiled", "cityFiled");
		aDriver.type(creditCardFiled, "1254258478541235", "creditCardFiled");
		aDriver.type(monthField, "09", "monthField");
		aDriver.type(yearField, "1990", "yearField");
		aDriver.click(purchaseBtn, "purchaseBtn");
		return new VerifyCheckOutPage();
	}
}
