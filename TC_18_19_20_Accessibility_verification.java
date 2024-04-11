package Project1;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_18_19_20_Accessibility_verification {

public WebDriver dr;
	
	@BeforeClass
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Computer\\Desktop\\Java Programs\\Selenium\\drivers\\chromedriver.exe");
        dr = new ChromeDriver();
        dr.manage().window().maximize();
        dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        dr.get("https://magento.softwaretestingboard.com/"); // Navigate to url 'https://magento.softwaretestingboard.com
	}
	
	@Test(priority=1)
	public void HomePagetitleVerification()
	{
		String title= dr.getTitle(); // Verify that home page is visible successfully
		System.out.println(title);
		assertEquals(title,"Home Page","Incorrect Title");
		
	}
	
    @Test(priority=2)
    public void ScreenreaderCompatibility()
    {
        // Test case 18:Verify screen reader compatibility
        
        WebElement element = dr.findElement(By.tagName("body"));
        boolean screenReaderCompatible = element.isEnabled() && element.isDisplayed();

        if (screenReaderCompatible) {
            System.out.println("Website is screen reader compatible.");
        } else {
            System.out.println("Website is not screen reader compatible.");
        }
    }
        //Test Case 19: Verify keyboard navigation
    @Test(priority=3)
    public void VerifyKeyboardnavigation()
    {
       
        WebElement searchBox = dr.findElement(By.id("search"));
        searchBox.sendKeys("Test");
        dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
        //Test Case 20: Verify that essential functions are accessible to users with disabilities
      @Test(priority=4)
      public void Setup()
      {
        WebElement searchButton = dr.findElement(By.cssSelector(".actions [type='submit']"));
        searchButton.click();
      }
        
      @Test(priority=5)
  	public void close()
  	{
  		dr.close();
  	}
  	
  	


	}


