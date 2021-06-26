package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends Baseclass {
	
	
		
	@Test(enabled=false)
	@Parameters({"username","password"})
	public void LoginTestcase(String uname, String pass) {
		
		LoginPage LoginObj = new LoginPage();
		LoginObj.login(uname, pass);	
	}
	
	@Test
	public void LoginTestcase2() {
		
		LoginPage LoginObj = new LoginPage();
		
		String uname = sheet.getRow(1).getCell(0).getStringCellValue();
		String pass = sheet.getRow(1).getCell(1).getStringCellValue();
		
		LoginObj.login(uname, pass);
	}
}
