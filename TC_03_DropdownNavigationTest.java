package Project1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

// Test case 03 - Verify that dropdown navigation should work properly
public class TC_03_DropdownNavigationTest {

    private WebDriver driver;

    @BeforeClass
    public void setup() {
        // Set the path of chromedriver.exe 
        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Computer\\\\Desktop\\\\Java Programs\\\\Selenium\\\\drivers\\\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void dropdownNavigationTest() {
        // Navigate to the homepage
        driver.get("https://magento.softwaretestingboard.com/");

        // Click on "Women" dropdown
        WebElement womenDropdown = driver.findElement(By.xpath("//span[text()='Women']"));
        womenDropdown.click();

        // Click on "Tops" option
        WebElement topsOption = driver.findElement(By.linkText("Tops"));
        topsOption.click();

        // Click on "Jackets" option
        WebElement jacketsOption = driver.findElement(By.xpath("//span[text()='Jackets']"));
        jacketsOption.click();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}