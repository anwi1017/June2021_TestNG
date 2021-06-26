package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.LoginPage;

public class LoginTest {
	
	WebDriver driver;
	
	ExtentReports report;
	ExtentTest test;
	
	SoftAssert soft = new SoftAssert();	
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver","chromedriver");
		
		driver = new ChromeDriver();
		
		driver.get("https://www.simplilearn.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		report = new ExtentReports("ExtentReport.html");
	}
		
	@Test
	@Parameters({"username","password"})
	public void LoginTest(String uname, String pass) {
		
		LoginPage loginObj = new LoginPage();
		loginObj.Login(uname, pass);
		
	}
	
	@AfterMethod
	public void teardown() {
			
		report.endTest(test);
		report.flush();
		
		driver.close();
		
		soft.assertAll();
	}

}
