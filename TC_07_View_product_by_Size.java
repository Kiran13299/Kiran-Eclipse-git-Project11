package Project1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_07_View_product_by_Size
{
public WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Computer\\Desktop\\Java Programs\\Selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://magento.softwaretestingboard.com/");
	}
	
	@Test(priority=1)
	public void HomePagetitleVerification()
	{
		String title= driver.getTitle(); // Verify that home page is visible successfully
		System.out.println(title);
		assertEquals(title,"Home Page","Incorrect Title");
		
	}
	
	@Test(priority=2)
	public void View_Products_size()
	{
		// select any category ex: men
		
		driver.findElement(By.xpath("//span[text()='Men']")).click();
		
		// verify user navigated to men's page and verify category's are visible on left side bar.
		
		// verify page navigated to men's page
				
		boolean men_page=driver.findElement(By.xpath("(//span[text()='Men'])[2]")).isDisplayed();
		assertTrue(men_page,"Men");
				
		//verify category's are visible on left side bar.
				
		boolean verify_cate= driver.findElement(By.xpath("//dt[text()='Category']")).isDisplayed();
		assertTrue(verify_cate,"Category");
				
		//click on any category under men's page for ex: bottom
		
		driver.findElement(By.xpath("//a[text()='Bottoms']")).click();
		
		//verify that category is displayed and confirmed test "Bottom"
		
		boolean Bottom= driver.findElement(By.xpath("(//span[text()='Bottoms'])[3]")).isDisplayed();
		assertTrue(Bottom,"Bottoms");
		
		// click on the size from the left side bar 
				
		driver.findElement(By.xpath("(//div[@class='filter-options-title'])[3]")).click();
		driver.findElement(By.xpath("(//div[@class='swatch-option text '])[2]")).click();
		
		// verify user is able to see selected size
		
		boolean size_verify= driver.findElement(By.xpath("//*[@id=\"layered-filter-block\"]/div[2]/div[1]/ol/li/span[2]")).isDisplayed();
		assertTrue(size_verify,"Size33");
		
		
	}
	
	@Test(priority=3)
	public void close()
	{
		driver.close();
	}

}
