package WalrusSmartHomeApp.sensors;

import WalrusSmartHomeApp.house_model.Room;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import WalrusSmartHomeApp.sensor_entities.ElectricSensorEntity;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ElectricSensor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Room room;
    @OneToOne
    private ElectricSensorEntity electricSensorEntity;
    private String description;
    private String sensorIdentification;
    private boolean power;
    private double voltage;
    private double energy;
    private double current;
    private String timeStamp;
}

