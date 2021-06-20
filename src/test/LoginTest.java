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

public class LoginTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver","chromedriver");
		
		driver = new ChromeDriver();
		
		driver.get("https://www.simplilearn.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	}
		
	@Test
	@Parameters({"username","password"})
	public void Login(String uname, String pass) {
				
		WebElement LoginLink = driver.findElement(By.linkText("Log in"));
		
		LoginLink.click();
		
		WebElement UserName = driver.findElement(By.name("user_login"));
		
		WebDriverWait wait = new WebDriverWait(driver,30);
			
		wait.until(ExpectedConditions.elementToBeClickable(UserName));
		
		UserName.sendKeys(uname);
		
		WebElement Rememberme = driver.findElement(By.className("rememberMe"));
		
		Rememberme.click();
		
		WebElement Password = driver.findElement(By.id("password"));
		
		Password.sendKeys(pass);
		
		WebElement LoginBtn = driver.findElement(By.name("btn_login"));
		
		LoginBtn.click();
		
		WebElement LoginError = driver.findElement(By.className("error_msg"));
		
		String ActMsg = LoginError.getText();
		String ExpMsg = "The email or password you have entered is invalid.";
		
		Assert.assertTrue(LoginError.isDisplayed());
		Assert.assertEquals(ActMsg, ExpMsg);

		
	}
	
	@AfterMethod
	public void teardown() {
		
		driver.close();
		
	}

}
