package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import actions.Engine;
import base.Base;

public class VerifyCheckOutPage extends Base{
	Engine aDriver;

	public static By VerifyIcon = By.xpath(loc.getProperty("VerifyIcon"));
	public static By okBtn = By.xpath(loc.getProperty("okBtn"));

	public VerifyCheckOutPage() {
		PageFactory.initElements(driver, this);
		aDriver = new Engine();
	}

	public HomePage verifyCheckOut() throws Exception {
		aDriver.waitUntilEleIsVisiable("VerifyIcon");
		aDriver.isElePresent(VerifyIcon, "VerifyIcon");
		aDriver.waitUntilEleIsVisiable("okBtn");
		aDriver.click(okBtn, "okBtn");

		return new HomePage();
	}

}
