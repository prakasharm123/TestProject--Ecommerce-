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

public class ShippingPage extends AbstractComponent{
	WebDriver driver;
	
	//Constructor
	public ShippingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	//Constructor

	
	
	
	
	//pageFactory Elements
	@FindBy(css=".user__name input")
	WebElement userId;
	
	@FindBy(css=".user__address input")
	WebElement selCountry;
	
	
	@FindBy(xpath="//button[2]//span[contains(text(),'India')]")
	WebElement countryEle;
	
	@FindBy(css=".details__user a")
	WebElement placeorder;
	
	@FindBy(css="section .ta-item")
	List<WebElement> allOptions;
	
	//pageFactory methods
	
	//By Elements

	
	//By Elements
	
	//Action methods
	
	public  void selectCountry(String country)
	{
		Actions action = new Actions(driver);
		action.sendKeys(selCountry, country).build().perform();
		for(WebElement el:allOptions) {
            if(el.getText().contentEquals(country)) {
                  el.click();
            	}
			}	
	}
	
	public OrderConfirmaion placeOrder() {
		placeorder.click();
		OrderConfirmaion orderConfirmation = new OrderConfirmaion(driver);
		return orderConfirmation;
	}
	//Action methods
	
	
	
	
	
	
	
	

}
