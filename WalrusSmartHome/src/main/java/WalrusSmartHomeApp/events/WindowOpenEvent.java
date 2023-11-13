package WalrusSmartHomeApp.events;


import java.time.LocalDate;
import java.util.Map;

public class WindowOpenEvent extends Event{
    public WindowOpenEvent(LocalDate timestamp) {
        super(timestamp);
    }

    public static Boolean areConditionsMet(Map<String, String> signal) {
        if (signal.get("senzor-where") == null || signal.get("data") == null){
            return false;
        }
        if ((signal.get("senzor-where").equals("window',")) && signal.get("data").equals("false")) {
            return true;
        }
        return false;
    }
}

