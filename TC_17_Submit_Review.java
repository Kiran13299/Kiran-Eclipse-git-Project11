//Verify that user is able to submit the review smoothly.
package Project1;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import pages.LoginPage;

public class TC_17_Submit_Review {

    String Url = "https://magento.softwaretestingboard.com/";
    String driverPath = "C:\\Users\\Computer\\Desktop\\Java Programs\\Selenium\\drivers\\chromedriver.exe";
    WebDriver driver;

    @BeforeMethod
    public void launch() {
        System.out.println("Launching the browser");
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void LumaLogin() {
        driver.get(Url);
        LoginPage page = new LoginPage(driver);
        page.loginmethod();
    }

    @Test(priority = 2)
    public void addReview() {
    	driver.findElement(By.xpath("//input[@id = 'search']")).sendKeys("Bag");
        driver.findElement(By.xpath("//button[@title=\"Search\"]")).click();
        driver.findElement(By.linkText("Push It Messenger Bag")).click();
        driver.findElement(By.linkText("Add Your Review")).click();
        driver.findElement(By.xpath("//label[@class=\"rating-1\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"summary_field\"]"))
              .sendKeys("Quality issue");
        driver.findElement(By.xpath("//textarea[@id=\"review_field\"]"))
              .sendKeys("The quality of the bag is not good.");
        driver.findElement(By.xpath("//button[@class=\"action submit primary\"]"))
              .click();
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }
}

	