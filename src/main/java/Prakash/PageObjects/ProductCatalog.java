package Prakash.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Prakash.AbstractComponents.AbstractComponent;

public class ProductCatalog extends AbstractComponent{
	WebDriver driver;
	
	//Constructor
	public ProductCatalog(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	//Constructor
	
	//pageFactory Elements
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	@FindBy(id="toast-container")
	WebElement tostMessage1;
	//pageFactory methods
	
	//By Elements
	By productBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By tostMessage = By.id("toast-container");
	
	//By Elements
	
	//Action methods
	public List<WebElement> getProductList() {
		waitForElementToAppear(productBy);
		return products;
		
	}
	
	public WebElement getProductByName(String productName) {
		WebElement prod = getProductList().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String productName) throws InterruptedException {
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();
		Thread.sleep(3000);
//		waitForElementToDisappear(spinner);
//		waitForElementToAppear(tostMessage);
//		waitForElementToDisappear(tostMessage1);
	}
	//Action methods
	
	
	
	
	
	
	
	

}
