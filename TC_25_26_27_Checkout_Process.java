package Project1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
public class TC_25_26_27_Checkout_Process {


public WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Computer\\Desktop\\Java Programs\\Selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://magento.softwaretestingboard.com/");// Navigate to url 'https://magento.softwaretestingboard.com/'
	}
		public void Setup()
		{
		//test case 25:Verify that the checkout process consists of multiple steps (e.g., shipping address, payment method, order review).
        WebElement paymentMethodDropdown = driver.findElement(By.id("payment-method"));
	        paymentMethodDropdown.sendKeys("credit_card");
	        
	        
	       //Test case 26: Verify that each step of the checkout process can be completed successfully.

	        // Fill in credit card details
	        WebElement creditCardNumberInput = driver.findElement(By.id("credit-card-number"));
	        creditCardNumberInput.sendKeys("1234567890123456");
		WebElement CheckoutButton=driver.findElement(By.id("top-cart-btn-checkout"));
		 CheckoutButton.click();
		 
		 WebElement nextButton = driver.findElement(By.cssSelector(".button[name='next']"));
	        nextButton.click();
	        
	        
	        // Test Case 27:Verify that the order confirmation page is displayed
	        if (driver.getCurrentUrl().contains("order-confirmation")) {
	            System.out.println("Order confirmation page displayed. Order placed successfully.");
	        } else {
	            System.out.println("Failed to reach the order confirmation page. Order placement unsuccessful.");
	        }
	        
	       
}


	        
}
		 
		
	 
