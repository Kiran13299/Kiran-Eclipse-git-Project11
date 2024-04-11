package Project1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

public class TC_02_Create_Account {

	//Test case 02 -Verify that Create an Account link should work properly
	
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        // Set the path of chromedriver.exe in your system
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Computer\\Desktop\\Java Programs\\Selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void navigateToCreateAccountPage() {
        driver.get("https://magento.softwaretestingboard.com/");
        driver.findElement(By.linkText("Create an Account")).click();
    }

    @Test(priority = 2)
    public void fillOutAccountCreationForm() {
        // Fill the entire form
        WebElement firstName = driver.findElement(By.id("firstname"));
        firstName.sendKeys("sagar");

        WebElement lastName = driver.findElement(By.id("lastname"));
        lastName.sendKeys("Patare");

        WebElement email = driver.findElement(By.id("email_address"));
        email.sendKeys("s.patare11@gmail.com");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Kiran#123");

        WebElement confirmPassword = driver.findElement(By.id("password-confirmation"));
        confirmPassword.sendKeys("Kiran#123"); // Confirm password

        // Assert that password and confirm password fields are the same
        Assert.assertEquals(password.getAttribute("value"), confirmPassword.getAttribute("value"), "Passwords are not the same");

        // Submit the form
        driver.findElement(By.cssSelector("button[title='Create an Account']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
     // Assertion for successful Create an Account
        WebElement welcomeMessage = driver.findElement(By.xpath("//p[@class='welcome-msg']"));
        assert welcomeMessage.getText().contains("Welcome");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
