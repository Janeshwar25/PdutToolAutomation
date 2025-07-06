package myproject.PageObjects;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import myproject.QueryProcessor.BaseClass;
import myproject.QueryProcessor.Action;
import myproject.QueryProcessor.updatedSqlQuery;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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

    @FindBy(xpath = "//*[@id=\"scripts-input-textarea\"]")
    private WebElement PastScriptArea;

    @FindBy(xpath = "//*[@id=\"main\"]/div[2]/div[4]/button[1]/span")
    private WebElement GenerateRollBackButton;

    @FindBy(xpath = "//*[@id=\"main\"]/div[2]/div[6]/button[2]")
    private WebElement ResetButton;

    @FindBy(xpath = "//*[@id=\"ticket-id-input\"]")
    private WebElement RollBackTextArea;

    @FindBy(xpath = "//*[@id=\"react-root\"]/div/div/div[3]/aside/nav/ul/li[2]/a/span/span[2]")
    private WebElement SubmitQuery;

    private updatedSqlQuery sqlQueryPrcessor;

    public RollBackQueryPage() {
        PageFactory.initElements(getDriver(), this);
        this.sqlQueryPrcessor = new updatedSqlQuery();

    }


    public void clickOnSelectApp() throws Throwable {
        action.click(getDriver(), ClickOnSelectAppDropDown);
        Select dropdown = new Select(SelectAppFromDropDown);
        dropdown.selectByVisibleText("gcp_cirrus_alpha_rso_01");
        action.click(getDriver(), PastScriptRadiobutton);
        action.click(getDriver(), PastScriptArea);

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



        /*updatedSqlQuery UpdatedSqlQuery = new updatedSqlQuery();
        String[] queries = UpdatedSqlQuery.getUpdatedQueries();
        String queryToExecute = updatedSqlQueries[0];
        action.click(getDriver(), PastScriptArea);
        action.type(PastScriptArea, queryToExecute);*/

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

    public void ClickonSubmitQuery() throws Throwable{

        action.click(getDriver(), SubmitQuery);
    }

}





