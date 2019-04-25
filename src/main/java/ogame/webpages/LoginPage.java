package ogame.webpages;

import ogame.util.Browser;
import ogame.util.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getCookiePolicyBtn() {
        WebElement cookiePolicyBtn = driver.findElement(By.id("accept_btn"));
        return cookiePolicyBtn;
    }

    public WebElement getTabEntrar() {
        WebElement tabEntrar = driver.findElement(By.id("ui-id-1"));
        return tabEntrar;
    }

    public WebElement getTxtEmail() {
        WebElement txtEmail = driver.findElement(By.id("usernameLogin"));
        return txtEmail;
    }

    public WebElement getTxtPass() {
        WebElement txtPass = driver.findElement(By.id("passwordLogin"));
        return txtPass;
    }

    public WebElement getEntrarBtn() {
        WebElement entrarBtn = driver.findElement(By.id("loginSubmit"));
        return entrarBtn;
    }
}
