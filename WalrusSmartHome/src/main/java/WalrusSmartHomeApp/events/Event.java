package WalrusSmartHomeApp.events;

import WalrusSmartHomeApp.house_model.House;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.Map;

@AllArgsConstructor
public abstract class Event {
    private LocalDate timestamp;

    public static boolean areConditionsMet(Map<String, String> signal, House house){
        return false;
    };
}
