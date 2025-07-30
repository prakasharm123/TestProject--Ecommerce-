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

public class OrderConfirmaion extends AbstractComponent{
	WebDriver driver;
	
	//Constructor
	public OrderConfirmaion(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	//Constructor
	
	
//	String productId = driver.findElement(By.cssSelector("label[class='ng-star-inserted']")).getText().replace("|", "").trim();
//	
//	String product = driver.findElement(By.cssSelector("td[class*='m-3'] div[class='title']")).getText();
//	System.out.println(product +", "+productId);
	
	
	
	//pageFactory Elements
	@FindBy(css="h1")
	WebElement orderConfirmationMessage;
	
	@FindBy(css="label[class='ng-star-inserted']")
	WebElement productId;
	
	@FindBy(css="td[class*='m-3'] div[class='title']")
	WebElement product;
	
	
	
	//pageFactory methods
	
	//By Elements

	
	//By Elements
	
	//Action methods
	
	public String checkOrderConfirmationMessage() {
		return orderConfirmationMessage.getText();
	}

	public String getProductId() {
		String product__id = productId.getText().replace("|", "").trim();
		System.out.println(product__id);
		return product__id;
		
	}
	
	public String getProductName() {
		return product.getText();
	}
	//Action methods
	
	
	
	
	
	
	
	

}
