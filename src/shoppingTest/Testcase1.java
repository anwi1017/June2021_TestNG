package shoppingTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;




public class Testcase1 {

	WebDriver driver;
	
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver","chromedriver");
		
		driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
	}
	@Test
	@Parameters({"username","password"})
	public void Login(String uname, String pass) {
		
		WebElement UserName = driver.findElement(By.xpath("//*[@id='user-name']"));
		
		UserName.sendKeys(uname);
		
 		WebElement Password = driver.findElement(By.xpath("//*[@id='password']"));
        
        Password.sendKeys(pass);
        
 		WebElement submit = driver.findElement(By.xpath("//*[@id='login-button']"));
 		
 		submit.click();

	}
	@Test(dependsOnMethods ="Login")
	public void addToCart() {
 		
		WebElement addToCart = driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-bolt-t-shirt']"));
 		
 		addToCart.click();
	}
	
	@AfterTest
	public void teardown() {
			
		
		driver.close();
		
	
	}

}	

