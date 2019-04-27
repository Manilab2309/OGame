package ogame.webpages;

import ogame.exceptions.OGameNoSuchWebElementException;
import ogame.util.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LobbyPage {

    WebDriver driver;


    public LobbyPage(WebDriver driver) {

        this.driver = driver;

    }

    public WebElement getAttackTooltip() {

        WebElement attackTooltip = null;

        try {
            attackTooltip = driver.findElement(By.id("attack_alert"));
        }
        catch(Exception exc){
            throw new OGameNoSuchWebElementException(exc.getMessage());
        }
        return attackTooltip;
    }



}
