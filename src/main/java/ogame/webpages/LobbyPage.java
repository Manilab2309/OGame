package ogame.webpages;

import ogame.exceptions.NoSuchWebElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LobbyPage {

    WebDriver driver;
    WebDriverWait wait;

    public LobbyPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getAttackTooltip() {

        WebElement attackTooltip = null;

        try {
            attackTooltip = driver.findElement(By.id("attack_alert"));
        }
        catch(Exception exc){
            throw new NoSuchWebElementException(exc.getMessage());
        }
        return attackTooltip;
    }



}
