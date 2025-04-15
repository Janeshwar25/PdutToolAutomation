package myproject;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class B_and_E_Portal {

	public static void main(String[] args) {
		
		EdgeOptions browserOptions = new EdgeOptions();
		browserOptions.setPlatformName("Windows 10");
		browserOptions.setBrowserVersion("112");
		Map<String, Object> sauceOptions = new HashMap<>();
		sauceOptions.put("build", "<your build id>");
		sauceOptions.put("name", "<your test name>");
		browserOptions.setCapability("sauce:options", sauceOptions);

	/*	URL url = new URL("https://sso-optum-janeshwar_chowdhary:d1a3edcb-bca8-48b7-85a0-bd9cae88a11e@ondemand.us-west-1.saucelabs.com:443/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(url, browserOptions);*/

		URL url = null;
		try {
			url = new URL("https://sso-optum-janeshwar_chowdhary:d1a3edcb-bca8-48b7-85a0-bd9cae88a11e@ondemand.us-west-1.saucelabs.com:443/wd/hub");
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		
		RemoteWebDriver driver = new RemoteWebDriver(url, browserOptions);
	try {
		WebDriver driver1=new EdgeDriver();
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver1.get("https://member.int.uhc.com/myuhc?action=logout");
		driver1.manage().window().maximize();
		driver1.findElement(By.id("signInButton")).click();
		Thread.sleep(1000);
		driver1.findElement(By.id("username")).sendKeys("FNGrizLNBarsby");
		driver1.findElement(By.id("password")).sendKeys("Test2day");
		driver1.findElement(By.id("submitBtn")).click();
		System.out.println(driver1.findElement(By.xpath("//label[@for='Q10.2']")).getText()); 
		
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
		
		
	}
	
	
            
	}
	
	}
		
}
	

