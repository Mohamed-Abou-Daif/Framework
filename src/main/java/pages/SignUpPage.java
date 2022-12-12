package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import actions.Engine;
import base.Base;

public class SignUpPage extends Base{

	Engine aDriver;

	public static By userNameTxtBox = By.id(loc.getProperty("userName"));
	public static By passwordTxtBox = By.id(loc.getProperty("password"));
	public static By btn = By.xpath(loc.getProperty("btn"));
	public static By closeBtn = By.xpath(loc.getProperty("closeBtn"));

	public SignUpPage() {
		PageFactory.initElements(driver, this);
		aDriver = new Engine();
	}

	public HomePage creatUser(String username, String password) throws Exception{
		
		aDriver.waitUntilEleIsVisiable("userNameTxtBox");
		aDriver.type(userNameTxtBox, username, "username");
		aDriver.waitUntilEleIsVisiable("passwordTxtBox");
		aDriver.type(passwordTxtBox, password, "passwordTxtBox");
		aDriver.waitUntilEleIsVisiable("btn");
		aDriver.click(btn, "btn");
		Thread.sleep(3000);
		String msg = driver.switchTo().alert().getText();
		if(msg=="Sign up successful.") {
			
			System.out.println(driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();
		}
		else {
			
			System.out.println(driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();
			
			try {
				aDriver.waitUntilEleIsVisiable("closeBtn");
				aDriver.click(closeBtn, "closeBtn");
			} catch (Exception e) {
				System.out.println("Can't click on Close Btn");
				driver.navigate().refresh();
			}
		}
		return new HomePage();
	}
}
