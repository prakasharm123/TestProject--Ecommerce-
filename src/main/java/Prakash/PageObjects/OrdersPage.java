package Prakash.PageObjects;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


import Prakash.AbstractComponents.AbstractComponent;

public class OrdersPage extends AbstractComponent {
	WebDriver driver;
	
	//Constructor
	public OrdersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	//Constructor
	
//	wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("table tbody th")));
// 	Assert.assertEquals(productId, driver.findElement(By.cssSelector("table tbody th")).getText().trim());
// 	Assert.assertEquals(product, driver.findElement(By.cssSelector("table tbody td:nth-child(3)")).getText());
//	
//	driver.findElement(By.cssSelector("button[class*='danger']")).click();
//	wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".mt-4")));
	
	
	
	
	//pageFactory Elements
	
	By id = By.cssSelector("table tbody th");
	@FindBy(css="table tbody th")
	List<WebElement> productId;
	
	@FindBy(css="table tbody td:nth-child(3)")
	List<WebElement> product;
	
	
	
	
	
	
	//pageFactory methods
	
	//By Elements

	
	//By Elements
	
	//Action methods
	public boolean verifyProductId(String productId2) {
		//return productId.getText().trim();
		boolean matchId = productId.stream().anyMatch(product_id->product_id.getText().trim().equalsIgnoreCase(productId2));
		System.out.println("product id "+matchId);
		return matchId;
	}
	
	public boolean verifyProductName(String productName) {
		boolean matchProduct = product.stream().anyMatch(prod->prod.getText().equalsIgnoreCase(productName));
		System.out.println("product name "+matchProduct);
		return matchProduct;
		
	}
	
	//Action methods
	
	
	
	
	
	
	
	

}
