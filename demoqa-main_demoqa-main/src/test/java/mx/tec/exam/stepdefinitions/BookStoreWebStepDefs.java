package mx.tec.exam.stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookStoreWebStepDefs {
    private static WebDriver driver;
    
    static {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\prisc\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
    }
	
	@Given("a registered user")
	public void a_registered_user() {
		// Do nothing
	}

	@When("the client calls \\/login page with username {string} and password {string}")
	public void the_client_calls_login_page_with_username_and_password(String username, String password) {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/login");
        WebElement usernameField = driver.findElement(By.id("userName"));
        usernameField.sendKeys(username);
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(password);
        WebElement submitButton = driver.findElement(By.id("login"));
        submitButton.click();   
	}
	
	@Then("the client is redirected to the {string} page")
	public void the_client_is_redirected_to_the_page(String pageTitle) throws InterruptedException {
        // Since this is a One Single Page application. Use the sleep to wait for the page to be updated        
        Thread.sleep(5000);
        
        String title = driver.findElement(By.className("main-header")).getText();                
        
        assertEquals(pageTitle, title);
        driver.quit();
    }
	
	@Then("the message {string} is displayed")
	public void the_message_is_displayed(String errorMsg) throws InterruptedException {
        Thread.sleep(5000);

		String message = driver.findElement(By.xpath("//*[@id=\"output\"]/div")).getText();        
	        assertEquals(errorMsg, message);
	        driver.quit();
	}
	
	@Then("credentials border color are {string}")
	public void credentials_border_color_are(String color) throws InterruptedException {
        Thread.sleep(5000);
        
	    String borderColor = driver.findElement(By.xpath("//*[@id=\"userName\"]")).getCssValue("border-color");        
	    
        assertEquals(color, borderColor);
        driver.quit();
	}
}
