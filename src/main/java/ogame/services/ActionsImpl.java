package ogame.services;

import ogame.util.Constants;
import ogame.util.EmailUtil;
import ogame.webpages.LobbyPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

public class ActionsImpl implements ActionsService {

    /** Driver */
    WebDriver driver;

    /** Logger */
    private static final Logger logger = LoggerFactory.getLogger(ActionsImpl.class);

    public ActionsImpl(WebDriver driver) {
        this.driver = driver;
    }

    public void checkStatus() {

        LobbyPage lobbyPage = new LobbyPage(driver);

        if (lobbyPage.getAttackTooltip()!= null){
            logger.info(Constants.Messages.OGAME_DEBUG_PREFIX + "Notificando mail...");
            sendMailMessage();
            logger.info(Constants.Messages.OGAME_DEBUG_PREFIX + "Mail enviado");
        } else{
            logger.info("Sistema despejado");
        }

    }

    public void fleetEvacuation() {

    }

    public void sendMailMessage() {

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

        EmailUtil.sendEmail(session, toEmail,"Planets under attack", "https://s160-es.ogame.gameforge.com/game/index.php?page=overview");

    }
}
