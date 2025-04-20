package myproject.PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import myproject.QueryProcessor.BaseClass;
import myproject.QueryProcessor.Action;
import myproject.QueryProcessor.updatedSqlQuery;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;


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

    @FindBy(xpath = "//*[@id=\"main\"]/div[2]/div[4]/button[2]/span")
    private WebElement ResetButton;
    private updatedSqlQuery sqlQueryPrcessor;

    public RollBackQueryPage() {
        PageFactory.initElements(getDriver(), this);
        this.sqlQueryPrcessor = new updatedSqlQuery();

    }


    public void clickOnSelectApp() throws Throwable {
        action.click(getDriver(), ClickOnSelectAppDropDown);
        Select dropdown = new Select(SelectAppFromDropDown);
        dropdown.selectByVisibleText("cirrus_alpha_rso_01");
        action.click(getDriver(), PastScriptRadiobutton);
        action.click(getDriver(), PastScriptArea);

    }



    public void passDataInPastScriptArea(String query) throws Throwable {

        sqlQueryPrcessor.collectUserInput();

        action.type(PastScriptArea, query);

        /*updatedSqlQuery UpdatedSqlQuery = new updatedSqlQuery();
        String[] queries = UpdatedSqlQuery.getUpdatedQueries();
        String queryToExecute = updatedSqlQueries[0];
        action.click(getDriver(), PastScriptArea);
        action.type(PastScriptArea, queryToExecute);*/

    }


    }





