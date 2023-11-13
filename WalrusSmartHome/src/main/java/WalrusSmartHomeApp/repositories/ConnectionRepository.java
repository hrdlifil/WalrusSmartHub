package WalrusSmartHomeApp.repositories;

import WalrusSmartHomeApp.house_model.Connection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConnectionRepository extends JpaRepository<Connection, Long> {
}
