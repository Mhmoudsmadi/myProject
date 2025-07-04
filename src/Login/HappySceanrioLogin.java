package Login;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HappySceanrioLogin {

	WebDriver driver = new EdgeDriver();
	String thewebsite = "https://www.saucedemo.com/";
	String userName = "standard_user";
	String password = "secret_sauce";

	@BeforeTest
	public void setup() {
		driver.get(thewebsite);
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void login() {
		// Element
		WebElement UserNameInputField = driver.findElement(By.id("user-name"));
		WebElement PasswordInputField = driver.findElement(By.id("password"));
		WebElement Login = driver.findElement(By.id("login-button"));

		// Action
		UserNameInputField.sendKeys(userName);
		PasswordInputField.sendKeys(password);
		Login.click();

	}

	@Test(priority = 2)
	public void addToCart() {
		WebElement FirstItem = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
		FirstItem.click();
	}

	@Test(priority = 3)
	public void checkOut() throws InterruptedException {
		// driver.findElement(By.id("shopping_cart_container")).click();

		String[] firstName = { "maream", "somia", "fatema", "reem", "rand" };
		String[] lastName = { "ahmad", "ali", "omran", "Mhmod", "thaeir" };
		
		Random rand1 = new Random();
		Random rand2 = new Random();
		int randomFirstNameIndex = rand1.nextInt(firstName.length);
		int randomLastNameIndex = rand2.nextInt(lastName.length);

		System.out.println(randomFirstNameIndex);
		System.out.println(randomLastNameIndex);

		driver.navigate().to("https://www.saucedemo.com/cart.html");
		// Thread.sleep(2000);
		// driver.navigate().back();
		Thread.sleep(2000);
		// driver.navigate().forward();
		// Thread.sleep(2000);
		// driver.navigate().refresh();
		WebElement checkOutButton = driver.findElement(By.name("checkout"));
		checkOutButton.click();

		WebElement firstNameInputField = driver.findElement(By.name("firstName"));
		WebElement lastNameInputField = driver.findElement(By.name("lastName"));
		WebElement postalCodeInputField = driver.findElement(By.name("postalCode"));

		firstNameInputField.sendKeys(firstName[randomFirstNameIndex]);		
		lastNameInputField.sendKeys(lastName[randomLastNameIndex]);
	}

	@AfterTest
	public void closingTheBrowser() {
		driver.close();

	}

}
