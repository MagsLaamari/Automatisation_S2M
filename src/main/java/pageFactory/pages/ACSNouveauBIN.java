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
	private  ArrayList<ArrayList<String>> listOfNewBins = new ArrayList<>() ; 
	
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
	@FindBy(name="newBinForm:j_id249")
	WebElement modeDegradee ;
	
	
	@FindBy(linkText="Enregistrer")
	WebElement BtnEnregistrer;
	
	@FindBy(id="newBinForm:j_id302")
	WebElement BtnRetour;

	
	// Web Elements that appear : 
	 //if we choose type mdp Software /  Mobile-Token
	WebElement parametreSMSGateway;
	WebElement modeEnvoi;
	WebElement longueurOTPSoft;
	WebElement dureeVieOTP;
	 // if We check mode degradé : 
	WebElement typeDegradage;
	   // if We choose the type of degradage Simple / Email : 
	WebElement periodicite;
	WebElement montantCumulAutorisee;
	WebElement transactionAutorisee;
	   // if We choose the type of degradage svi:
	WebElement dureeAvantActivationSVI;
	WebElement textLienSVI;
	

	public ACSNouveauBIN(WebDriver driver) {
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
		cvkLMK.selectByVisibleText(cVKsousLMK);
		System.out.println("set CVK sous LMK : " + this.CVKsousLMK.getText());
	}
	public void setModeDegradee() {
		JavascriptExecutor exec =(JavascriptExecutor) driver;
		exec.executeScript("arguments[0].click();", this.modeDegradee);
	}	
	public void setTypeVerificationEnrolement(String verificationEnrolement) {	
		Select typeVerification = new Select(this.typeVerificationEnrolement);
		typeVerification.selectByVisibleText(verificationEnrolement);
	}
	public void setBtnEnregistrer() {
		JavascriptExecutor exec =(JavascriptExecutor) driver;
		exec.executeScript("arguments[0].click();", this.BtnEnregistrer);
		System.out.println("btn clicked");
	}	
	public void setBtnRetour() {
		this.BtnRetour.click();
	}
	public void setDureeAvantActivationSVI(String dureeAvantActivationSVI) {
		this.dureeAvantActivationSVI = driver.findElement(By.id("newBinForm:sviActivationTimeId"));
		this.dureeAvantActivationSVI.sendKeys(dureeAvantActivationSVI);
	}
	public void setTextLienSVI(String textLienSVI) {
		this.textLienSVI = driver.findElement(By.name("newBinForm:j_id271"));
		this.textLienSVI.sendKeys(textLienSVI);
	}
	public void setTypeDegradage(String typeDegradage) {
		this.typeDegradage = driver.findElement(By.name("newBinForm:j_id256"));
		System.out.println("element found");
		Select typeDeg = new Select(this.typeDegradage);
		typeDeg.selectByVisibleText(typeDegradage);
	}
	public void setPeriodicite(String periodicite) {
		this.periodicite = driver.findElement(By.id("newBinForm:periodicity"));
		Select per = new Select(this.periodicite);
		per.selectByVisibleText(periodicite);
	}
	public void setMontantCumulAutorisee(String montantCumulAutorisee) {
		this.montantCumulAutorisee = driver.findElement(By.id("newBinForm:amount"));
		this.montantCumulAutorisee.sendKeys(montantCumulAutorisee);
	}
	public void setTransactionAutorisee(double transactionAutorisee) {
		this.transactionAutorisee = driver.findElement(By.id("newBinForm:passAllow"));
		this.transactionAutorisee.sendKeys(""+(int)transactionAutorisee);
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

	public ArrayList<ArrayList<String>> getListOfNewBins() {
		return listOfNewBins;
	}
	public void setListOfNewBins(ArrayList<ArrayList<String>> listOfNewBins) {
		this.listOfNewBins = listOfNewBins;
	}
	/// Setters of the elements that appear after selecting Software or mobile token 
	public void setParametreSMSGateway(String parametreSMSGateway) {
		this.parametreSMSGateway = 	driver.findElement(By.id("newBinForm:typeSmsGateWay"));
		Select parametreSMSG = new Select(this.parametreSMSGateway);
		parametreSMSG.selectByVisibleText(parametreSMSGateway);
	}
	public void setModeEnvoi(String modeEnvoi) {
		this.modeEnvoi = driver.findElement(By.name("newBinForm:j_id211"));
		Select modeEnv = new Select(this.modeEnvoi);
		modeEnv.selectByVisibleText(modeEnvoi);
	}
	public void setLongueurOTPSoft(String longueurOTPSoft) {
		this.longueurOTPSoft = driver.findElement(By.id("newBinForm:otpSoftLenId"));
		Select longuerOTp = new Select(this.longueurOTPSoft);
		longuerOTp.selectByVisibleText(longueurOTPSoft);
	}
	public void setDureeVieOTP(String dureeVieOTP) {
		this.dureeVieOTP = driver.findElement(By.id("newBinForm:otpLifeTimeId"));
		this.dureeVieOTP.sendKeys(dureeVieOTP);
	}
	///
	public void ClickRetourButton(JavascriptExecutor executor) {
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", this.BtnRetour);
	}
	
	public void initialisation() throws IOException {
		NouveauBin b = new NouveauBin();
	//	this.setNewBin( b.readXslxFile("/Users/majda/eclipse-workspace/Automatisation_Take1/src/main/resources/New_Bin_1.xlsx"));	
		b.readAllXslxFile("/Users/majda/eclipse-workspace/Automatisation_Take1/src/main/resources/New_Bin_1.xlsx");
		this.setListOfNewBins(b.getAllValues());
	}


	public void initialisation1Bin() throws IOException {
		NouveauBin b = new NouveauBin();
		this.setNewBin( b.readXslxFile("/Users/majda/eclipse-workspace/Automatisation_Take1/src/main/resources/New_Bin_1.xlsx"));	
	}

	public void AjouterAllBins() throws InterruptedException, IOException{
		this.initialisation();
		for(ArrayList<String> inside: this.listOfNewBins) {
			ArrayList<String> list = inside;
			System.err.println(inside);
			AjouterBin(list);
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		}
	}
	
	
	private void AjouterBin(ArrayList<String> bin) throws IOException {
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		   // for its presence once every 5 seconds.
		   Wait<WebDriver> fluantWait = new FluentWait<WebDriver>(driver)
		       .withTimeout(5, TimeUnit.SECONDS)
		       .pollingEvery(2, TimeUnit.SECONDS)
		       .ignoring(NoSuchElementException.class);
		//driver.navigate().refresh();	
		this.setInstitution(bin.get(0));
		System.out.println("test test bin.get(0) : "+bin.get(0));
		//wait for the page to load the element 	Type Vérification de l'enrôlement
		wait.until(ExpectedConditions.visibilityOf(typeVerificationEnrolement));	
		this.setIdentifiant(bin.get(1));
		this.setLabel(bin.get(2));
		this.setLongueur(  Double.parseDouble(bin.get(3)));
		this.setRangeeMAX( Double.parseDouble(bin.get(4)));
		this.setRangeeMIN( Double.parseDouble(bin.get(5)));
		this.setStatut(bin.get(6));
		this.setTypeVerificationEnrolement(bin.get(7));
		this.setSystemDePaiement(bin.get(8));
		this.setTypeMotPasse(bin.get(9));
		
		// des cas : 
		if(bin.get(9).equalsIgnoreCase("Software") || bin.get(9).equalsIgnoreCase("Mobile-Token")) {
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			this.setParametreSMSGateway(bin.get(12));
			// les cas : 
			if(bin.get(12).equalsIgnoreCase("SMPP") ) {
				driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS) ;
				JavascriptExecutor exec =(JavascriptExecutor) driver;
				WebElement element = driver.findElement(By.linkText(bin.get(20)));										
				exec.executeScript("arguments[0].click();", element);
			}else if(bin.get(12).equalsIgnoreCase("Service Web SMS") ) {
				driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS) ;
				JavascriptExecutor exec =(JavascriptExecutor) driver;
			//	WebElement quittere = driver.findElement(By.id("newBinForm:PopupHideId"));
				WebElement elementt = driver.findElement(By.linkText(bin.get(20)));										
				exec.executeScript("arguments[0].click();", elementt);
			}			
			driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS) ;		
			this.setModeEnvoi(bin.get(13));
			this.setLongueurOTPSoft(bin.get(14));
			this.setDureeVieOTP(bin.get(15));
		}	
		this.setCVKsousLMK(bin.get(10));
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
		if(bin.get(11).equalsIgnoreCase("Yes")) {
			this.setModeDegradee();
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			System.out.println("after tha waiiit");
			this.setTypeDegradage(bin.get(16));
			if(bin.get(16).equalsIgnoreCase("Simple") || bin.get(16).equalsIgnoreCase("Email")) {
				this.setPeriodicite(bin.get(17));
				this.setMontantCumulAutorisee(bin.get(18));
				this.setTransactionAutorisee(Double.parseDouble(bin.get(19)));
			}else if(bin.get(16).equalsIgnoreCase("SVI")) {
				this.setDureeAvantActivationSVI(bin.get(17));
				this.setTextLienSVI(bin.get(18));
			}
		}
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS) ;
		System.out.println("waiting for 2s");
		//	this.BtnEnregistrer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newBinForm:cvkA")));	
			this.setBtnEnregistrer();
			JavascriptExecutor exec =(JavascriptExecutor) driver;
			exec.executeScript("arguments[0].click();", driver.findElement(By.id("binListForm:showPanelId")));
		    ACSConsultationBins consultation = new ACSConsultationBins(driver);
		    consultation.ClickAjouterBin();
	}
	
// This is working : 
	public void AjouterSimpleBin() throws IOException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		   // for its presence once every 5 seconds.
		   Wait<WebDriver> fluantWait = new FluentWait<WebDriver>(driver)
		       .withTimeout(5, TimeUnit.SECONDS)
		       .pollingEvery(2, TimeUnit.SECONDS)
		       .ignoring(NoSuchElementException.class);

		this.initialisation1Bin();
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
		
		// des cas : 
		if(this.newBin.get(9).equalsIgnoreCase("Software") || this.newBin.get(9).equalsIgnoreCase("Mobile-Token")) {
		//	wait.until(ExpectedConditions.visibilityOf(parametreSMSGateway));	
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			this.setParametreSMSGateway(this.newBin.get(12));
				// les cas : 
				if(this.newBin.get(12).equalsIgnoreCase("SMPP") ) {
					driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS) ;
					JavascriptExecutor exec =(JavascriptExecutor) driver;
					WebElement element = driver.findElement(By.linkText(this.newBin.get(20)));										
					exec.executeScript("arguments[0].click();", element);
				}else if(this.newBin.get(12).equalsIgnoreCase("Service Web SMS") ) {
					driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS) ;
					JavascriptExecutor exec =(JavascriptExecutor) driver;
				//	WebElement quittere = driver.findElement(By.id("newBinForm:PopupHideId"));
					WebElement elementt = driver.findElement(By.linkText(this.newBin.get(20)));										
					exec.executeScript("arguments[0].click();", elementt);
				}
			driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS) ;
			this.setModeEnvoi(this.newBin.get(13));
			this.setLongueurOTPSoft(this.newBin.get(14));
			this.setDureeVieOTP(this.newBin.get(15));
		}	
		this.setCVKsousLMK(this.newBin.get(10));
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
		if(this.newBin.get(11).equalsIgnoreCase("Yes")) {
			this.setModeDegradee();
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			System.out.println("after tha waiiit");

			
			this.setTypeDegradage(this.newBin.get(16));
			if(this.newBin.get(16).equalsIgnoreCase("Simple") || this.newBin.get(16).equalsIgnoreCase("Email")) {
				this.setPeriodicite(this.newBin.get(17));
				this.setMontantCumulAutorisee(this.newBin.get(18));
				this.setTransactionAutorisee(Double.parseDouble(this.newBin.get(19)));
			}else if(this.newBin.get(16).equalsIgnoreCase("SVI")) {
				this.setDureeAvantActivationSVI(this.newBin.get(17));
				this.setTextLienSVI(this.newBin.get(18));
			}
		}
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS) ;
		System.out.println("waiting for 2s");
			//this.BtnEnregistrer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newBinForm:cvkA")));
			this.setBtnEnregistrer();
	}
}
