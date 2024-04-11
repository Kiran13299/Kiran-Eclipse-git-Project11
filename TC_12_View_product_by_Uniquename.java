package Project1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//Test case 12 - Verify that Product should open by unique name
public class TC_12_View_product_by_Uniquename {

    private WebDriver driver;

    @BeforeClass
    public void setup() {
        // Set the path of chromedriver.exe in your system
        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Computer\\\\Desktop\\\\Java Programs\\\\Selenium\\\\drivers\\\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void Setup() {
        driver.get("https://magento.softwaretestingboard.com/");
        driver.findElement(By.xpath("//span[text()='Women']")).click();
        driver.findElement(By.linkText("Tops")).click();
        driver.findElement(By.linkText("Maya Tunic")).click();
        
      
    }
}
