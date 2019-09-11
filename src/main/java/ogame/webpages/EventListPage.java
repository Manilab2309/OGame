package ogame.webpages;

import ogame.entity.Event;
import ogame.util.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class EventListPage {

    private WebDriver driver;
    private WebDriverWait wait;

    /** Logger */
    private static final Logger logger = LoggerFactory.getLogger(EventListPage.class);

    public EventListPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Constants.SeleniumConfig.OGAME_SLEEP_TIME);
    }

    public List<Event> getArrivalAttackTime() {

        List<Event> hostileEvents = new ArrayList<Event>();

        WebElement eventTable = driver.findElement(By.id("eventContent"));
        List<WebElement> rows = eventTable.findElements(By.tagName("tr"));

        int i = 0;
        //Print data from each row (Data from each td tag)
        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));

            String arrivalTime = "";
            String originFleet = "";
            String destFleet = "";

            Event event = new Event(originFleet, arrivalTime, destFleet);

            if (cols.get(i).getAttribute("class").contains("hostile")) {
                for (WebElement col : cols) {
                    // parse event hostile information
                    String type = col.getAttribute("class");

                    if (type.contains("arrivalTime")) {
                        event.setArrivalTime(col.getText());
                        logger.info(col.getText() + "\t");
                    } else if (type.contains("originFleet")) {
                        event.setOriginFleet(col.getText());
                        logger.info(col.getText() + "\t");
                    } else if (type.contains("destFleet")) {
                        event.setDestination(col.getText());
                        logger.info(col.getText() + "\t");
                    }
                }
            }
            if (!event.getArrivalTime().equalsIgnoreCase("")
                    && !event.getDestination().equalsIgnoreCase("")
                    && !event.getOriginFleet().equalsIgnoreCase("")) {
                        hostileEvents.add(event);
            }
            // index row table increased
            i++;
        }
        return hostileEvents;
    }

}

