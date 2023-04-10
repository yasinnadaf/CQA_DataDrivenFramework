package pages;

import com.bridgelabz.selenium.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard extends BaseClass {
    @FindBy(xpath = "//header/div[1]/nav[1]/ul[1]/li[3]/a[1]/div[1]/div[1]/li-icon[1]/*[1]")
    WebElement jobBtn;

    public Dashboard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean homeTestValidation() {
        Boolean flag = jobBtn.isDisplayed();
        return flag;
    }
}