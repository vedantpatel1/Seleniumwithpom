package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackage.Baseclass;

public class Pomlogin extends Baseclass {

	//Object repository
	
	@FindBy(id="text-77525447616")
     WebElement username;	
	
	@FindBy(id="text-95374915097")
	WebElement password;
	
	//@FindBy(css="#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div.oxd-form-actions.orangehrm-login-action > button\r\n")
	//WebElement loginbtn;
	
	public Pomlogin() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void typeusername(String name) {
		username.sendKeys(name);
	}

	public void typepasswod(String pass) {
		password.sendKeys(pass);
	}


	//public void clicklogin() {
		//loginbtn.click();
	//}
	
	public String verifytitle() {
		return driver.getTitle();
	}
}


