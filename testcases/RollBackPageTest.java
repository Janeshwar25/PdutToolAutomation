package myproject.testcases;

import myproject.PageObjects.*;
import myproject.PageObjects.LoginPage;
import myproject.PageObjects.RollBackQueryPage;
import myproject.QueryProcessor.BaseClass;
import myproject.QueryProcessor.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import myproject.QueryProcessor.updatedSqlQuery.QueryPair;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


import static org.testng.Assert.assertNotNull;

public class RollBackPageTest extends BaseClass {
    private static updatedSqlQuery sqlQueryProcessor;
    private static LoginPage loginPage;
    private static HomePage homePage;
    private RollBackQueryPage rollBackQueryPage;
    private SubmitQueryPage submitQueryPage;
    private static WebDriver driver;
    private static Properties prop = new Properties();


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

        List<String> queries = List.of(sqlQueryProcessor.getAllQueries());
        String benefitBundleId = sqlQueryProcessor.getBenefitBundleID();

        boolean hasBenefitBundleId = benefitBundleId != null && !benefitBundleId.trim().isEmpty();
        int loopLimit = hasBenefitBundleId ? queries.size() : queries.size() - 1;

        List<String> rollBackOutputs = new ArrayList<>();
        for (int i = 0; i < loopLimit; i++) {
            String query = queries.get(i);
            try {
                rollBack.clickOnSelectApp();
                Thread.sleep(1000);
                rollBack.passDataInPastScriptArea(query);
                rollBack.ClickonGenerateRollBack();

                String output = rollBack.taketextfromRollBackTextArea(i + 1);
                if (output != null && !output.trim().isEmpty()) {
                    System.out.println("rollback output captured for query" + (i + 1));
                    rollBackOutputs.add(output);
                } else {
                    System.out.println("Empty rollback outbut detected");
                    rollBackOutputs.add("");

                }
            } catch (Exception e) {
                System.out.println("fail to process query" + (i + 1) + e.getMessage());
                rollBackOutputs.add("");
            } finally {
                rollBack.ClickonResetButton();
            }
        }

        if (!hasBenefitBundleId) {
            System.out.println("Skipped the last query due to missing BenefitBundelId");
        }

        rollBack.ClickonSubmitQuery();
        SubmitQueryPage submitQuery = new SubmitQueryPage();


        List<updatedSqlQuery.QueryPair> queryPairs = sqlQueryProcessor.getValidQueryPairs(rollBackOutputs);
        for (updatedSqlQuery.QueryPair pair: queryPairs){

            String rollback = pair.getRollbackQuery();
            String sql = pair.getSqlQuery();

            if (rollback == null || rollback.isEmpty() || sql == null || sql.isEmpty()){

                System.out.println("Skipping empty query pair");
                continue;

            }
            try{

                //submitQuery.fillAndSubmitQuery(rollback, sql);
                submitQuery.clickOnSelectApp();
                submitQuery.TicketIDValue();


                submitQuery.passDataInPastScriptArea(sql);

                submitQuery.passDataInPastRollBackArea(rollback);

                submitQuery.clickOnSubmitButton();

                Thread.sleep(1000);

                submitQuery.clickOnYesPopup();

                Thread.sleep(1000);

                submitQuery.ClickOnConfirmationButton();


            } catch (Exception e){
                System.out.println("Submission failed for pair"+ e.getMessage());
            }



        }



    }
}










