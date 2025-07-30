package Prakash.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Prakash.PageObjects.CartPage;
import Prakash.PageObjects.OrdersPage;

public class AbstractComponent {
	
	WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//driver.findElement(By.xpath("//button[text()=' Sign Out ']")).click();
	
//	wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("table tbody th")));
	//page Factory
	@FindBy(xpath="//button[text()=' Sign Out ']")
	WebElement logout;
	
	@FindBy(css="button[routerlink*='myorders']")
	WebElement orders;
	
	@FindBy(css="button[routerlink*='dashboard/cart']")
	WebElement cart;
	
	By orderPage = By.cssSelector("table tbody th");
	//page Factory
	
	
	
	//Action methods
	public void waitForElementToAppear(By findBy) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	
	public void waitForWebElementToAppear(WebElement findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
		}
	
	public void waitForElementToDisappear(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(element));
		}
	
	public void waitForElementLocated(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(findBy));
	}
	
	public CartPage goToCartPage() {
		cart.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	
	public OrdersPage goToOrdersPage() {
		orders.click();
		waitForElementLocated(orderPage);
		OrdersPage orderPage = new OrdersPage(driver);
		return orderPage;
	}
	
	public void logOut() {
		logout.click();	
	}
	
	
	
	//Action methods
}
