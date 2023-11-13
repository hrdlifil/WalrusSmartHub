package WalrusSmartHomeApp.sensor_entities;

import WalrusSmartHomeApp.house_model.Room;
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
public class ContactSensorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    @ManyToOne
    private Room room;
    @OneToMany(mappedBy = "contactSensorEntity")
    private List<ContactSensor> contactSensorList;
}
