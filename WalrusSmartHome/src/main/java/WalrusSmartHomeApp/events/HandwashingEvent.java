package WalrusSmartHomeApp.events;


import java.time.LocalDate;
import java.util.Map;

public class HandwashingEvent extends Event{
    public HandwashingEvent(LocalDate timestamp) {
        super(timestamp);
    }

    public static Boolean areConditionsMet(Map<String, String> signal) {
        if (signal.get("senzor-where") == null || signal.get("data") == null || signal.get("senzor") == null){
            return false;
        }
        if ((signal.get("senzor-where").equals("restroom',")) && signal.get("data").equals("true") && signal.get("senzor").equals("acceleration")) {
            return true;
        }
        return false;
    }

}
