package myproject.PageObjects;

import myproject.QueryProcessor.Action;
import myproject.QueryProcessor.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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



    public SubmitQueryPage() {
        PageFactory.initElements(getDriver(), this);
    }


    public void clickOnSelectApp() throws Throwable {
        action.click(getDriver(), SelectApp);
    }

    public void TicketIDValue (String NA) throws Throwable {
        action.type(Ticketidinput, "NA");
    }


    public void clickOnPastScriptArea() throws Throwable {
        action.click(getDriver(), PastScriptArea);
    }

    public void clickOnPastRollBackArea() throws Throwable {
        action.click(getDriver(), PastRollBackArea);
    }

    public void clickOnSubmitButton() throws Throwable {
        action.click(getDriver(), SubmitButton);

    }

}



