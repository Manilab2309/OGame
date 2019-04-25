package ogame.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HubLoginPage {

    WebDriver driver;
    WebDriverWait wait;


    public HubLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public WebElement getJugarBtn() {

        WebElement jugarBtn = driver.findElement(By.cssSelector("button"));
        return jugarBtn;
    }

    public WebElement getCookiePolicyBtn() {

        WebElement cookiePolicyBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("accept_btn")));
        return cookiePolicyBtn;
    }
}
