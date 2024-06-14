package WalrusSmartHomeApp.house_model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Room_Connection {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Connection connection;

    @ManyToOne
    private Room room;

    public Room_Connection(Connection connection, Room room){
        this.connection = connection;
        this.room = room;
    }
}
