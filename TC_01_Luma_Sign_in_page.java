package Project1;
import org.openqa.selenium.WebDriver;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import pages.LoginPage;

//Test Case 1 : Verify that Customer should able to sign In with correct details

public class TC_01_Luma_Sign_in_page {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        // Set the path of chromedriver.exe in your system
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Computer\\Desktop\\Java Programs\\Selenium\\drivers\\chromedriver.exe");

        // Initialize ChromeDriver
        driver = new ChromeDriver();
    }

    @Test
    public void signInTest() {
        // Navigate to the website
        driver.get("https://magento.softwaretestingboard.com/");
        
        // Click on Sign In link
        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        signInLink.click();

        // Enter email and password
        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("kirannjadhav13299@gmail.com");

        WebElement passwordInput = driver.findElement(By.id("pass"));
        passwordInput.sendKeys("Kiran@123");

        // Click on Sign In button
        WebElement signInButton = driver.findElement(By.id("send2"));
        signInButton.click();
        
        
      	{
      		driver.close();
      	}

        
    }

    
    }

