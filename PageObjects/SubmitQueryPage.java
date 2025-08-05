package myproject.PageObjects;

import myproject.QueryProcessor.Action;
import myproject.QueryProcessor.BaseClass;
import myproject.QueryProcessor.updatedSqlQuery;
import org.bouncycastle.jcajce.provider.asymmetric.X509;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SubmitQueryPage extends BaseClass {


    Action action = new Action();

    @FindBy(xpath = "//*[@id=\"main\"]/div[2]/div[2]/div/div/div/div/div/fieldset")
    private WebElement SelectApp;

    @FindBy(xpath = "//*[@id=\"ticket-id-input\"]")
    private WebElement Ticketidinput;

    @FindBy(css = "#scripts-input-textarea")
    private WebElement FormControlcomponent;

    @FindBy(xpath = "//*[@id=\"main\"]/div[2]/div[6]/div[1]/fieldset/ul/li[2]/div/label")
    private WebElement PastScriptRadiobutton;

    @FindBy(xpath = "//*[@id=\"scripts-input-textarea\"]")
    private WebElement PastScriptArea;

    @FindBy(xpath = "//*[@id=\"rollback-query-input\"]")
    private WebElement PastRollBackArea;

    @FindBy(xpath = "//*[@id=\"main\"]/div[2]/div[2]/div[2]/div[9]/button[1]")
    private WebElement SubmitButton;

    @FindBy(css = "#main > div.MuiContainer-root.MuiContainer-maxWidthLg.css-m8ifx4 > div.MuiPaper-root.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation2.MuiCard-root.css-10jbveu > div > div > div > div > div > svg")
    private WebElement SelectAppFromDropDown;

    @FindBy(css = "#main > div.MuiContainer-root.MuiContainer-maxWidthLg.css-m8ifx4 > div.MuiPaper-root.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation2.MuiCard-root.css-10jbveu > div > div > div > div > div > svg")
    private WebElement clickonSelectAppFromDropDown;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div[2]/button[1]")
    private WebElement YesPopup;


    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div[2]/button")
    private WebElement ConfirmationButton;

    @FindBy( xpath = "//*[@id=\"main\"]/div[2]/div[2]/div/div/div/div[2]/div[46]/span" )
    private WebElement alpharso1;

    @FindBy(xpath = "//*[@id=\"main\"]/div[2]/div[2]/div/h6")
    private WebElement OuterAreaClick;

    @FindBy(css = "#\\:r0\\:")
    private WebElement enterappnamearea;

    private updatedSqlQuery sqlQueryPrcessor;


    public SubmitQueryPage() {
        PageFactory.initElements(getDriver(), this);
        this.sqlQueryPrcessor = new updatedSqlQuery();
    }


    public void clickOnSelectApp() throws Throwable {

        WebElement dropdownIcon = getDriver().findElement(By.cssSelector("svg.MuiSvgIcon-root"));
        dropdownIcon.click();
        WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(5));
        WebElement optionToSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main\"]/div[2]/div[2]/div/div/div/div[2]/div[44]")));
        optionToSelect.click();


        //action.click(getDriver(), SelectAppFromDropDown);
        /*Select dropdown = new Select(SelectAppFromDropDown);
        dropdown.selectByVisibleText("gcp_cirrus_alpha_rso_01");*/
        //action.JSClick(getDriver(), SelectAppFromDropDown);
        //action.click(getDriver(), SelectAppFromDropDown);
        /*WebElement option = getDriver().findElement(By.cssSelector("#main > div.MuiContainer-root.MuiContainer-maxWidthLg.css-m8ifx4 > div.MuiPaper-root.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation2.MuiCard-root.css-10jbveu > div > div > div > div > div > svg"));
        option.click();*/

        /*Select dropdown = new Select(SelectAppFromDropDown);
        action.scrollByVisibilityOfElement(getDriver(),SelectAppFromDropDown);
        //dropdown.selectByValue("gcp_cirrus_alpha_rso_01");
        dropdown.selectByVisibleText("gcp_cirrus_alpha_rso_01");
        //action.click(getDriver(), alpharso1);*/
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
        ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", PastScriptArea);
        Thread.sleep(1000);
        action.click(getDriver(), PastScriptArea);
        /*JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("argument[0].value = argument[1];",PastRollBackArea,rollback);*/
        //PastRollBackArea.clear();
        Thread.sleep(1000);
        ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("arguments[0].value = arguments[1];"
                + "arguments[0].dispatchEvent (new Event ('input',{bubbles: true}));"
                + "arguments[0].dispatchEvent(new Event('change',{bubbles: true}));", PastScriptArea, sql);

        // Clear using JS first (if normal clear doesn't work)
        //((JavascriptExecutor) getDriver()).executeScript("arguments[0].value = '';", PastRollBackArea);
        action.click(getDriver(), PastScriptArea);
        ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", FormControlcomponent);
        PastScriptArea.sendKeys(Keys.CONTROL,Keys.END);
        PastScriptArea.sendKeys(Keys.CONTROL,Keys.END);
        PastScriptArea.sendKeys(Keys.ENTER);
        //PastRollBackArea.sendKeys("  ");
        // Click the field to focus and type
        PastScriptArea.click();
        Thread.sleep(1000);

        //action.type(PastScriptArea, sql);

    }

    public void passDataInPastRollBackArea(String rollback) throws Throwable {

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(PastRollBackArea));
        ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", PastRollBackArea);
        Thread.sleep(1000);
        action.click(getDriver(), PastRollBackArea);
        /*JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("argument[0].value = argument[1];",PastRollBackArea,rollback);*/
        //PastRollBackArea.clear();
        Thread.sleep(1000);
        ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("arguments[0].value = arguments[1];"
                + "arguments[0].dispatchEvent (new Event ('input',{bubbles: true}));"
                + "arguments[0].dispatchEvent(new Event('change',{bubbles: true}));", PastRollBackArea, rollback);

        // Clear using JS first (if normal clear doesn't work)
        //((JavascriptExecutor) getDriver()).executeScript("arguments[0].value = '';", PastRollBackArea);
        action.click(getDriver(), PastRollBackArea);
        ((org.openqa.selenium.JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", FormControlcomponent);
        PastRollBackArea.sendKeys(Keys.CONTROL,Keys.END);
        PastRollBackArea.sendKeys(Keys.CONTROL,Keys.END);
        PastRollBackArea.sendKeys(Keys.ENTER);
        //PastRollBackArea.sendKeys("  ");
        // Click the field to focus and type
        PastRollBackArea.click();


        Thread.sleep(1000);
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




