package WalrusSmartHomeApp.events;


import java.time.LocalDate;

public class LeavingWithWindowOpen extends Event{

    public LeavingWithWindowOpen(LocalDate timestamp) {
        super(timestamp);
    }
/*
    public static boolean areConditionsMet(Map<String, String> signal, House house) {
        if (signal.get("senzor-where") == null || signal.get("data") == null){
            return false;
        }
        if ((signal.get("senzor-where").equals("entrance_door',")) && signal.get("data").equals("false")) {
            boolean windowsAreClosed = true;
            for (Connection c : house.getConnectionList()) {
                if ((c.getDescription().contains("window")) && !c.getCon) {
                    windowsAreClosed = false;
                    openWindows.add(c);
                }
            }

            if (!windowsAreClosed) {
                return true;
            }
        }
        return false;
    }*/
}
