package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import actions.Engine;
import base.Base;

public class AddToCardPage extends Base{

	Engine aDriver;

	public static By itemTitle = By.xpath(loc.getProperty("itemTitle"));
	public static By addToCard = By.xpath(loc.getProperty("addToCard"));
	public static By home = By.xpath(loc.getProperty("home"));

	public AddToCardPage() {
		PageFactory.initElements(driver, this);
		aDriver = new Engine();
	}

	public void validateAddToCard() throws Exception {
		aDriver.waitUntilEleIsVisiable("itemTitle");
		aDriver.isElePresent(itemTitle, "itemTitle");
		aDriver.waitUntilEleIsVisiable("addToCard");
		aDriver.click(addToCard, "addToCard");
		Thread.sleep(3000);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}	

	public HomePage backToHome() throws Exception {
		aDriver.waitUntilEleIsVisiable("home");
		aDriver.click(home, "homeIcon");
		return new HomePage();

	}

}
