package ogame.services;

import ogame.exceptions.OGameNoSuchWebElementException;
import org.openqa.selenium.WebDriver;

public interface ActionsService {

    /** Check if your planet is under attack*/
    void checkStatus() throws OGameNoSuchWebElementException;

    /** Get out full fleet with full resources*/
    void fleetEvacuation();

    /** Send an email notification */
    void sendMailMessage();

}
