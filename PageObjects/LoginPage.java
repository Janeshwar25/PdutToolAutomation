package myproject.PageObjects;
import myproject.QueryProcessor.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import myproject.QueryProcessor.Action;


public class LoginPage extends BaseClass {

    Action action= new Action();

    @FindBy(id="username")
    private WebElement userName;

    @FindBy(id="password")
    private WebElement password;

    @FindBy(xpath="//*[@id=\"main\"]/div/div[2]/form/button/span")
    private WebElement signInBtn;



    public LoginPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public HomePage login(String uname, String pswd) throws Throwable {

        action.type(userName, uname);
        action.type(password, pswd);
        action.JSClick(getDriver(), signInBtn);
        Thread.sleep(2000);

        HomePage homePage = new HomePage();
        return new HomePage();
    }



}






