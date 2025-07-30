package Prakash.tests;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Prakash.PageObjects.CartPage;
import Prakash.PageObjects.LandingPage;
import Prakash.PageObjects.OrderConfirmaion;
import Prakash.PageObjects.OrdersPage;
import Prakash.PageObjects.ProductCatalog;
import Prakash.PageObjects.ShippingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.reactivex.rxjava3.functions.Action;
import testComponents.BaseTest;


public class AddProductToCart extends BaseTest {
		String order_id_first;
		String order_name_first;
		String order_id_second;
		String order_name_second;
		
		@Test(dataProvider = "getData1",groups = {"purchase"})
		public void submitOrderTest(HashMap<String, String> input) throws InterruptedException, IOException{
//		String addedProduct = "ADIDAS ORIGINAL";
//		String userId = "sharmaprakash1234321@gmail.com";
//		String password = "Durga111@";
		String userCountry = "India";
		ProductCatalog productCatalog = landingPage.loginApplication(input.get("userId"), input.get("password"));
		productCatalog.addProductToCart(input.get("addedProduct"));
		CartPage cartPage = productCatalog.goToCartPage();
		Assert.assertTrue(cartPage.verifyAddedProductOnCart(input.get("addedProduct")));
		ShippingPage shippingPage = cartPage.clickOnCheckOut();
		shippingPage.selectCountry(userCountry);
		OrderConfirmaion orderconfirmation = shippingPage.placeOrder();
		Assert.assertEquals(orderconfirmation.checkOrderConfirmationMessage(),"THANKYOU FOR THE ORDER.");
		if(input.get("userId").equalsIgnoreCase("sharmaprakash1234321@gmail.com")) {
			order_id_first = orderconfirmation.getProductId();
			order_name_first = orderconfirmation.getProductName();
		}else if(input.get("userId").equalsIgnoreCase("prakash.sharma8865@gmail.com")) {
			order_id_second = orderconfirmation.getProductId();
			order_name_second = orderconfirmation.getProductName();
		}
		orderconfirmation.logOut();
	
	}
		@Test(dependsOnMethods = {"submitOrderTest"},dataProvider = "getData1")
		public void orderHistory(HashMap<String, String> input) {
//			String userId = "sharmaprakash1234321@gmail.com";
//			String password = "Durga111@";
			ProductCatalog productCatalog = landingPage.loginApplication(input.get("userId"), input.get("password"));
			OrdersPage orderPage = productCatalog.goToOrdersPage();
			if(input.get("userId").equalsIgnoreCase("sharmaprakash1234321@gmail.com")) {
			Assert.assertTrue(orderPage.verifyProductId(order_id_first));
			Assert.assertTrue(orderPage.verifyProductName(order_name_first));
			}else if(input.get("userId").equalsIgnoreCase("prakash.sharma8865@gmail.com")) {
				Assert.assertTrue(orderPage.verifyProductId(order_id_second));
				Assert.assertTrue(orderPage.verifyProductName(order_name_second));
				}
		}
		
		
		/*
		@DataProvider
		public Object[][] getData() {
			return new Object[][] {{"sharmaprakash1234321@gmail.com","Durga111@","ADIDAS ORIGINAL"},
									{"prakash.sharma8865@gmail.com","Durga111@","ZARA COAT 3"}};
			
		}
		*/
		
		
		@DataProvider
		public Object[][] getData1() throws IOException {
			/*
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("userId", "sharmaprakash1234321@gmail.com");
			map.put("password", "Durga111@");
			map.put("addedProduct", "ADIDAS ORIGINAL");
			
			
			HashMap<String, String> map1 = new HashMap<String, String>();
			map1.put("userId", "prakash.sharma8865@gmail.com");
			map1.put("password", "Durga111@");
			map1.put("addedProduct", "ZARA COAT 3");
			*/
			
			List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\Prakash\\Data\\PurchaseOrder.json",StandardCharsets.UTF_8);
			
			
			return new Object[][] {{data.get(0)},{data.get(1)}};
			
		}
		
		

}
