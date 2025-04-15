package myproject.testcases;

import myproject.PageObjects.HomePage;
import myproject.PageObjects.LoginPage;
import myproject.PageObjects.RollBackQueryPage;
import myproject.QueryProcessor.BaseClass;
import myproject.QueryProcessor.updatedSqlQuery;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RollBackPageTest extends BaseClass {

    LoginPage loginPage;
    HomePage homePage;
    RollBackQueryPage rollBackQueryPage;
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
    public void RollbackPageTest() throws Throwable {
        LoginPage loginPage = new LoginPage();
        RollBackQueryPage rollBack = new RollBackQueryPage();
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");
        HomePage homePage = loginPage.login(username,password);
        rollBack = homePage.clickonGenerateRollBack();
        rollBack.clickOnSelectApp();
        rollBack.passDataInPastScriptArea();

    }

}
