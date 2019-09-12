package ogame.services;

import ogame.entity.Event;
import ogame.util.Constants;
import ogame.util.EmailUtil;
import ogame.webpages.EventListPage;
import ogame.webpages.LobbyPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.List;
import java.util.Properties;

import static java.util.concurrent.TimeUnit.SECONDS;

public class ActionsImpl implements ActionsService {

    /** Driver */
    private WebDriver driver;

    /** Logger */
    private static final Logger logger = LoggerFactory.getLogger(ActionsImpl.class);

    public ActionsImpl(WebDriver driver) {
        this.driver = driver;
    }

    public void test(){

        driver.navigate().to("https://s160-es.ogame.gameforge.com/game/index.php?page=fleet1");
        /*WebDriverWait wait = new WebDriverWait(driver, Constants.SeleniumConfig.OGAME_SLEEP_TIME);
        logger.info("Estamos en: " + driver.getCurrentUrl());
        WebElement root = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("toolbarcomponent")));
        WebElement leftMenuOptions = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("leftmenu")));

        //= driver.findElement(By.id("menuTable"));
        List<WebElement> optionsBtn =  leftMenuOptions.findElements(By.tagName("li"));
        for(WebElement option : optionsBtn)
        {
           logger.info("ul content:-->" + option.getText());
           if (option.getText().equalsIgnoreCase("Flota")){
               //WebElement fleetBtn = driver.findElement(By.tagName("span"));
               WebElement fleetBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("span")));
               fleetBtn.click();
           }
        }
        //WebElement manizoneVII = wait.until(ExpectedConditions.elementToBeClickable(By.tagName("button")));*/
    }
    public void checkStatus() {

        LobbyPage lobbyPage = new LobbyPage(driver);

        if (lobbyPage.getAttackTooltip()!= null){
            driver.navigate().to("https://s160-es.ogame.gameforge.com/game/index.php?page=eventList");
            //logger.info(driver.getPageSource());
            driver.manage().timeouts().setScriptTimeout(5,SECONDS);

            EventListPage eventListPage = new EventListPage(driver);
            List<Event> invasionListDetails = eventListPage.getArrivalAttackTime();

            logger.info(Constants.Messages.OGAME_DEBUG_PREFIX + "Eventos hostiles analizados");

            logger.info(Constants.Messages.OGAME_DEBUG_PREFIX + "Notificando mail...");
            sendMailMessage(invasionListDetails);
            logger.info(Constants.Messages.OGAME_DEBUG_PREFIX + "Mail enviado");
        } else{
            logger.info("Sistema despejado");
        }

    }

    public void viewFleets() {
        LobbyPage lobbyPage = new LobbyPage(driver);

        lobbyPage.getDescollapseButton().click();
        logger.info(Constants.Messages.OGAME_DEBUG_PREFIX + "Actividad desplegada");
    }

    public void fleetEvacuation() {

    }

    public void sendMailMessage(List<Event> invasionListDetails) {

        final String fromEmail = "rcifuster@gmail.com"; //requires valid gmail id
        final String password = "Manila13052017"; // correct password for gmail id
        final String toEmail = "rcifuster@gmail.com"; // can be any email id

        System.out.println("Send email");
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

        //create Authenticator object to pass in Session.getInstance argument
        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };
        Session session = Session.getInstance(props, auth);

        EmailUtil.sendEmail(session, toEmail,"Planets under attack", composeBody(invasionListDetails));

    }

    private String composeBody(List<Event> invasionListDetails) {

        String bodyMail = "";

        for (Event row : invasionListDetails){
            bodyMail = bodyMail +row.getOriginFleet() +" --- " + row.getArrivalTime() + " --- " + row.getDestination();
            bodyMail = bodyMail + "\n";
        }
        bodyMail = bodyMail + "\n" + "https://s160-es.ogame.gameforge.com/game/index.php?page=overview" + "\n"
                + "https://s160-es.ogame.gameforge.com/game/index.php?page=eventList";

        return bodyMail;
    }


}
