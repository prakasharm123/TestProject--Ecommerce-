package stepDefinations;

import java.io.IOException;

import org.testng.Assert;

import Prakash.PageObjects.CartPage;
import Prakash.PageObjects.LandingPage;
import Prakash.PageObjects.OrderConfirmaion;
import Prakash.PageObjects.ProductCatalog;
import Prakash.PageObjects.ShippingPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testComponents.BaseTest;

public class StepDefinationImpl extends BaseTest {
	public LandingPage landingPage;
	public ProductCatalog productCatalog;
	public CartPage cartPage;
	public ShippingPage shippingPage;
	public OrderConfirmaion orderconfirmation;
	@Given("land on Ecommerce page")
	public void land_on_Ecommerce_Page() throws IOException {
		
		landingPage = launchApplication();
	
	}
	
	@Given("^logged in with username (.+) and password (.+)$")
	public void logged_in_with_username_and_password(String username,String password) {
		productCatalog = landingPage.loginApplication(username, password);
	}
	
	@When("^I add product (.+) to cart$")
	public void add_product_to_cart(String product) throws InterruptedException {
		productCatalog.addProductToCart(product);
		cartPage = productCatalog.goToCartPage();
	}
	
	
	@Given("^checkout with (.+) and submit the order$")
	public void checkout_and_submit_order(String country) {
		shippingPage = cartPage.clickOnCheckOut();
		shippingPage.selectCountry(country);
		orderconfirmation = shippingPage.placeOrder();
		
		
	}
	
	@Then("{string} message is displayed on confirmation page")
	public void message_displayed_confirmationPage(String string) {
		String confirmationMessage = orderconfirmation.checkOrderConfirmationMessage();
		driver.close();
	}
	
	
	@When("check incorrect email and password {string}")
	public void check_incorrect_email_password(String string) {
		Assert.assertEquals(string, landingPage.getErrorMessage());	
		driver.close();
	}
	
	
	
	
	
	
}
