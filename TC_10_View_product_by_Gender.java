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

public class TC_10_View_product_by_Gender
{
public WebDriver dr;
	
	@BeforeClass
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Computer\\Desktop\\Java Programs\\Selenium\\drivers\\chromedriver.exe");
        dr = new ChromeDriver();
        dr.manage().window().maximize();
        dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        dr.get("https://magento.softwaretestingboard.com/"); // Navigate to url 'https://magento.softwaretestingboard.com/'

	}
	
	@Test(priority=1)
	public void HomePagetitleVerification()
	{
		String title= dr.getTitle(); // Verify that home page is visible successfully
		System.out.println(title);
		assertEquals(title,"Home Page","Incorrect Title");
		
	}
	
	@Test(priority=2)
	public void View_Products_Material()
	{
		// select any category ex: Gear
		
		dr.findElement(By.xpath("//span[text()='Gear']")).click();
		
		// verify user navigated to Gear's page and verify category's are visible on left side bar.
		
		// verify page navigated to Gear's page
				
		boolean men_page=dr.findElement(By.xpath("(//span[text()='Gear'])[2]")).isDisplayed();
		assertTrue(men_page,"Gear");
				
		//verify category's are visible on left side bar.
				
		boolean verify_cate= dr.findElement(By.xpath("//dt[text()='Category']")).isDisplayed();
		assertTrue(verify_cate,"Category");
				
		//click on any category under Gear's page for ex: Watches
		
		dr.findElement(By.xpath("(//a[text()='Watches'])[1]")).click();
		
		//verify that category is displayed and confirmed test "Watches"
		
		boolean Tops= dr.findElement(By.xpath("(//span[text()='Watches'])[2]")).isDisplayed();
		assertTrue(Tops,"Watches");
		
		// click on the Gender from the left side bar 
				
		dr.findElement(By.xpath("(//div[@class='filter-options-title'])[5]")).click();
		dr.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[5]/div[2]/ol/li[1]/a")).click();
		
		// verify user is able to see selected Gender Watches
		
		boolean Watches= dr.findElement(By.xpath("//*[@id=\"layered-filter-block\"]/div[2]/div[1]/ol/li/span[1]")).isDisplayed();
		assertTrue(Watches,"GenderMen");
		
		
	}
	
	@Test(priority=3)
	public void close()
	{
		dr.close();
	}
}
