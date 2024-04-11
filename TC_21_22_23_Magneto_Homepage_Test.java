package Project1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_21_22_23_Magneto_Homepage_Test {
	public WebDriver driver;
	@BeforeClass
	public void setup()
	{
	        // Initialize ChromeDriver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Computer\\Desktop\\Java Programs\\Selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://magento.softwaretestingboard.com/"); // Navigate to url 'https://magento.softwaretestingboard.com
	}
	
	@Test(priority=1)
	public void Setup() {
	        // Test Case 21: Verify that the homepage loads successfully
	        if (driver.getTitle().contains("Magento")) {
	            System.out.println("Test Case 1: Homepage loaded successfully - PASSED");
	        } else {
	            System.out.println("Test Case 1: Homepage failed to load - FAILED");
	        }

	        // Test Case 22: Verify that all main navigation links are clickable and lead to the respective pages
	        WebElement homeLink = driver.findElement(By.linkText("Home"));
	        homeLink.click();
	        if (driver.getCurrentUrl().equals("https://magento.softwaretestingboard.com/")) {
	            System.out.println("Test Case 2: Home link is clickable and leads to the respective page - PASSED");
	        } else {
	            System.out.println("Test Case 2: Home link is not clickable or does not lead to the respective page - FAILED");
	        }

	        WebElement productsLink = driver.findElement(By.linkText("Products"));
	        productsLink.click();
	        // Add similar validation for other navigation links (e.g., Categories)

	        
	        // Test Case 23: Verify that the search bar is functional
	        WebElement searchBar = driver.findElement(By.id("search"));
	        searchBar.sendKeys("product");
	        WebElement searchButton = driver.findElement(By.className("action search"));
	        searchButton.click();
	        
	
	        // Close the browser
	        driver.quit();
	    }
	

	}

