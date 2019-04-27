package ogame.webpages;

import ogame.util.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Constants.SeleniumConfig.OGAME_SLEEP_TIME);
    }

    public WebElement getCookiePolicyBtn() {
        WebElement cookiePolicyBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("accept_btn")));
        return cookiePolicyBtn;
    }

    public WebElement getTabEntrar() {
        WebElement tabEntrar = wait.until(ExpectedConditions.elementToBeClickable(By.id("ui-id-1")));
        return tabEntrar;
    }

    public WebElement getTxtEmail() {
        WebElement txtEmail = wait.until(ExpectedConditions.elementToBeClickable(By.id("usernameLogin")));
        return txtEmail;
    }

    public WebElement getTxtPass() {
        WebElement txtPass = wait.until(ExpectedConditions.elementToBeClickable(By.id("passwordLogin")));
        return txtPass;
    }

    public WebElement getEntrarBtn() {
        WebElement entrarBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginSubmit")));
        return entrarBtn;
    }
}
