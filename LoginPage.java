package Project_pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
public class LoginPage {

	WebDriver driver;
	By signInButton = By.linkText("Sign In");
	By Email = By.id("email");
	By password = By.id("pass");
	By button = By.id("send2");
	By welcomemessage = By.xpath("//p[@class='welcome-msg']");
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}

	public void loginmethod()
	{
		driver.findElement(signInButton).click();
		driver.findElement(Email).sendKeys("kirannjadhav13299@gmail.com");
		driver.findElement(password).sendKeys("Kiran@123");
		driver.findElement(button).click();
		driver.findElement(welcomemessage).getText();
	
}
}
