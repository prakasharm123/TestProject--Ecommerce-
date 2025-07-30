package Prakash.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Prakash.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	WebDriver driver;
	
	//Constructor
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	//Constructor
	
	
	//pageFactory methods
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement login;
	
	@FindBy(css="div[class*='flyInOut']")
	WebElement errorMessage;
	
	
	
	//pageFactory methods
	
	
	//Action methods
	
	public ProductCatalog loginApplication(String email, String password) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		login.click();
		ProductCatalog productCatalog = new ProductCatalog(driver);
		return productCatalog;
		
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
		
	}
	
	
	public String getErrorMessage() {
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	
	
	//Action methods
	
	
	
	
	
	
	
	

}
