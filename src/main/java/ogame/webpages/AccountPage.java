package ogame.webpages;

import ogame.util.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Constants.SeleniumConfig.OGAME_SLEEP_TIME);
    }

    public WebElement getJugarBtn() {

        WebElement jugarBtn = wait.until(ExpectedConditions.elementToBeClickable(By.className("btn-primary")));
        //Actions actions = new Actions(driver);

        //actions.moveToElement(jugarBtn).click().perform();
        return jugarBtn;
    }

    public WebElement getCookiePolicyBtn() {

        WebElement cookiePolicyBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("accept_btn")));
        return cookiePolicyBtn;
    }

}
