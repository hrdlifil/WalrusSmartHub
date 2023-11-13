package WalrusSmartHomeApp.house_model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import WalrusSmartHomeApp.sensors.ContactSensor;

import java.util.List;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Connection {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private String connectionIdentification;
    private boolean isVirtual;
    @OneToMany(mappedBy = "connection")
    private List<ContactSensor> contactSensorList;
    @OneToMany(mappedBy = "connection")
    private List<Room_Connection> roomConnectionList;
}
