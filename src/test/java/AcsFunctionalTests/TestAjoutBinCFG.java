package AcsFunctionalTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
		  Thread.sleep(10000);
		  driver.close();
		  System.out.println("After test");
	  }

	  

	  @Test  (priority = 0)
	  public void testLoginPage() {
		  System.out.println("Testing the login page");
		  ACSLogin userLogin = new ACSLogin(driver);
		  userLogin.LoginToAcs("aabaoubida","anas2019");
		  Assert.assertEquals(prop.getProperty("UrlAccueil"), driver.getCurrentUrl());

	  }
	  
	  
	  @BeforeMethod
	  public void initialisation() {
		  userAccueil = new ACSAccueil(driver); 
	  }
	  
	  
	  
	  //Tests ACSNouveauBIN :
	  @BeforeMethod
	  public void initialisationConsultationBins() {
		  consultation = new ACSConsultationBins(driver);
		  nouveauBin = new ACSNouveauBIN(driver);
	  }
	  @Test  (priority = 20)
	  public void ClickAjouterBin() {
		  userAccueil.ClickBinButton();
		  consultation.ClickAjouterBin();
		  Assert.assertEquals(prop.getProperty("UrlNouveauBin"), driver.getCurrentUrl());
	  }
	  @Test (priority = 25)
	  public void Retour() throws InterruptedException {
		  System.out.println("Retour test");
		  nouveauBin.ClickRetourButton();
		  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		  Assert.assertEquals(prop.getProperty("UrlBinList"), driver.getCurrentUrl());
	  }
	  
	  
	  @Test (priority = 31, enabled=false)
	  public void AjouterBin() throws InterruptedException, IOException {
		  nouveauBin = new ACSNouveauBIN(driver);
		  nouveauBin.AjouterBin();
		  Thread.sleep(3000);
		  System.out.println("bin ajouté");

	  }
	  

	  
}
