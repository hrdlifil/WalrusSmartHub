package WalrusSmartHomeApp.events;

import WalrusSmartHomeApp.house_model.House;

import java.time.LocalDate;
import java.util.Map;

public class ElectricPlateNotCookingEvent extends Event{

    public ElectricPlateNotCookingEvent(LocalDate timestamp) {
        super(timestamp);
    }

    public static boolean areConditionsMet(Map<String, String> signal, House house) {
        if (signal.get("data") == null || signal.get("senzor") == null || signal.get("senzor-where") == null){
            return false;
        }
        if (signal.get("data").equals("false") && signal.get("senzor").equals("electric") && signal.get("senzor-where").equals("hotplate',")){
            return true;
        }
        return false;
    }
}
