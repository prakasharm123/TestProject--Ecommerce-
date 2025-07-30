package Prakash.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Prakash.PageObjects.CartPage;
import Prakash.PageObjects.LandingPage;
import Prakash.PageObjects.OrderConfirmaion;
import Prakash.PageObjects.OrdersPage;
import Prakash.PageObjects.ProductCatalog;
import Prakash.PageObjects.ShippingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.reactivex.rxjava3.functions.Action;

public class AddProductsToCart {

	public static void main(String[] args) throws InterruptedException {
		String addedProduct = "ADIDAS ORIGINAL";
		String userId = "sharmaprakash1234321@gmail.com";
		String password = "Durga111@";
		String userCountry = "India";
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		LandingPage landingpage = new LandingPage(driver);
		landingpage.goTo();
		ProductCatalog productCatalog = landingpage.loginApplication(userId, password);
		productCatalog.addProductToCart(addedProduct);
		CartPage cartPage = productCatalog.goToCartPage();
		Assert.assertTrue(cartPage.verifyAddedProductOnCart(addedProduct));
		ShippingPage shippingPage = cartPage.clickOnCheckOut();
		shippingPage.selectCountry(userCountry);
		OrderConfirmaion orderconfirmation = shippingPage.placeOrder();
		Assert.assertEquals(orderconfirmation.checkOrderConfirmationMessage(),"THANKYOU FOR THE ORDER.");
		String order_id = orderconfirmation.getProductId();
		String order_name = orderconfirmation.getProductName();
		OrdersPage orderPage = orderconfirmation.goToOrdersPage();
		Assert.assertTrue(orderPage.verifyProductId(order_id));
		Assert.assertTrue(orderPage.verifyProductName(order_name));
		orderPage.logOut();
		driver.quit();
		
	//  driver.findElement(By.xpath("//section[@id='products']//div[@class='row']//div[@class='card']//div[@class='card-body']//h5//b[text()='ADIDAS ORIGINAL']//..//..//button//i[contains(@class,'cart')]")).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tost-container")));
		//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
//		WebElement productAddedToCart = driver.findElement(By.cssSelector("div[aria-label='Product Added To Cart']"));
//		Assert.assertTrue(productAddedToCart);
		
		
		
		 
		
		
	
		
		
	    // confirmation page 
		//label[class="ng-star-inserted"]  - order id
		//td[class*='m-3'] div[class='title'] - ordered product
		
//		String productId = driver.findElement(By.cssSelector("label[class='ng-star-inserted']")).getText().replace("|", "").trim();
//	
//		String product = driver.findElement(By.cssSelector("td[class*='m-3'] div[class='title']")).getText();
//		System.out.println(product +", "+productId);
		
		//order history page 
		//table tbody th - order id
		//table tbody td:nth-child(3) - ordered product
//		driver.findElement(By.cssSelector("button[routerlink*='myorders']")).click();
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("table tbody th")));
//	 	Assert.assertEquals(productId, driver.findElement(By.cssSelector("table tbody th")).getText().trim());
//	 	Assert.assertEquals(product, driver.findElement(By.cssSelector("table tbody td:nth-child(3)")).getText());		
		//driver.findElement(By.cssSelector("button[class*='danger']")).click();
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".mt-4")));
//		driver.findElement(By.cssSelector("i[class*='trash']")).click();
		
		
		

	}

}
