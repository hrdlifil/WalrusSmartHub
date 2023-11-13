package WalrusSmartHomeApp.repositories;

import WalrusSmartHomeApp.house_model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
