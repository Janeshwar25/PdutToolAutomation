package myproject.PageObjects;

import myproject.QueryProcessor.Action;
import myproject.QueryProcessor.BaseClass;
import myproject.QueryProcessor.updatedSqlQuery;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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

    @FindBy(xpath="//*[@id=\"main\"]/div[2]/button[1]/span")
    private WebElement SubmitButton;

    @FindBy (xpath = "//*[@id=\"select\"]")
    private WebElement SelectAppFromDropDown;

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


    public void passDataInPastScriptArea() throws Throwable {
        action.type(PastScriptArea, );

    }

    public void passDataInPastRollBackArea() throws Throwable {
        action.type(PastRollBackArea, )
    }

    public void clickOnSubmitButton() throws Throwable {
        action.click(getDriver(), SubmitButton);

    }

}



