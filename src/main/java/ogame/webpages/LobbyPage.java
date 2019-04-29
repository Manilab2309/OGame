package ogame.webpages;

import ogame.exceptions.OGameNoSuchWebElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LobbyPage {

    private WebDriver driver;


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
