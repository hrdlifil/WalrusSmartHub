package WalrusSmartHomeApp.sensors;

import WalrusSmartHomeApp.house_model.Connection;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import WalrusSmartHomeApp.sensor_entities.ContactSensorEntity;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ContactSensor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private ContactSensorEntity contactSensorEntity;
    @ManyToOne
    private Connection connection;
    private String description;
    private String sensorIdentification;
    private boolean contact;
    private boolean isOnContactSensorEntity;
    private boolean isOnConnection;
    private double temperature;
    private String timeStamp;

}

