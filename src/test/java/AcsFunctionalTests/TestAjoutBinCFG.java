package AcsFunctionalTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageFactory.pages.ACSAccueil;
import pageFactory.pages.ACSConsultationBins;
import pageFactory.pages.ACSLogin;
import pageFactory.pages.ACSNouveauBIN;

public class TestAjoutBinCFG {
	
	public String Url ="";
	public String driverPath = "";	
    public WebDriver driver ; 
    ACSAccueil userAccueil = null;
    ACSConsultationBins consultation = null;
    ACSNouveauBIN nouveauBin = null;
    Properties prop = new Properties();
	InputStream input = null;

	  @BeforeTest
	  public void beforeTest() {
			try {
				// chemin du fichier properties :
				input = new FileInputStream("/Users/majda/eclipse-workspace/Automatisation_Take1/src/test/resources/connection.properties");
				prop.load(input);
				//Configuration du driver google chrome
				Url = prop.getProperty("Url");
				driverPath=  prop.getProperty("driverPath");
				System.setProperty(prop.getProperty("chrome"), prop.getProperty("cheminChrom"));
				driver = new ChromeDriver();
				driver.get(Url);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	  }

	  @AfterTest
	  public void afterTest() throws InterruptedException {
		  Thread.sleep(5000);
		  driver.close();
		  System.out.println("After test");
	  }

	  
	  @BeforeMethod
	  public void A_initialisation() {
		  userAccueil = new ACSAccueil(driver); 
		  System.out.println("Testing the login page");
		  ACSLogin userLogin = new ACSLogin(driver);
		  userLogin.LoginToAcs("aabaoubida","anas2019");
		  Assert.assertEquals(prop.getProperty("UrlAccueil"), driver.getCurrentUrl());
	  }
	  
	  
	  
	  //Tests ACSNouveauBIN :
	  @BeforeMethod
	  public void B_initialisationConsultationBins() {
		  consultation = new ACSConsultationBins(driver);
		  nouveauBin = new ACSNouveauBIN(driver);
	  }
	  //@Test  (priority = 20, enabled=true)
	  @BeforeMethod
	  public void ClickAjouterBin() {
		  userAccueil.ClickBinButton();
		  consultation.ClickAjouterBin();
		  Assert.assertEquals(prop.getProperty("UrlNouveauBin"), driver.getCurrentUrl());
	  }
	  @Test (priority = 25,enabled=false)
	  public void Retour() throws InterruptedException {
		  System.out.println("Retour test");
		  JavascriptExecutor executor = (JavascriptExecutor) driver;
		  nouveauBin.ClickRetourButton(executor);
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  driver.navigate().refresh();
		  System.out.println("Url existant : " + driver.getCurrentUrl() +" Le titre est : " + driver.getTitle());
		  Assert.assertEquals(prop.getProperty("UrlBinList"), driver.getCurrentUrl());
		  // it works but it gives a wrong url 
	  }
	  
	  
	  @Test (priority = 31, enabled= false)
	  public void AjouterBin() throws InterruptedException, IOException {
		  nouveauBin = new ACSNouveauBIN(driver);
		  nouveauBin.AjouterSimpleBin();
		  System.out.println("bin ajouté");

	  }
	  
	  @Test (priority = 31 ,  enabled= true)
	  public void AjouterAllBins() throws InterruptedException, IOException {
		  nouveauBin = new ACSNouveauBIN(driver);
		  nouveauBin.AjouterAllBins();
		  System.out.println("bin ajouté");

	  }
	  /*
	  @AfterMethod
	  public void GoToAjouterBin() {
		  userAccueil.ClickBinButton();
		  consultation.ClickAjouterBin();
		  Assert.assertEquals(prop.getProperty("UrlNouveauBin"), driver.getCurrentUrl());
	  }

*/
	  
}
