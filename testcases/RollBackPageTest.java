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

        String[] queryArray = sqlQueryProcessor.getAllQueries();
        List<String> queries = new ArrayList<>();
        for (String q : queryArray) {
            queries.add(q);
        }

        String benefitBundleId = sqlQueryProcessor.getBenefitBundleID();


        /*List<String> queries = List.of(sqlQueryProcessor.getAllQueries());
        String benefitBundleId = sqlQueryProcessor.getBenefitBundleID();*/

        boolean hasBenefitBundleId = benefitBundleId != null && !benefitBundleId.trim().isEmpty();
        int loopLimit = hasBenefitBundleId ? queries.size() : queries.size() - 1;

        //List<String> rollBackOutputs = new ArrayList<>();

        List<updatedSqlQuery.QueryPair> queryPairs = new ArrayList<>();


        for (int i = 0; i < loopLimit; i++) {
            String query = queries.get(i);
            System.out.println("Processing query " + (i + 1));


            boolean retry = true;
            int retryCount = 0;


            while (retry && retryCount < 6) {
                System.out.println("Retry attempt " + (retryCount + 1) + " for query " + (i + 1));
                try {
                    rollBack.clickOnSelectApp();
                    Thread.sleep(1500); // Slightly increased for UI stability
                    rollBack.passDataInPastScriptArea(query);
                    rollBack.ClickonGenerateRollBack();
                    rollBack.ClickonGenerateRollBack();

                    // Check stats and skip if no records
                    if (rollBack.checkStatsAndResetIFNoRecords(i + 1)) {
                        System.out.println("Skipping query " + (i + 1) + " due to no records to update.");
                        queryPairs.add(new updatedSqlQuery.QueryPair("", query));
                        retry = false; // ✅ Exit retry loop
                        break;         // ✅ Exit retry loop

                    }


                    System.out.println("Waiting for rollback output...");
                    String rollBackOutput = rollBack.taketextfromRollBackTextArea(i + 1);

                    if (rollBackOutput == null || rollBackOutput.trim().isEmpty()) {
                        rollBackOutput = "";
                        System.out.println("Empty rollback output detected for query " + (i + 1));
                    } else {
                        System.out.println("Rollback output captured for query " + (i + 1));
                    }

                    queryPairs.add(new updatedSqlQuery.QueryPair(rollBackOutput, query));
                    retry = false; // ✅ Successfully processed, exit retry loop


                } catch (Exception e) {
                    System.err.println("Failed to process query " + (i + 1) + ": " + e.getMessage());
                    e.printStackTrace();
                    queryPairs.add(new updatedSqlQuery.QueryPair("", query));
                    retryCount++;

                } finally {
                    try {
                        System.out.println("Attempting to reset rollback form for query " + (i + 1));
                        rollBack.ClickonResetButton();
                        System.out.println("Reset successful for query " + (i + 1));
                    } catch (Exception resetEx) {
                        System.err.println("Reset failed for query " + (i + 1) + ": " + resetEx.getMessage());
                    }
                }
            }

            if (!hasBenefitBundleId) {
                System.out.println("Skipped the last query due to missing BenefitBundleId");
            }



            rollBack.ClickonSubmitQuery();
            SubmitQueryPage submitQuery = new SubmitQueryPage();

            for (updatedSqlQuery.QueryPair pair : queryPairs) {
                String rollback = pair.getRollbackQuery();
                String sql = pair.getSqlQuery();

                if (rollback == null || rollback.isEmpty() || sql == null || sql.isEmpty()) {
                    System.out.println("Skipping empty query pair");
                    continue;
                }

                try {
                    submitQuery.clickOnSelectApp();
                    submitQuery.TicketIDValue();
                    submitQuery.passDataInPastScriptArea(sql);
                    submitQuery.passDataInPastRollBackArea(rollback);
                    submitQuery.clickOnSubmitButton();

                    Thread.sleep(1000);
                    submitQuery.clickOnYesPopup();
                    Thread.sleep(1000);
                    submitQuery.ClickOnConfirmationButton();

                    System.out.println("Successfully submitted query pair");

                } catch (Exception e) {
                    System.err.println("Submission failed for pair: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

}


