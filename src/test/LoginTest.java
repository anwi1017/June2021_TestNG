package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LoginTest {
	
	@Test
	public void test1() {
		System.setProperty("webdriver.chrome.driver","chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.simplilearn.com/");
		
		driver.manage().window().maximize();
		
		//driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		

		
		WebElement LoginLink = driver.findElement(By.linkText("Log in"));
		
		LoginLink.click();
		
		WebElement UserName = driver.findElement(By.name("user_login"));
		
		WebDriverWait wait = new WebDriverWait(driver,30);
			
		wait.until(ExpectedConditions.elementToBeClickable(UserName));
		
		UserName.sendKeys("anwi1017@mail.com");
		
		WebElement Rememberme = driver.findElement(By.className("rememberMe"));
		
		Rememberme.click();
		
		WebElement Password = driver.findElement(By.id("password"));
		
		Password.sendKeys("9876");
		
		WebElement LoginBtn = driver.findElement(By.name("btn_login"));
		
		LoginBtn.click();
		
		WebElement LoginError = driver.findElement(By.className("error_msg"));
		
		String ActMsg = LoginError.getText();
		
		String ClassName = LoginError.getAttribute("class");
		String TagName = LoginError.getTagName();
		
		System.out.println("Class Name is "+ ClassName);
		System.out.println("Tag Name is "+ TagName);
		
		String ExpMsg = "The email or password you have entered is invalid.";
		
		if(ActMsg.equals(ExpMsg)) {
			System.out.println("Test Passed");
		}else {
			System.out.println("Test Failed");
		}
		
		
		List<WebElement> InputTags = driver.findElements(By.tagName("input"));
		System.out.println("Total number of input tags are " + InputTags.size());
		
		List<WebElement> Links = driver.findElements(By.tagName("a"));
		System.out.println("Total number of hyperlinks are " + Links.size());
		
		for(int index=0; index<Links.size(); index++) {
		
		System.out.println("Hyperlinks Text " + Links.get(index).getText());
		
		}
		
		driver.close();
	}

}
