package stepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Step {
	WebDriver driver;

	@Given("the user is on the nopCommerce login page")
	public void navigateToLoginPage() {
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("the user enters valid credentials \\(username: {string}, password: {string})")
	public void enterCredentials(String user, String pwd) {
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(user);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pwd);
	}

	@When("the user click on the Login button")
	public void clickLoginButton() {
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}

	@Then("the user should be redirected to the My Account page")
	public void myDashboard() {
		boolean status = driver.findElement(By.xpath("//h6[normalize-space()='Dashboard']")).isDisplayed();
		Assert.assertEquals(status, true);
	}

	@Then("the user should see a welcome message")
	public void welcomeMessage() {
		boolean welcometxt = driver.findElement(By.xpath("//img[@alt='client brand banner']")).isDisplayed();
		Assert.assertEquals(welcometxt, true);
		driver.quit();
		System.out.println("Login Successfully");

	}

}
