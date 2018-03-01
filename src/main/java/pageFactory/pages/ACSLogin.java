package pageFactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ACSLogin {

	WebDriver driver;
	
	@FindBy(id="loginForm:login")
	WebElement userIdentifiant ;
	@FindBy(id="loginForm:password")
	WebElement password;
	@FindBy(name="loginForm:j_id38")
	WebElement loginButton;
	
	public ACSLogin(WebDriver driver) {
		this.driver = driver;
		//Initialisation des elements : 
		PageFactory.initElements(driver, this);
	}
	
	public void setUserIdentifiant(String identifiant) {
		this.userIdentifiant.sendKeys(identifiant);
	}
	
	public void setPassword(String password) {
		this.password.sendKeys(password);
	}
	
	public void ClickLoginButton() {
		this.loginButton.click();
	}
	
	public void LoginToAcs(String identifiant, String password) {
		this.setUserIdentifiant(identifiant);
		this.setPassword(password);
		this.ClickLoginButton();
	}
	
}
