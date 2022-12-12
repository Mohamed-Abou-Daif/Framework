package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import actions.Engine;
import base.Base;

public class LoginPage extends Base{

	Engine aDriver;

	public static By loginusername = By.id(loc.getProperty("loginusername"));
	public static By loginpassword = By.id(loc.getProperty("loginpassword"));
	public static By login = By.xpath(loc.getProperty("login"));
	public static By closeLogin = By.xpath(loc.getProperty("closeLogin"));


	public LoginPage() {
		PageFactory.initElements(driver, this);
		aDriver = new Engine();
	}

	public HomePage login(String username, String password) throws Exception {
		aDriver.waitUntilEleIsVisiable("loginusername");
		aDriver.type(loginusername, username, "loginusername");
		aDriver.waitUntilEleIsVisiable("loginpassword");
		aDriver.type(loginpassword, password, "loginpassword");
		aDriver.waitUntilEleIsVisiable("login");
		aDriver.click(login, "login");
		return new HomePage();
	}

}
