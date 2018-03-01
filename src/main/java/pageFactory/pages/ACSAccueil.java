package pageFactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ACSAccueil {

	WebDriver driver;
	
	// Parametres du systeme : 
	@FindBy(id="iconj_id26:j_id28")
	WebElement parametresSystemButton ;
		// sous buttons parametres dy systeme :
		@FindBy(id="iconj_id26:j_id29")
		WebElement hsmButton ;
			// sous sous buttons : 
			@FindBy(id="iconj_id26:j_id30")
			WebElement configurationHsmButton ;	
			@FindBy(id="iconj_id26:j_id31")
			WebElement saisieCVKButton ;	
		
	// Gestion des institutions : 
	@FindBy(id="iconj_id26:j_id33")
	WebElement gestionInstitutionsButton ;
		// sous buttons : 
		@FindBy(id="iconj_id26:j_id34")
		WebElement institutionButton ;
		@FindBy(id="iconj_id26:j_id35")
		WebElement configurationButton ;
			//Sous sous configuration :
			@FindBy(id="iconj_id26:j_id36")
			WebElement acsConfigurationButton ;
			@FindBy(id="iconj_id26:j_id37")
			WebElement ahsConfigurationButton ;
		@FindBy(id="iconj_id26:j_id38")
		WebElement messageClientsButton ;
	
	//Enrolement :
	@FindBy(id="iconj_id26:j_id39")
	WebElement enrolementButton ;
		@FindBy(id="iconj_id26:j_id40")
		WebElement BinButton ;
		@FindBy(id="iconj_id26:j_id41")
		WebElement enrolementManuelButton ;		
		@FindBy(id="iconj_id26:j_id42")
		WebElement enrolementBatchButton ;
		@FindBy(id="iconj_id26:j_id44")
		WebElement cartesEnroleeButton ;		
		@FindBy(id="iconj_id26:j_id45")
		WebElement enrolementMobileButton ;
		@FindBy(id="iconj_id26:j_id46")
		WebElement mobileTokensEnroleeButton ;
		@FindBy(id="iconj_id26:j_id47")
		WebElement revoquerMobileButton ;
		@FindBy(id="iconj_id26:j_id48")
		WebElement historiqueEnrolementButton ;
	
	// Intégration fichier Ref-porteur
	@FindBy(id="iconj_id26:j_id50")
	WebElement integrationFichierRefButton1 ;
		@FindBy(id="iconj_id26:j_id51")
		WebElement integrationFichierRefButton2 ;	
	//Transaction ACS: 
	@FindBy(id="iconj_id26:j_id52")
	WebElement transactionACSButton ;
		@FindBy(id="iconj_id26:j_id53")
		WebElement vueGlobalButton ;
		@FindBy(id="iconj_id26:j_id55")
		WebElement transactionsCompletesButton ;		
		@FindBy(id="iconj_id26:j_id56")
		WebElement transactionsRejeteesButton ;
		@FindBy(id="iconj_id26:j_id57")
		WebElement transactionsIncompletesButton ;		
		@FindBy(id="iconj_id26:j_id59")
		WebElement historiqueSMSButton ;
	// Gestion des risques :
	@FindBy(id="iconj_id26:j_id68")
	WebElement gestionRisquesButton ;
		@FindBy(id="iconj_id26:j_id69")
		WebElement creationListeNoireIpsButton ;	
		@FindBy(id="iconj_id26:j_id70")
		WebElement consultationIpsBloqueeButton ;			
	// Gestion des canaux d'envoi : 
	@FindBy(id="iconj_id26:j_id60")
	WebElement gestionCanauxButton ;
		@FindBy(id="iconj_id26:j_id61")
		WebElement smsGatewayButton ;
			@FindBy(id="iconj_id26:j_id62")
			WebElement configurationServiceWebButton ;
			@FindBy(id="iconj_id26:j_id63")
			WebElement serveurSMPPButton ;
			@FindBy(id="iconj_id26:j_id64")
			WebElement configurationMessagesSMSButton ;
		@FindBy(id="iconj_id26:j_id65")
		WebElement mailGatewayButton ;
			@FindBy(id="iconj_id26:j_id66")
			WebElement configurationMailsButton ;
			@FindBy(id="iconj_id26:j_id67")
			WebElement configurationSMTPButton ;				
				
				
	public ACSAccueil(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	// Parametres systems methods:
	public void ClickParametresSysteme() {
		this.parametresSystemButton.click();
	}
	public void ClickHSMButton() {
		this.hsmButton.click();
	}
	public void ClickConfigurationHsmButton() {
		this.ClickParametresSysteme();
		this.ClickHSMButton();
		this.configurationHsmButton.click();
	}
	public void ClickSaisieCVKButton() {
		this.ClickParametresSysteme();
		this.ClickHSMButton();
		this.saisieCVKButton.click();
	}
	// Gestion des institutions methods:
	public void ClickGestionInstitutionsButton() {
		this.gestionInstitutionsButton.click();
	}
	public void ClickInstitutionButton() {
		this.ClickGestionInstitutionsButton();
		this.institutionButton.click();
	}
	public void ClickMessageClientsButton() {
		this.ClickGestionInstitutionsButton();
		this.messageClientsButton.click();
	}
	public void ClickConfigurationButton(){
		this.ClickGestionInstitutionsButton();
		this.configurationButton.click();
	}
	public void ClickAcsConfigurationButton() {
		this.ClickConfigurationButton();
		this.acsConfigurationButton.click();
	}
	public void ClickAhsConfigurationButton() {
		this.ClickConfigurationButton();
		this.ahsConfigurationButton.click();
	}
	// Enrolement :
	public void ClickEnrolementButton() {
		this.enrolementButton.click();
	}
	public void ClickBinButton() {
		this.ClickEnrolementButton();
		this.BinButton.click();
	}
	public void ClickEnrolementManuelButton() {
		this.ClickEnrolementButton();
		this.enrolementManuelButton.click();
	}
	public void ClickEnrolementBatchButton() {
		this.ClickEnrolementButton();
		this.enrolementBatchButton.click();
	}
	public void ClickCartesEnroleeButton() {
		this.ClickEnrolementButton();
		this.cartesEnroleeButton.click();
	}
	public void ClickEnrolementMobileTokenButton() {
		this.ClickEnrolementButton();
		this.enrolementMobileButton.click();
	}
	public void ClickMobileTokensEnroleeButton() {
		this.ClickEnrolementButton();
		this.mobileTokensEnroleeButton.click();
	}
	public void ClickRevoquerMobileButton() {
		this.ClickEnrolementButton();
		this.revoquerMobileButton.click();
	}
	public void ClickHistoriqueEnrolementButton() {
		this.ClickEnrolementButton();
		this.historiqueEnrolementButton.click();
	}
	// Intégration fichier Ref-porteur
	public void ClickIntegrationFichierRefButton1() {
		this.integrationFichierRefButton1.click();
	}
	public void ClickIntegrationFichierRefButton2() {
		this.ClickIntegrationFichierRefButton1();
		this.integrationFichierRefButton2.click();
	}
	// Gestion des risques : 
	public void ClickGestionDuRisqueButton() {
		this.gestionRisquesButton.click();
	}
	public void ClickCreationListeNoireIpsButton() {
		this.ClickGestionDuRisqueButton();
		this.creationListeNoireIpsButton.click();
	}
	
	public void ClickConsultationIpsBloqueeButton() {
		this.ClickGestionDuRisqueButton();
		this.consultationIpsBloqueeButton.click();
	}
	
	// Transaction ACS : 
	public void ClickTransactionACSButton() {
		this.transactionACSButton.click();
	}
	public void ClickVueGlobalButton() {
		this.ClickTransactionACSButton();
		this.vueGlobalButton.click();
	}
	public void ClickTransactionsCompletesButton() {
		this.ClickTransactionACSButton();
		this.transactionsCompletesButton.click();
	}
	public void ClickTransactionsRejeteesButton() {
		this.ClickTransactionACSButton();
		this.transactionsRejeteesButton.click();
	}
	public void ClickTransactionsIncompletesButton() {
		this.ClickTransactionACSButton();
		this.transactionsIncompletesButton.click();
	}
	public void ClickHistoriqueSMSButton() {
		this.ClickTransactionACSButton();
		this.historiqueSMSButton.click();
	}
	
	// Gestion des canaux d'envoi : 
	public void ClickGestionCanauxButton() {
		this.gestionCanauxButton.click();
	}
	public void ClickSmsGatewayButton() {
		this.ClickGestionCanauxButton();
		this.smsGatewayButton.click();
	}
	public void ClickConfigurationServiceWebButton() {
		this.ClickSmsGatewayButton();
		this.configurationServiceWebButton.click();
	}
	public void ClickServeurSMPPButton() {
		this.ClickSmsGatewayButton();
		this.serveurSMPPButton.click();
	}
	public void ClickConfigurationMessagesSMSButton() {
		this.ClickSmsGatewayButton();
		this.configurationMessagesSMSButton.click();
	}
	public void ClickMailGatewayButton() {
		this.ClickGestionCanauxButton();
		this.mailGatewayButton.click();
	}
	public void ClickConfigurationMailsButton() {
		this.ClickMailGatewayButton();
		this.configurationMailsButton.click();
	}
	public void ClickConfigurationSMTPButton() {
		this.ClickMailGatewayButton();
		this.configurationSMTPButton.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



}
