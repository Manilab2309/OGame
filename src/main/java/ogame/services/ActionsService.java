package ogame.services;

import ogame.entity.Event;
import ogame.exceptions.OGameNoSuchWebElementException;

import java.util.List;

public interface ActionsService {

    /** Check if your planet is under attack*/
    void checkStatus() throws OGameNoSuchWebElementException;

    /** Get out full fleet with full resources*/
    void fleetEvacuation();

    /** Send an email notification */
    void sendMailMessage(List<Event> invasionListDetails);

}
