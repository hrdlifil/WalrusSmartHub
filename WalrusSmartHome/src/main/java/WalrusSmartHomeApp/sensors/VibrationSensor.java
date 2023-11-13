package WalrusSmartHomeApp.sensors;

import WalrusSmartHomeApp.house_model.Room;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import WalrusSmartHomeApp.sensor_entities.VibrationSensorEntity;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class VibrationSensor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private VibrationSensorEntity vibrationSensorEntity;
    private String description;
    private String sensorIdentification;
    private boolean vibration;
    private double temperature;
    private int angleX;
    private int angleY;
    private int angleZ;
    private int angleXAbsolute;
    private int angleYAbsolute;
    private int angle;
    private String timeStamp;

}
