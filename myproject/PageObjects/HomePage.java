package myproject.PageObjects;
import myproject.QueryProcessor.Action;
import myproject.QueryProcessor.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends BaseClass {

    Action action= new Action();

    @FindBy(xpath="//*[@id=\"react-root\"]/div/div/div[3]/aside/nav/ul/li[5]/a/span/span[2]")
    private WebElement GenerateRollback;

    @FindBy(xpath = "//*[@id=\"react-root\"]/div/div/div[3]/aside/nav/ul/li[2]/a/span/span[2]")
    private WebElement SubmitQuery;

    public HomePage() {
        PageFactory.initElements(getDriver(), this);
    }


    public boolean validateGenerateRollback() throws Throwable {
        return action.isDisplayed(getDriver(), GenerateRollback);
    }

    public boolean validateSubmitQuery() throws Throwable {
        return action.isDisplayed(getDriver(), SubmitQuery);
    }

    public String getCurrURL() throws Throwable {
        String homePageURL=action.getCurrentURL(getDriver());
        return homePageURL;
    }

    public RollBackQueryPage clickonGenerateRollBack() throws Throwable{
        action.JSClick(getDriver(), GenerateRollback);
        return new RollBackQueryPage();
    }
}
