package WalrusSmartHomeApp.sensor_entities;

import WalrusSmartHomeApp.house_model.Room;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import WalrusSmartHomeApp.sensors.VibrationSensor;

import java.util.List;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class VibrationSensorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    @ManyToOne
    private Room room;
    @OneToMany(mappedBy = "vibrationSensorEntity")
    private List<VibrationSensor> vibrationSensorList;
 }
