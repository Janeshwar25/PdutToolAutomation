package myproject.PageObjects;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import myproject.QueryProcessor.BaseClass;
import myproject.QueryProcessor.Action;
import myproject.QueryProcessor.updatedSqlQuery;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class RollBackQueryPage extends BaseClass {

    private updatedSqlQuery updatedSqlQuery;
    private String[] updatedSqlQueries;


    Action action = new Action();

    @FindBy(xpath = "//*[@id=\"select\"]")
    private WebElement ClickOnSelectAppDropDown;

    @FindBy(xpath = "//*[@id=\"select\"]")
    private WebElement SelectAppFromDropDown;

    @FindBy(xpath = "//*[@id=\"main\"]/div[2]/fieldset/ul/li[2]/div/label")
    private WebElement PastScriptRadiobutton;

    @FindBy(xpath = "/html/body/div/div/div/div[3]/main/div[2]/div/form/div[4]/div/div/textarea[1]")
    private WebElement PastScriptArea;

    @FindBy(xpath = "//*[@id=\"main\"]/div[2]/div/form/div[5]/button[1]")
    private WebElement GenerateRollBackButton;

    @FindBy(xpath = "//*[@id=\"main\"]/div[2]/div/form/div[7]/button[2]")
    private WebElement ResetButton;

    @FindBy(xpath = "//*[@id=\"main\"]/div[2]/div/form/div[6]/button[2]")
    private WebElement ResetButton2;

    @FindBy(xpath = "/html/body/div/div/div/div[3]/main/div[2]/div/form/div[5]/div/div/textarea[1]")
    private WebElement RollBackTextArea;

    @FindBy(xpath = "//*[@id=\"react-root\"]/div/div/div[3]/aside/nav/ul/li[2]/a/span/span[2]")
    private WebElement SubmitQuery;

    @FindBy(xpath = "/html/body/div/div/div/div[3]/main/div[2]/div/form/div[5]/div/div/textarea[1]")
    private WebElement statsBox;

    private updatedSqlQuery sqlQueryPrcessor;

    public RollBackQueryPage() {
        PageFactory.initElements(getDriver(), this);
        this.sqlQueryPrcessor = new updatedSqlQuery();

    }



    public void clickOnSelectApp() throws Throwable {

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement dropdownIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("svg.MuiSvgIcon-root")));
        dropdownIcon.click();
        WebElement optionToSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main\"]/div[2]/div/form/div/div/div[2]/div[44]/span")));
        optionToSelect.click();
       /* try {
            WebElement dropdownIcon = getDriver().findElement(By.cssSelector("#main > div.MuiBox-root.css-fk96wx > div > form > div > div > div > div > svg"));
            dropdownIcon.click();

            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
            WebElement optionToSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[@id=\"main\"]/div[2]/div/form/div/div/div[2]/div[44]")));
            optionToSelect.click();
        } catch (TimeoutException e) {
            System.out.println("Dropdown option not found, retrying...");
            Thread.sleep(1000); // Wait briefly
            WebDriver driver = getDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            try {
                WebElement dropdownIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#main > div.MuiBox-root.css-fk96wx > div > form > div > div > div > div > svg")));
                dropdownIcon.click();

                WebElement optionToSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//span[text()='YourOptionText']"))); // Replace with actual visible text
                optionToSelect.click();

                System.out.println("Dropdown option selected successfully on retry.");
            } catch (Exception retryEx) {
                System.err.println("Retry failed: " + retryEx.getMessage());
                throw retryEx; // Let the calling method handle it
            }
        }*/

}
        /*action.click(getDriver(), ClickOnSelectAppDropDown);
        Select dropdown = new Select(SelectAppFromDropDown);
        dropdown.selectByVisibleText("gcp_cirrus_alpha_rso_01");
        action.click(getDriver(), PastScriptRadiobutton);
        action.click(getDriver(), PastScriptArea);*/



    public String getStatsboxText() {
        try {
            WebElement statsBoxElement = getDriver().findElement(By.xpath("/html/body/div/div/div/div[3]/main/div[2]/div/form/div[5]/div/div/textarea[1]"));
            return statsBoxElement.getText();
        } catch (Exception e) {
            System.out.println("Error retrieving stats box text: " + e.getMessage());
            return "";
        }
    }

    /*public boolean checkStatsAndResetIFNoRecords(int i) throws Throwable {
        try {
            WebElement statsBox = getStatsboxText();
            String statsText = statsBox.getText();
            System.out.println("Rollback [5] using getText:" + statsText);
            return statsText.contains("Totaal no. of record will be updated=0");
        } catch (Exception e) {
            System.out.println("Stats box not found or error occoured:" + e.getMessage());
            return false;
        }
    }*/

    public boolean checkStatsAndResetIFNoRecords(int i) throws Throwable {
        try {
            String statsText = getStatsboxText();
            System.out.println("Rollback [" + i + "] Stats Text:\n" + statsText);

            // Normalize and check each line
            String[] lines = statsText.split("\\r?\\n");
            for (String line : lines) {
                if (line.trim().contains("Total no. of records will be updated=0") ||
                        line.trim().contains("Totaal no. of record will be updated=0") ||
                        line.trim().contains("Total record will be affected=0")) {

                    System.out.println("No records to update for query " + i + ". Clicking Reset.");
                    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
                    try {
                        WebElement resetButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"react-root\"]/div/div/div[3]/aside/nav/ul/li[5]/a")));
                        resetButton.click();
                        System.out.println("Reset button clicked successfully.");
                    } catch (Exception e) {
                        System.err.println("Failed to click reset button: " + e.getMessage());
                        return false; // Fail gracefully and continue processing
                    }
                    return true; // Skip this query
                }
            }
        } catch (Exception e) {
            System.out.println("Error checking stats box: " + e.getMessage());
        }
        return false; // Continue processing if no match

    }



    public void passDataInPastScriptArea(String query) throws Throwable {

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(PastScriptArea));
        ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", PastScriptArea);
        Thread.sleep(1000);
        action.click(getDriver(), PastScriptArea);

        Thread.sleep(1000);
        ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("arguments[0].value = arguments[1];"
                + "arguments[0].dispatchEvent (new Event ('input',{bubbles: true}));"
                + "arguments[0].dispatchEvent(new Event('change',{bubbles: true}));", PastScriptArea, query);

        // Clear using JS first (if normal clear doesn't work)
        //((JavascriptExecutor) getDriver()).executeScript("arguments[0].value = '';", PastRollBackArea);
        action.click(getDriver(), PastScriptArea);
        PastScriptArea.sendKeys(Keys.CONTROL,Keys.END);
        PastScriptArea.sendKeys(Keys.CONTROL,Keys.END);
        PastScriptArea.sendKeys(Keys.ENTER);
        //PastRollBackArea.sendKeys("  ");
        // Click the field to focus and type
        PastScriptArea.click();

        //action.type(PastScriptArea, query);

    }

    public void ClickonGenerateRollBack() throws Throwable {

        action.click(getDriver(), GenerateRollBackButton);

    }

    public String taketextfromRollBackTextArea(int index) throws Throwable{
        String RollBackText = RollBackTextArea.getText();
        System.out.println("RollBack Output ["+index+"] using getTxt" + RollBackText);
        String RollBack1 = RollBackTextArea.getText();
        System.out.println(RollBack1);
        return RollBackText;
    }

   /* public void taketextfromRollBackTextArea2() throws Throwable{
        String RollBack2 = RollBackTextArea.getText();
        System.out.println(RollBack2);
    }*/




    public void ClickonResetButton() throws Throwable {

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(90));
        WebElement resetButton = wait.until(ExpectedConditions.elementToBeClickable(ResetButton));
        resetButton.click();
        /*action.isEnabled(getDriver(), ResetButton);
        action.JSClick(getDriver(),ResetButton);*/
    }

    public void ClickonResetButton2() throws Throwable {

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(90));
        WebElement resetButton = wait.until(ExpectedConditions.elementToBeClickable(ResetButton2));
        resetButton.click();
        /*action.isEnabled(getDriver(), ResetButton);
        action.JSClick(getDriver(),ResetButton);*/
    }

    public void ClickonSubmitQuery() throws Throwable{

        action.click(getDriver(), SubmitQuery);
    }

}




