package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class task1 {
	
	WebDriver driver = new EdgeDriver();
	String theBrowser = "https://automationteststore.com/";
	
	
	@BeforeTest
	public void setup() {
		driver.get(theBrowser);
		driver.manage().window().maximize();
		
	}
	@Test
	public void signup() throws InterruptedException {
		

		// Create a Select object

		// Then select the option by visible text
		driver.findElement(By.id("customer_menu_top")).click();
		driver.findElement(By.className("pull-right")).click();
		driver.findElement(By.id("AccountFrm_firstname")).sendKeys("mahmoud");
		driver.findElement(By.id("AccountFrm_lastname")).sendKeys("alsmadi");
		driver.findElement(By.id("AccountFrm_email")).sendKeys("mhmodsmadi.2003@gmail.com");
		driver.findElement(By.id("AccountFrm_address_1")).sendKeys("245555");
		driver.findElement(By.id("AccountFrm_city")).sendKeys("irbid");
		//driver.findElement(By.id("AccountFrm_city")).sendKeys("irbid");
		WebElement countryDropdown = driver.findElement(By.id("AccountFrm_country_id"));
		Select select1 = new Select(countryDropdown);
		select1.selectByVisibleText("Jordan");
		Thread.sleep(1000);
		driver.findElement(By.id("AccountFrm_postcode")).sendKeys("25333");
		//driver.findElement(By.id("AccountFrm_postcode")).sendKeys("25333");
		WebElement cityDropdown = driver.findElement(By.id("AccountFrm_zone_id"));
		Select select2 = new Select(cityDropdown);
		select2.selectByVisibleText("Irbid");
		driver.findElement(By.id("AccountFrm_loginname")).sendKeys("smadi");
		driver.findElement(By.id("AccountFrm_password")).sendKeys("mo.12345678");
		driver.findElement(By.id("AccountFrm_confirm")).sendKeys("mo.12345678");
		driver.findElement(By.id("AccountFrm_newsletter1")).click();
		// xpath= "//tagname[@attributename='']"
		driver.findElement(By.xpath("//input[@id='AccountFrm_agree']")).click();
		//driver.findElement(By.className("lock-on-click")).click();

		
	}
	
	@AfterTest
	public void closinTheBrowser() {
		
	}

}
