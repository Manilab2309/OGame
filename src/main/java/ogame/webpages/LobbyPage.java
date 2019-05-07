package ogame.webpages;

import ogame.exceptions.OGameNoSuchWebElementException;

import ogame.util.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LobbyPage {

    private WebDriver driver;
    private WebDriverWait wait;


    public LobbyPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Constants.SeleniumConfig.OGAME_SLEEP_TIME);

    }

    public WebElement getAttackTooltip() {

        WebElement attackTooltip = null;

        try {
            attackTooltip = wait.until(ExpectedConditions.elementToBeClickable(By.id("attack_alert")));
        }
        catch(Exception exc){
            throw new OGameNoSuchWebElementException(exc.getMessage());
        }
        return attackTooltip;
    }



}
