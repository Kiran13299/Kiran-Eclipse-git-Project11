package Project1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest; 
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import Project_pages.LoginPage;

public class TC_04_Verify_WhatsNew_page {
	//Test case 04 : Verify that What's New page should work properly
	
    LoginPage login;
    WebDriver driver;
    String driverPath = "C:\\Users\\Computer\\Desktop\\Java Programs\\Selenium\\drivers\\chromedriver.exe";
    public String url = "https://magento.softwaretestingboard.com/";

    @BeforeTest
    public void open_the_Chrome_and_launch_the_application() throws Throwable {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        System.out.println("Chrome is opened and application is launched.");
    }

    @Test(priority = 1)
    public void perform_login_action() throws Throwable {
        login = new LoginPage(driver);
        // Perform login action
        login.loginmethod();
        System.out.println("Login performed successfully.");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
    }

    @Test(priority = 2)
    
    public void setup()
    {

    	driver.findElement(By.linkText("What's New")).click();
    	driver.findElement(By.linkText("Jackets")).click();
    	
    }
    
    
    @AfterTest
    public void finish_login() throws Throwable {
        // Additional actions after login if needed
        System.out.println("Finish login");
        driver.quit();
    }
}
