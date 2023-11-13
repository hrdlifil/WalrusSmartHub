package WalrusSmartHomeApp.sensors;

import WalrusSmartHomeApp.house_model.Room;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MotionSensor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Room room;
    private String description;
    private String sensorIdentification;
    private String timeStamp;
    private boolean occupancy;

}
