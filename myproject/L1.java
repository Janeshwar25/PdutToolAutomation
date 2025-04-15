package myproject;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class L1 {

	 public static void main(String[] args) {
	        // Lets WebDriverManager handle drivers
	        WebDriverManager.edgedriver().setup();
	        // Starts session (opens browser)
	        RemoteWebDriver driver = new EdgeDriver();

	        // Opens browser with desired URL
	        driver.get("https://www.saucedemo.com");
	        // Inputs standard_user in username field.
	        driver.findElement(By.id("user-name")).sendKeys("standard_user");
	        // Inputs secret_sauce in password field
	        driver.findElement(By.id("password")).sendKeys("secret_sauce");

	        // Clicks the Login button
	        driver.findElement(By.id("login-button")).click();

	        // maximizes browser window
	        driver.manage().window().maximize();

	        
	    }
	}

