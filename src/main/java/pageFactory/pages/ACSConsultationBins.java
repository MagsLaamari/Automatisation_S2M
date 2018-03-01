package pageFactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ACSConsultationBins {
	
	WebDriver driver;
	@FindBy(xpath="//*[@id=\"binListForm:j_id79_body\"]/a[1]/img")
	WebElement ajoutButton;
	
	public ACSConsultationBins(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void ClickAjouterBin() {
		this.ajoutButton.click();
	}
	
}
