package myproject.QueryProcessor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.xml.DOMConfigurator;
import org.ietf.jgss.Oid;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.Properties;

import static com.sun.org.apache.xml.internal.serializer.OutputPropertyUtils.getIntProperty;

public class BaseClass {
        private static final int DEFAULT_IMPLICIT_WAIT = 60;
        private static final int DEFAULT_PAGE_LOAD_TIMEOUT = 60;
        public static Properties prop;

        // Declare ThreadLocal Driver
        public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

        //loadConfig method is to load the configuration
        @BeforeTest
        public void loadConfig() {

            //DOMConfigurator.configure("log4j.xml");

            try {
                prop = new Properties();
                FileInputStream ip = new FileInputStream(
                        System.getProperty("user.dir") + "\\Config.properties");
                prop.load(ip);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static WebDriver getDriver() {
            // Get Driver from threadLocalmap
            return driver.get();
        }

        public void launchApp(String browserName) {
            // String browserName = prop.getProperty("browser");
            if (browserName.equalsIgnoreCase("Edge")) {
                WebDriverManager.edgedriver().setup();
                // Set Browser to ThreadLocalMap
                driver.set(new EdgeDriver());
            } else if (browserName.equalsIgnoreCase("FireFox")) {
                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver());
            } else if (browserName.equalsIgnoreCase("Chrome")) {
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
            }
            //Maximize the screen
            getDriver().manage().window().maximize();
            //Delete all the cookies
            getDriver().manage().deleteAllCookies();



            //Implicit TimeOuts
            int implicitWait = getIntProperty("implicitWait", DEFAULT_IMPLICIT_WAIT);
            getDriver().manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
            //PageLoad TimeOuts
            int pageLoadTimeout = getIntProperty("pageLoadTimeout", DEFAULT_PAGE_LOAD_TIMEOUT);
            getDriver().manage().timeouts().pageLoadTimeout(DEFAULT_PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

            //Launching the URL
            getDriver().get(prop.getProperty("url"));
        }

    private int getIntProperty(String key, int defaultValue) {

            String value = prop.getProperty(key);
            return value != null? Integer.parseInt(value): defaultValue;


    }

    @AfterTest
        public void afterSuite() {
            //ExtentManager.endReport();
        }
    }

