package myproject.PageObjects;

import myproject.QueryProcessor.Action;
import myproject.QueryProcessor.BaseClass;
import myproject.QueryProcessor.updatedSqlQuery;
import org.bouncycastle.jcajce.provider.asymmetric.X509;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SubmitQueryPage extends BaseClass {


    Action action = new Action();

    @FindBy(xpath = "//*[@id=\"select\"]/option[9]")
    private WebElement SelectApp;

    @FindBy(xpath = "//*[@id=\"ticket-id-input\"]")
    private WebElement Ticketidinput;

    @FindBy(xpath = "//*[@id=\"main\"]/div[2]/div[6]/div[1]/fieldset/ul/li[2]/div/label")
    private WebElement PastScriptRadiobutton;

    @FindBy(xpath = "//*[@id=\"scripts-input-textarea\"]")
    private WebElement PastScriptArea;

    @FindBy(xpath = "/html/body/div/div/div/div[3]/main/div[2]/div[8]/div/textarea")
    private WebElement PastRollBackArea;

    @FindBy(xpath = "//*[@id=\"main\"]/div[2]/button[1]")
    private WebElement SubmitButton;

    @FindBy(xpath = "//*[@id=\"select\"]")
    private WebElement SelectAppFromDropDown;

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div[3]/button")
    private WebElement YesPopup;

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div[3]/button")
    private WebElement ConfirmationButton;

    private updatedSqlQuery sqlQueryPrcessor;


    public SubmitQueryPage() {
        PageFactory.initElements(getDriver(), this);
        this.sqlQueryPrcessor = new updatedSqlQuery();
    }


    public void clickOnSelectApp() throws Throwable {
        action.click(getDriver(), SelectAppFromDropDown);
        Select dropdown = new Select(SelectAppFromDropDown);
        dropdown.selectByVisibleText("cirrus_alpha_rso_01");
    }

    public void TicketIDValue() throws Throwable {
        action.type(Ticketidinput, "NA");
    }


    public void fillAndSubmitQuery(String rollback, String sqlQuery) throws Throwable {
        clickOnSelectApp();
        TicketIDValue();
        passDataInPastScriptArea(sqlQuery);
        passDataInPastRollBackArea(rollback);
        clickOnSubmitButton();
    }


    public void passDataInPastScriptArea(String sql) throws Throwable {

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(PastScriptArea));
        wait.until(ExpectedConditions.elementToBeClickable(PastScriptArea));
        /*JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("argument[0].value = argument[1];",PastRollBackArea,sql);
        PastScriptArea.clear();*/
        ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", PastScriptArea);
        Thread.sleep(2000);
        PastScriptArea.clear();
        Thread.sleep(2000);
        action.type(PastScriptArea, sql);

    }

    public void passDataInPastRollBackArea(String rollback) throws Throwable {

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(PastRollBackArea));
        ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", PastRollBackArea);
        Thread.sleep(2000);

        /*JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("argument[0].value = argument[1];",PastRollBackArea,rollback);*/
        PastRollBackArea.clear();
        Thread.sleep(2000);
        ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("arguments[0].value = arguments[1];"
                +"arguments[0].dispatchEvent (new Event ('input',{bubbles: true}));"
                +"arguments[0].dispatchEvent(new Event('change',{bubbles: true}));",PastRollBackArea, rollback);
        //action.type(PastRollBackArea, rollback);
        Thread.sleep(2000);
    }

    public void clickOnSubmitButton() throws Throwable {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(SubmitButton));
        submitButton.click();

    }

    public void clickOnYesPopup() throws Throwable {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        WebElement popupButton = wait.until(ExpectedConditions.elementToBeClickable(YesPopup));
        popupButton.click();

    }

    public void ClickOnConfirmationButton()throws Throwable{
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(ConfirmationButton));
        action.JSClick(getDriver(), ConfirmationButton);
       /* WebElement confirmationButton = wait.until(ExpectedConditions.elementToBeClickable(ConfirmationButton));
        confirmationButton.click();*/
    }

}

public void passDataInPastRollBackArea(String rollback) throws Throwable {
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
    wait.until(ExpectedConditions.visibilityOf(PastRollBackArea));
    ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", PastRollBackArea);
    Thread.sleep(1000);

    // Clear using JS first (if normal clear doesn't work)
    ((JavascriptExecutor) getDriver()).executeScript("arguments[0].value = '';", PastRollBackArea);
    Thread.sleep(500);

    // Click the field to focus and type
    PastRollBackArea.click();
    PastRollBackArea.clear();
    Thread.sleep(1000);

    // Type line by line to simulate real input
    int chunkCount = 4;
    int chunkSize = rollback.length() / chunkCount;
    for (int i = 0; i < chunkCount; i++) {
        int start = i * chunkSize;
        int end = (i == chunkCount - 1) ? rollback.length() : (i + 1) * chunkSize;
        String chunk = rollback.substring(start, end);

        // Send chunk as keys
        PastRollBackArea.sendKeys(chunk);
        Thread.sleep(500); // small delay to mimic natural input
    }

    Thread.sleep(2000); // wait to see if Submit gets enabled
}


