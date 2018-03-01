package pageFactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ACSConfigurationHSM {
	WebDriver driver;
/*
 * 	@FindBy(id="iconj_id26:j_id28")
	WebElement parametresSystemButton ;
 * */
	
	@FindBy(id="configurationHsmForm:j_id88_lbl")
	WebElement configurationHSMButton;	
	@FindBy(id="configurationHsmForm:j_id147_lbl")
	WebElement configurationHSMNSieldButton;
	
	@FindBy(id="configurationHsmForm:j_id147_lbl")
	WebElement institutionSelector;	
	
	public ACSConfigurationHSM(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public static ACSConfigurationHSM using(WebDriver driver) {
		return new ACSConfigurationHSM(driver);
	}
	
}
