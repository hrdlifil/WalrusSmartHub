package WalrusSmartHomeApp.events;

import WalrusSmartHomeApp.house_model.House;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class EventFactory {
    public Optional<Event> createEvent(Map<String, String> signal, House house) {
        if (HomecomingEvent.areConditionsMet(signal, house)) {
            return Optional.of(new HomecomingEvent(LocalDate.now()));
        } else if (HandwashingEvent.areConditionsMet(signal, house)) {
            return Optional.of(new HandwashingEvent(LocalDate.now()));
        } else if (EntranceDoorclosingEvent.areConditionsMet(signal, house)) {
            return Optional.of(new EntranceDoorclosingEvent(LocalDate.now()));
        } else if (FridgeOpenEvent.areConditionsMet(signal, house) ) {
            return Optional.of(new FridgeOpenEvent(LocalDate.now()));
        } else if (FridgeCloseEvent.areConditionsMet(signal, house) ) {
            return Optional.of(new FridgeCloseEvent(LocalDate.now()));
        } else if (LeavingWithWindowOpen.areConditionsMet(signal, house)) {
            return Optional.of(new LeavingWithWindowOpen(LocalDate.now()));
        } else if (WindowOpenEvent.areConditionsMet(signal)) {
            return Optional.of(new WindowOpenEvent(LocalDate.now()));
        }
        else if (ElectricPlateCookingEvent.areConditionsMet(signal, house)) {
            return Optional.of(new ElectricPlateCookingEvent(LocalDate.now()));
        } else if (ElectricPlateNotCookingEvent.areConditionsMet(signal, house)) {
            return Optional.of(new ElectricPlateNotCookingEvent(LocalDate.now()));
        }
        return Optional.empty();
    }
}
