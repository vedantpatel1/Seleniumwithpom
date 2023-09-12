package testlayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basepackage.Baseclass;
import pompackage.Pomlogin;
import testdata.Exceldata;

public class LoginTest extends Baseclass {

	Pomlogin Log;
	public LoginTest() {
		
		super();
	}
	
	@BeforeMethod
	public void inisetup() {
		initiation();
		Log=new Pomlogin();
		screenshot("Login");
	}
	

	@Test
	public void title() {
		String actual = Log.verifytitle();
		Assert.assertEquals(actual, "OrangeHRM");
	}
	@DataProvider
	public Object[][] Details(){
		Object result[][]= Exceldata.readdata("Sheet1");
		return result;
	}
	
	
	@Test(dataProvider="Details")
	public void Login(String name, String password) {
		Log.typeusername(name);
		System.out.println(name);
		Log.typepasswod(password);
		//Log.clicklogin();	
		
	}
	
	@AfterMethod
	public void close() {
		//driver.close();
	}
	}
	

