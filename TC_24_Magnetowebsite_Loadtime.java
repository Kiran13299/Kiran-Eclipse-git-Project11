package Project1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
@Test
public class TC_24_Magnetowebsite_Loadtime {

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
        public void Setup()
        {
        	
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
 // Adding a wait time, but consider using explicit waits instead
    }
        
}


    

	

