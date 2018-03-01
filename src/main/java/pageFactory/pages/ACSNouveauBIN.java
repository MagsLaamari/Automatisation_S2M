package pageFactory.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.NoSuchElementException;
import java.util.function.Function;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import traitement.NouveauBin;

public class ACSNouveauBIN {
	WebDriver driver;
	ArrayList<String> newBin ;
	
	@FindBy(id="newBinForm:institution")
	WebElement institution ;
	@FindBy(id="newBinForm:identifier")
	WebElement identifiant ;
	@FindBy(id="newBinForm:name")
	WebElement label ;
	@FindBy(id="newBinForm:binLength")
	WebElement longueur ;
	@FindBy(id="newBinForm:rangeMax")
	WebElement rangeeMAX ;
	@FindBy(id="newBinForm:rangeMin")
	WebElement rangeeMIN ;
	@FindBy(id="newBinForm:status")
	WebElement statut ;
	@FindBy(id="newBinForm:verifyEnrolType")
	WebElement typeVerificationEnrolement ; ///////CGF
	@FindBy(id="newBinForm:paymScheme")
	WebElement systemDePaiement ;
	@FindBy(id="newBinForm:typePassId")
	WebElement typeMotPasse ;
	@FindBy(id="newBinForm:cvkUnderLmk")
	WebElement CVKsousLMK ;	
	@FindBy(xpath="//*[@id=\"newBinForm:panelInstitution\"]/tbody/tr[12]/td[3]/input")
	WebElement modeDegradee ;
	@FindBy(linkText="Enregistrer")
	WebElement BtnEnregistrer;
	
	@FindBy(id="newBinForm:j_id302")
	WebElement BtnRetour;

	JavascriptExecutor executor;

	public ACSNouveauBIN(WebDriver driver) {
		this.executor = (JavascriptExecutor) driver;
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void setInstitution(String institution) {
		Select institut = new Select(this.institution);
		institut.selectByVisibleText(institution);
	}
	public void setIdentifiant(String identifiant) {
		this.identifiant.sendKeys(identifiant);
	}
	public void setLabel(String label) {
		this.label.sendKeys(label);
	}
	public void setLongueur(double longueur) {
		this.longueur.sendKeys(""+(int)longueur);
	}
	public void setRangeeMAX(double rangeeMAX) {
		this.rangeeMAX.sendKeys(""+(int)rangeeMAX);
	}
	public void setRangeeMIN(double rangeeMIN) {
		this.rangeeMIN.sendKeys(""+(int)rangeeMIN);
	}
	public void setStatut(String statut) {
		Select statutt = new Select(this.statut);
		statutt.selectByVisibleText(statut);
		
	}
	public void setSystemDePaiement(String systemDePaiement) {
		Select syst = new Select(this.systemDePaiement);
		syst.selectByVisibleText(systemDePaiement);
	}
	public void setTypeMotPasse(String typeMotPasse) {
		Select typeMdp = new Select(this.typeMotPasse);
		typeMdp.selectByVisibleText(typeMotPasse);
	}
	public void setCVKsousLMK(String cVKsousLMK) {
		Select cvkLMK = new Select(this.CVKsousLMK);
		//cvkLMK.selectByValue(cVKsousLMK);
		cvkLMK.selectByVisibleText(cVKsousLMK);
		System.out.println("set CVK sous LMK : " + this.CVKsousLMK.getText());
	}
	public void setModeDegradee(String modeDegradee) {
		this.modeDegradee.click();
	}	
	public void setTypeVerificationEnrolement(String verificationEnrolement) {	
		Select typeVerification = new Select(this.typeVerificationEnrolement);
		typeVerification.selectByVisibleText(verificationEnrolement);
	}
	
	public void setBtnEnregistrer() throws InterruptedException {
		BtnEnregistrer.findElement(By.xpath("//a[text()='Enregistrer']"));
		System.out.println("bouton texttttt : " + this.BtnEnregistrer.getClass());
		this.BtnEnregistrer.submit();
		
		System.out.println("btn clicked");
	}
	
	public void setBtnRetour() {
		this.BtnRetour.click();
	}

	public String getCVkValeur() {
		return	this.CVKsousLMK.getText();
	}
	
	
	
	public ArrayList<String> getNewBin() {
		return newBin;
	}
	public void setNewBin(ArrayList<String> newBin) {
		this.newBin = newBin;
	}

	
	
	
	public void initialisation() throws IOException {
		NouveauBin b = new NouveauBin();
		this.setNewBin( b.readXslxFile("/Users/majda/eclipse-workspace/Automatisation_Take1/src/main/resources/New_Bin_1.xlsx"));
	}

	
	
	public void AjouterBin() throws InterruptedException, IOException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		   // for its presence once every 5 seconds.
		   Wait<WebDriver> fluantWait = new FluentWait<WebDriver>(driver)
		       .withTimeout(5, TimeUnit.SECONDS)
		       .pollingEvery(2, TimeUnit.SECONDS)
		       .ignoring(NoSuchElementException.class);

		this.initialisation();
		this.setInstitution(this.newBin.get(0));
		//wait for the page to load the element 	Type Vérification de l'enrôlement
		wait.until(ExpectedConditions.visibilityOf(typeVerificationEnrolement));	
		System.out.println("we waited and it appeared 1");
		this.setIdentifiant(this.newBin.get(1));
		this.setLabel(this.newBin.get(2));
		this.setLongueur(  Double.parseDouble(this.newBin.get(3)));
		this.setRangeeMAX( Double.parseDouble(this.newBin.get(4)));
		this.setRangeeMIN( Double.parseDouble(this.newBin.get(5)));
		this.setStatut(this.newBin.get(6));
		this.setTypeVerificationEnrolement(this.newBin.get(7));
		this.setSystemDePaiement(this.newBin.get(8));		
		this.setTypeMotPasse(this.newBin.get(9));
		this.setCVKsousLMK(this.newBin.get(10));
	
		System.out.println(CVKsousLMK.getText());
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		
		//this.BtnEnregistrer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newBinForm:cvkB")));
		
		// Thread.sleep(2000);
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		 		 
		// tha wait :
		   CVKsousLMK  = fluantWait.until(new Function<WebDriver, WebElement>() {
			     public WebElement apply(WebDriver driver) {
				       if(getCVkValeur().equalsIgnoreCase("CFG CVK KEY")) {
				    	   System.out.println("valeur = cvk ");
				    	   return CVKsousLMK;
				       }
				       else {
				    	   setCVKsousLMK("CFG CVK KEY");
				    	   System.out.println("valeur = NOOOT cvk ");
				    	   return null;
				       }		       
			     }
			   });
		
		////
		if(this.newBin.get(11).equals("Yes")) {
			this.setModeDegradee(this.newBin.get(11));
		}
		
			System.out.println("button value = " + this.BtnEnregistrer.getText());
			this.BtnEnregistrer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newBinForm:cvkA")));
			this.ClickEnregistrerButton();
	}
	
	
	
	public void ClickRetourButton() {
		executor.executeScript("arguments[0].click();", this.BtnRetour);
	}
	
	public void ClickEnregistrerButton() {
		executor.executeScript("arguments[0].click();", this.BtnEnregistrer);
	}

	
}
