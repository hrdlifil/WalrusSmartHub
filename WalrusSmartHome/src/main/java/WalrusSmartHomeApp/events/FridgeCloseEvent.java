package WalrusSmartHomeApp.events;


import java.time.LocalDate;
import java.util.Map;

public class FridgeCloseEvent extends Event{

    public FridgeCloseEvent(LocalDate timestamp) {
        super(timestamp);
    }

    public static Boolean areConditionsMet(Map<String, String> signal) {
        if (signal.get("senzor-where") == null || signal.get("data") == null){
            return false;
        }
        if ((signal.get("senzor-where").equals("fridge',")) && signal.get("data").equals("true")) {
            return true;
        }
        return false;
    }
}
