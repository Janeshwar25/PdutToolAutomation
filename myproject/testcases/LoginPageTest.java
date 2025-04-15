package myproject.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import myproject.QueryProcessor.BaseClass;
import myproject.QueryProcessor.Action;
import myproject.PageObjects.LoginPage;
import myproject.PageObjects.HomePage;

import java.util.Objects;


/*import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;*/


    public class LoginPageTest extends BaseClass {
        LoginPage loginPage;
        HomePage homePage;

        @BeforeMethod
        public void setup() {
            String browser = System.getProperty("browser","Edge");
            launchApp(browser);

        }

        @AfterMethod
        public void tearDown() {
            //getDriver().quit();
        }

        @Test
        public void loginTest() throws Throwable {

            LoginPage loginPage = new LoginPage();
            String username = prop.getProperty("username");
            String password = prop.getProperty("password");

           HomePage homePage = loginPage.login(username,password);



        }

    }