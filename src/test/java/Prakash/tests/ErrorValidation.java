package Prakash.tests;

import java.io.IOException;
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
import org.testng.annotations.Test;

import Prakash.PageObjects.CartPage;
import Prakash.PageObjects.LandingPage;
import Prakash.PageObjects.OrderConfirmaion;
import Prakash.PageObjects.OrdersPage;
import Prakash.PageObjects.ProductCatalog;
import io.github.bonigarcia.wdm.WebDriverManager;
import testComponents.BaseTest;
import testComponents.Retry;


public class ErrorValidation extends BaseTest {
	
		@Test(groups = {"errorHandling"},retryAnalyzer = Retry.class)
		public void wrongCredentialsLogin() throws InterruptedException, IOException{
		String userId = "sharmaprakash123432@gmail.com";
		String password = "Durga111@";
		landingPage.loginApplication(userId, password);
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());	

	}

}
