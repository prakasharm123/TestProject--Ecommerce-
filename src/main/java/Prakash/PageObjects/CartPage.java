package Prakash.PageObjects;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import Prakash.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent{
	WebDriver driver;
	
	//Constructor
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	//Constructor
	
//	List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
//	Boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(addedProduct));
//	Assert.assertTrue(match);
	
	
	
	//pageFactory Elements
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	
	
	
	@FindBy(css=".subtotal button")
	WebElement total;
	
	By payment_page = By.cssSelector(".payment__shipping");
	
	//pageFactory methods
	
	//By Elements

	
	//By Elements
	
	//Action methods
	
	public Boolean verifyAddedProductOnCart(String product) {
		Boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(product));
		return match;
	}
	
	
	public ShippingPage clickOnCheckOut() {
		total.click();
		waitForElementToAppear(payment_page);
		ShippingPage shippingPage = new ShippingPage(driver);
		return shippingPage;
	}
	
	//Action methods
	
	
	
	
	
	
	
	

}
