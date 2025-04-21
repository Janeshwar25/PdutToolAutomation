package myproject.testcases;

import myproject.PageObjects.*;
import myproject.PageObjects.LoginPage;
import myproject.PageObjects.RollBackQueryPage;
import myproject.QueryProcessor.BaseClass;
import myproject.QueryProcessor.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static org.testng.Assert.assertNotNull;

public class RollBackPageTest extends BaseClass {
    private static updatedSqlQuery sqlQueryProcessor;
    private static LoginPage loginPage;
    private static HomePage homePage;
    private RollBackQueryPage rollBackQueryPage;
    private static WebDriver driver;
    private static Properties prop = new Properties();

  /*  @BeforeSuite
    public static void collectInputOnce() {
        sqlQueryProcessor = new updatedSqlQuery();
        sqlQueryProcessor.collectUserInput();
    }*/

    public static void main(String[] args) throws Throwable {

        updatedSqlQuery sqlQueryProcessor = new updatedSqlQuery();
        sqlQueryProcessor.collectUserInput();

        /*BaseClass base = new BaseClass();
        base.loadConfig();
        base.launchApp("Edge");

        WebDriver driver = BaseClass.getDriver();

        LoginPage loginPage = new LoginPage();
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");
        HomePage homePage = loginPage.login(username, password);

        RollBackQueryPage rollBack = homePage.clickonGenerateRollBack();
        rollBack.clickOnSelectApp();
        String query = sqlQueryProcessor.getFirstQuery();
        rollBack.passDataInPastScriptArea(query);

        System.out.println("RollBack test completed");*/

        RollBackPageTest runner = new RollBackPageTest();
        runner.runRollBackPageTest(sqlQueryProcessor);
    }

    public void runRollBackPageTest(updatedSqlQuery sqlQueryProcessor) throws Throwable {

        loadConfig();
        String browser = System.getProperty("browser", "Edge");
        launchApp(browser);

        LoginPage loginPage = new LoginPage();
        String username = BaseClass.prop.getProperty("username");
        String password = BaseClass.prop.getProperty("password");
        HomePage homePage = loginPage.login(username, password);

        RollBackQueryPage rollBack = homePage.clickonGenerateRollBack();
        rollBack.clickOnSelectApp();
        String query = sqlQueryProcessor.getFirstQuery();
        rollBack.passDataInPastScriptArea(query);
        rollBack.ClickonGenerateRollBack();
        rollBack.taketextfromRollBackTextArea1();

        rollBack.ClickonResetButton();

        rollBack.clickOnSelectApp();
        String query1 = sqlQueryProcessor.getSecondQuery();
        rollBack.passDataInPastScriptArea(query1);
        /*rollBack.ClickonGenerateRollBack();
        rollBack.taketextfromRollBackTextArea2();

        rollBack.ClickonResetButton();*/









        System.out.println("RollBack test completed");

    }


}
