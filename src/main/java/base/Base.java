package base;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Helper;

public class Base {
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties loc = new Properties();
	public static FileReader fr;
	public static FileReader fr1;
	ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest parentTest;
	public static ExtentTest childTest;	
	String method;

	@BeforeTest
	public void setup() throws IOException {

		if(driver==null) {
			FileReader fr = new FileReader(System.getProperty("user.dir")+"\\configfiles\\config.properties");
			FileReader fr1 = new FileReader(System.getProperty("user.dir")+"\\configfiles\\locators.properties");
			prop.load(fr);
			loc.load(fr1);
		}
		if(prop.getProperty("browser").equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		htmlReporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir") +"/Reports/MyReport.html"));
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	//	@BeforeTest
	//	public void report() {
	//		htmlReporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir") +"/Reports/MyReport.html"));
	//		extent = new ExtentReports();
	//		extent.attachReporter(htmlReporter);
	//	}
	@BeforeMethod
	public void method(Method method) {
		parentTest = extent.createTest(method.getName());
	}
	@AfterTest
	public void stopDriver() {
		driver.quit();
		extent.flush();
	}
	//take Screenshot when test case fail and add it to Screenshot folder
	@AfterMethod
	public void screenshotOnFailure(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Failed");
			System.out.println("Taking Screenshot...");
			Helper.captureScreenshot(driver, result.getName());

		}
	}

}
