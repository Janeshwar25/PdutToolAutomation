package myproject;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SouceLab {

	public static void main(String[] args) throws MalformedURLException {
		

		
		
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 10");
		browserOptions.setBrowserVersion("latest");
		Map<String, Object> sauceOptions = new HashMap<>();
		sauceOptions.put("username", "sso-optum-janeshwar_chowdhary");
		sauceOptions.put("accessKey", "d1a3edcb-bca8-48b7-85a0-bd9cae88a11e");
		sauceOptions.put("build", "<your build id>");
		sauceOptions.put("name", "<your test name>");
		browserOptions.setCapability("sauce:options", sauceOptions);

		URL url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(url, browserOptions);
//		browserOptions.setPlatformName("Windows 10");
//		browserOptions.setBrowserVersion("latest");
//		Map<String, Object> sauceOptions = new HashMap<>();
//		sauceOptions.put("username", "sso-optum-janeshwar_chowdhary");
//		sauceOptions.put("accessKey", "d1a3edcb-bca8-48b7-85a0-bd9cae88a11e");
//		sauceOptions.put("build", "<your build id>");
//		sauceOptions.put("name", "<your test name>");
//		browserOptions.setCapability("sauce:options", sauceOptions);

//		URL url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
//		RemoteWebDriver driver = new RemoteWebDriver(url, browserOptions);

	}

}
