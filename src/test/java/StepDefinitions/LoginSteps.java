package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	WebDriver driver = null;

	/**
	 * 
	 */
	@Given("user is on login page")
	public void user_is_on_login_page() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Inside Step - user is on login page");
		
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is: "+projectPath);
		
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		//driver.manage().window().maximize();
		driver.navigate().to("https://www.saucedemo.com/");
	}

	@When("user enters username and password")
	public void user_enters_username_and_password() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Inside Step - user enters username and password");
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		

	}

	@And("clicks on login button")
	public void clicks_on_login_button() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Inside Step - user clicks on login button");
		
		driver.findElement(By.id("login-button")).click();;
	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Inside Step - user is navigated to the home page");
		
		driver.getPageSource().contains("Swag Labs");
	}
	
	@When("user enters invalid username and password")
	public void user_enters_invalid_username_password() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Inside Step - user enters invalid username");
		
		driver.findElement(By.id("user-name")).sendKeys("asjdklasd");
		driver.findElement(By.id("password")).sendKeys("asdsadsa");
		
	}
	
	@Then("user is display error username and password")
	public void user_is_display_error_username() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Inside Step - user is display error username and password");
		
		driver.getPageSource().contains("Username and password do not match any user in this service");
	}
	
	@Then("user is display error username required")
	public void user_is_display_error_username_required() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Inside Step - user is display error username required");
		
		driver.getPageSource().contains("Epic sadface: Username is required");
	}
	
	@Then("user is display error password required")
	public void user_is_display_error_password_required() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Inside Step - user is display error password required");
		
		driver.getPageSource().contains("Epic sadface: Password is required");
	}
	
	@When("user enters valid username")
	public void user_enters_valid_username() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Inside Step - user enters valid username");
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		
		
	}
	
	@After
	public void close(Scenario scenario) {
		
		String scenarioName = scenario.getName();
		TakesScreenshot takescreenshot = (TakesScreenshot) driver;
		byte[] screnshot = takescreenshot.getScreenshotAs(OutputType.BYTES);
		scenario.attach(screnshot, "image/png", scenarioName);
		
	}

}

