package ogame.webpages;

import ogame.application.OGameApplication;
import ogame.util.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

import static java.util.concurrent.TimeUnit.SECONDS;

public class HubLoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    /** Logger */
    private static final Logger logger = LoggerFactory.getLogger(HubLoginPage.class);


    public HubLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15, 100);
    }

    public WebElement getJugarBtn() {

        WebElement jugarBtn = wait.until(ExpectedConditions.elementToBeClickable(By.className("button")));
        return jugarBtn;
    }

    public WebElement getCookiePolicyBtn() {

        WebElement cookiePolicyBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("accept_btn")));
        return cookiePolicyBtn;
    }
}
