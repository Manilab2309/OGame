package ogame.webpages;

import ogame.util.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Constants.SeleniumConfig.OGAME_SLEEP_TIME);
    }

    public WebElement getCookiePolicyBtn() {
        WebElement cookiePolicyBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("accept_btn")));
        return cookiePolicyBtn;
    }

    public WebElement getTabEntrar() {

        List<WebElement> tabList=driver.findElements(By.id("loginRegisterTabs"));
        WebElement tabEntrar = tabList.get(0).findElement(By.tagName("span"));

        return tabEntrar;
    }

    public WebElement getTxtEmail() {
        WebElement txtEmail = wait.until(ExpectedConditions.elementToBeClickable(By.name("email")));
        return txtEmail;
    }

    public WebElement getTxtPass() {
        WebElement txtPass = wait.until(ExpectedConditions.elementToBeClickable(By.name("password")));
        return txtPass;
    }

    public WebElement getEntrarBtn() {
        WebElement entrarBtn = wait.until(ExpectedConditions.elementToBeClickable(By.tagName("button")));
        return entrarBtn;
    }
}
