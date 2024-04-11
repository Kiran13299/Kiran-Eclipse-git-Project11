package Project1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Project_pages.LoginPage;

public class TC_13_Verify_Searchbox {

    private WebDriver driver;
    LoginPage login;

    @BeforeClass
    public void setup() {
        // Set the path of chromedriver.exe 
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Computer\\Desktop\\Java Programs\\Selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
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
    public void searchTest() {
        // Navigate to the webpage containing the search box
        driver.get("https://magento.softwaretestingboard.com/");

        // Find the search box element
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='search']"));

        // Enter a search query
        searchBox.sendKeys("Women Tops");

        // Submit the search query
        searchBox.sendKeys(Keys.ENTER);

        // Wait for the search results to load (you may need to implement explicit wait here)

        // Verify that the search results are displayed correctly
        WebElement searchResults = driver.findElement(By.xpath("//div[@id='search-results']"));
        Assert.assertTrue(searchResults.isDisplayed(), "Search results are not displayed");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
