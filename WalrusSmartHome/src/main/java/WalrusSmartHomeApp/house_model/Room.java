package WalrusSmartHomeApp.house_model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import WalrusSmartHomeApp.sensor_entities.ContactSensorEntity;
import WalrusSmartHomeApp.sensor_entities.VibrationSensorEntity;
import WalrusSmartHomeApp.sensors.ElectricSensor;
import WalrusSmartHomeApp.sensors.MotionSensor;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String roomIdentification;
    private String description;

    @OneToMany(mappedBy = "room")
    private List<ContactSensorEntity> contactSensorEntityList;

    @OneToMany(mappedBy = "room")
    private List<ElectricSensor> electricSensorList;

    @OneToMany(mappedBy = "room")
    private List<MotionSensor> motionSensorList;

    @OneToMany(mappedBy = "room")
    private List<VibrationSensorEntity> vibrationSensorEntityList;

    @OneToMany(mappedBy = "room")
    private List<Room_Connection> roomConnectionList;
}

