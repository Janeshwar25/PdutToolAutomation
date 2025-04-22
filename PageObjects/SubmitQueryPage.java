package myproject.PageObjects;

import myproject.QueryProcessor.Action;
import myproject.QueryProcessor.BaseClass;
import myproject.QueryProcessor.updatedSqlQuery;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SubmitQueryPage extends BaseClass {


    Action action= new Action();

    @FindBy(xpath="//*[@id=\"select\"]/option[9]")
    private WebElement SelectApp;

    @FindBy(xpath="//*[@id=\"ticket-id-input\"]")
    private WebElement Ticketidinput;

    @FindBy(xpath="//*[@id=\"main\"]/div[2]/div[6]/div[1]/fieldset/ul/li[2]/div/label")
    private WebElement PastScriptRadiobutton;

    @FindBy(xpath="//*[@id=\"scripts-input-textarea\"]")
    private WebElement PastScriptArea;

    @FindBy(xpath="/html/body/div/div/div/div[3]/main/div[2]/div[8]/div/textarea")
    private WebElement PastRollBackArea;

    @FindBy(xpath="//*[@id=\"main\"]/div[2]/button[1]")
    private WebElement SubmitButton;

    @FindBy (xpath = "//*[@id=\"select\"]")
    private WebElement SelectAppFromDropDown;

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div[3]/button")
    private WebElement YesPopup;

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

    public void TicketIDValue () throws Throwable {
        action.type(Ticketidinput, "NA");
    }


    public void fillAndSubmitQuery(String rollback, String sqlQuery) throws Throwable{
        clickOnSelectApp();
        TicketIDValue();
        passDataInPastScriptArea(sqlQuery);
        passDataInPastRollBackArea(rollback);
        clickOnSubmitButton();
    }


    public void passDataInPastScriptArea(String sql) throws Throwable {
        action.type(PastScriptArea, sql);

    }

    public void passDataInPastRollBackArea(String rollback) throws Throwable {
        action.type(PastRollBackArea, rollback );
    }

    public void clickOnSubmitButton() throws Throwable {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(90));
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(SubmitButton));
        submitButton.click();

    }

    public void clickOnYesPopup() throws Throwable {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(90));
        WebElement popupButton = wait.until(ExpectedConditions.elementToBeClickable(YesPopup));
        popupButton.click();

    }

}



