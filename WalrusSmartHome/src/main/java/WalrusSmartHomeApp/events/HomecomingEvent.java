package WalrusSmartHomeApp.events;

import WalrusSmartHomeApp.house_model.House;
import WalrusSmartHomeApp.house_model.Room;
import WalrusSmartHomeApp.sensors.MotionSensor;

import java.time.LocalDate;
import java.util.Map;

public class HomecomingEvent extends Event {

    public HomecomingEvent(LocalDate timestamp) {
        super(timestamp);
    }

    public static boolean areConditionsMet(Map<String, String> signal, House house) {
        if (signal.get("senzor-where") == null || signal.get("data") == null) {
            return false;
        }
        if ((signal.get("senzor-where").equals("entrance_door',")) && signal.get("data").equals("false")) {
            boolean allIsEmpty = true;
            for (Room r : house.getRoomList()) {
                for (MotionSensor m : r.getMotionSensorList()) {
                    if (m.isOccupancy()) {
                        allIsEmpty = false;
                        break;
                    }
                }
            }

            return allIsEmpty;
        }
        return false;
    }
}


