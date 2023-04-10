package pages;

import com.bridgelabz.selenium.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
    @FindBy (id = "session_key")
    WebElement userName;

    @FindBy (id = "session_password")
    WebElement password;

    @FindBy (xpath = "//button[contains(text(),'Sign in')]")
    WebElement loginBtn;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String  loginToInsta(String name, String pass) throws InterruptedException {
        userName.sendKeys(name);
        Thread.sleep(500);
        password.sendKeys(pass);
        Thread.sleep(500);
        loginBtn.click();
        Thread.sleep(500);
        String loginTitle = driver.getTitle();
        return loginTitle;
    }

    public void loginToInsta1(String name) throws InterruptedException {
        userName.sendKeys(name);
        Thread.sleep(500);
    }
}

