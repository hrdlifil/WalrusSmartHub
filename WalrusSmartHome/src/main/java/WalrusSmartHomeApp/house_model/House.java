package WalrusSmartHomeApp.house_model;

import lombok.Getter;
import lombok.Setter;
import WalrusSmartHomeApp.sensor_entities.ContactSensorEntity;
import WalrusSmartHomeApp.sensor_entities.ElectricSensorEntity;
import WalrusSmartHomeApp.sensor_entities.VibrationSensorEntity;
import WalrusSmartHomeApp.sensors.ContactSensor;
import WalrusSmartHomeApp.sensors.ElectricSensor;
import WalrusSmartHomeApp.sensors.MotionSensor;
import WalrusSmartHomeApp.sensors.VibrationSensor;

import java.util.List;

@Setter
@Getter
public class House {
    private List<Room> roomList;
    private List<Connection> connectionList;
    private List<MotionSensor> motionSensorList;
    private List<VibrationSensor> vibrationSensorList;
    private List<ContactSensor> contactSensorList;
    private List<ElectricSensor> electricSensorList;

    public House(){
/*
        var hallwayRoom = new Room();
        hallwayRoom.setDescription("Hallway");
        hallwayRoom.setRoomIdentification("1");

        var outsideRoom = new Room();
        outsideRoom.setDescription("Outside");
        outsideRoom.setRoomIdentification("2");

        var toiletRoom = new Room();
        toiletRoom.setDescription("Toilet");
        toiletRoom.setRoomIdentification("3");

        var restroom = new Room();
        restroom.setDescription("restroom");
        restroom.setRoomIdentification("3");

        var livingRoom = new Room();
        livingRoom.setDescription("Living room");
        livingRoom.setRoomIdentification("4");

        var bedRoom = new Room();
        bedRoom.setDescription("Bedroom");
        bedRoom.setRoomIdentification("5");



        var frontDoor = new Connection();
        frontDoor.setDescription("Front door");
        frontDoor.setConnectionIdentification("6");
        frontDoor.setRoomFrom(outsideRoom);
        frontDoor.setRoomTo(hallwayRoom);
        frontDoor.setVirtual(false);

        var window = new Connection();
        window.setDescription("Window");
        window.setConnectionIdentification("7");
        window.setRoomFrom(outsideRoom);
        window.setRoomTo(livingRoom);
        window.setVirtual(false);



        var restroomDoor = new Connection();
        restroomDoor.setDescription("Restroom door");
        restroomDoor.setConnectionIdentification("8");
        restroomDoor.setRoomFrom(hallwayRoom);
        restroomDoor.setRoomTo(restroom);
        restroomDoor.setVirtual(false);

        var toiletDoor = new Connection();
        toiletDoor.setDescription("Toilet door");
        toiletDoor.setConnectionIdentification("9");
        toiletDoor.setRoomFrom(hallwayRoom);
        toiletDoor.setRoomTo(toiletRoom);
        toiletDoor.setVirtual(false);

        var virtualDoor1 = new Connection();
        virtualDoor1.setDescription("Virtual door 1");
        virtualDoor1.setConnectionIdentification("10");
        virtualDoor1.setRoomFrom(hallwayRoom);
        virtualDoor1.setRoomTo(livingRoom);
        virtualDoor1.setVirtual(true);

        var virtualDoor2 = new Connection();
        virtualDoor2.setDescription("Virtual door 2");
        virtualDoor2.setConnectionIdentification("12");
        virtualDoor2.setRoomFrom(livingRoom);
        virtualDoor2.setRoomTo(bedRoom);
        virtualDoor2.setVirtual(true);


        var motionSensorHallway1 = new MotionSensor();
        motionSensorHallway1.setSensorIdentification("13");
        motionSensorHallway1.setDescription("motion sensor in Hallway 1");
        motionSensorHallway1.setRoom(hallwayRoom);

        var motionSensorHallway2 = new MotionSensor();
        motionSensorHallway2.setSensorIdentification("14");
        motionSensorHallway2.setDescription("motion sensor in Hallway 2");
        motionSensorHallway2.setRoom(hallwayRoom);

        var motionSensorToilet1 = new MotionSensor();
        motionSensorToilet1.setSensorIdentification("15");
        motionSensorToilet1.setDescription("motion sensor in Toilet 1");
        motionSensorToilet1.setRoom(toiletRoom);

        var motionSensorToilet2 = new MotionSensor();
        motionSensorToilet2.setSensorIdentification("16");
        motionSensorToilet2.setDescription("motion sensor in Toilet 2");
        motionSensorToilet2.setRoom(toiletRoom);

        var motionSensorRestroom1 = new MotionSensor();
        motionSensorRestroom1.setSensorIdentification("17");
        motionSensorRestroom1.setDescription("motion sensor in Restroom 1");
        motionSensorRestroom1.setRoom(restroom);

        var motionSensorRestroom2 = new MotionSensor();
        motionSensorRestroom2.setSensorIdentification("18");
        motionSensorRestroom2.setDescription("motion sensor in Restroom 2");
        motionSensorRestroom2.setRoom(restroom);

        var motionSensorLivingroom1 = new MotionSensor();
        motionSensorLivingroom1.setSensorIdentification("19");
        motionSensorLivingroom1.setDescription("motion sensor in Living room 1");
        motionSensorLivingroom1.setRoom(livingRoom);

        var motionSensorLivingroom2 = new MotionSensor();
        motionSensorLivingroom2.setSensorIdentification("20");
        motionSensorLivingroom2.setDescription("motion sensor in Living room 2");
        motionSensorLivingroom2.setRoom(livingRoom);

        var motionSensorBedroom1 = new MotionSensor();
        motionSensorBedroom1.setSensorIdentification("21");
        motionSensorBedroom1.setDescription("motion sensor in Bedroom 1");
        motionSensorBedroom1.setRoom(bedRoom);

        var motionSensorBedroom2 = new MotionSensor();
        motionSensorBedroom2.setSensorIdentification("22");
        motionSensorBedroom2.setDescription("motion sensor in Bedroom 2");
        motionSensorBedroom2.setRoom(bedRoom);



        var contactSensorFrontdoor = new ContactSensor();
        contactSensorFrontdoor.setSensorIdentification("22");
        contactSensorFrontdoor.setDescription("contact sensor on front door");
        contactSensorFrontdoor.setConnection(frontDoor);
        contactSensorFrontdoor.setOnConnection(true);


        var contactSensorRestroomdoor = new ContactSensor();
        contactSensorRestroomdoor.setSensorIdentification("23");
        contactSensorRestroomdoor.setDescription("contact sensor on restroom door");
        contactSensorRestroomdoor.setConnection(restroomDoor);
        contactSensorRestroomdoor.setOnConnection(true);


        var contactSensorToiletDoor = new ContactSensor();
        contactSensorToiletDoor.setSensorIdentification("24");
        contactSensorToiletDoor.setDescription("contact sensor on toilet door");
        contactSensorToiletDoor.setConnection(toiletDoor);
        contactSensorToiletDoor.setOnConnection(true);


        var contactSensorFridge = new ContactSensor();
        contactSensorFridge.setSensorIdentification("25");
        contactSensorFridge.setDescription("contact sensor on fridge");
        contactSensorFridge.setConnection(frontDoor);
        contactSensorFridge.setOnConnection(false);
        contactSensorFridge.setOnContactSensorEntity(true);


        var contactSensorWindow = new ContactSensor();
        contactSensorWindow.setSensorIdentification("26");
        contactSensorWindow.setDescription("contact sensor on window");
        contactSensorWindow.setConnection(window);
        contactSensorWindow.setOnConnection(true);



        var contactSensorEntityFridge = new ContactSensorEntity();
        contactSensorEntityFridge.setDescription("fridge");
        contactSensorEntityFridge.setRoom(hallwayRoom);
        contactSensorEntityFridge.setContactSensorList(List.of(contactSensorFridge));

        contactSensorFridge.setContactSensorEntity(contactSensorEntityFridge);


        var vibrationSensorSink = new VibrationSensor();
        vibrationSensorSink.setSensorIdentification("27");
        vibrationSensorSink.setDescription("vibration sensor on sink");

        var vibrationSensorChair = new VibrationSensor();
        vibrationSensorChair.setSensorIdentification("28");
        vibrationSensorChair.setDescription("vibration sensor on chair");

        var vibrationSensorBed = new VibrationSensor();
        vibrationSensorBed.setSensorIdentification("29");
        vibrationSensorBed.setDescription("vibration sensor on bed");


        var electricSensorEntityKettle = new ElectricSensorEntity();
        electricSensorEntityKettle.setDescription("Kettle");

        var electricSensorEntityPlate = new ElectricSensorEntity();
        electricSensorEntityPlate.setDescription("Plate");

        var electricSensorPlug1 = new ElectricSensor();
        electricSensorPlug1.setSensorIdentification("30");
        electricSensorPlug1.setRoom(hallwayRoom);
        electricSensorPlug1.setElectricSensorEntity(electricSensorEntityKettle);

        var electricSensorPlug2 = new ElectricSensor();
        electricSensorPlug2.setSensorIdentification("31");
        electricSensorPlug2.setRoom(hallwayRoom);
        electricSensorPlug2.setElectricSensorEntity(electricSensorEntityPlate);




        var vibrationSensorEntitySink = new VibrationSensorEntity();
        vibrationSensorEntitySink.setDescription("Sink");
        vibrationSensorEntitySink.setRoom(restroom);
        vibrationSensorEntitySink.setVibrationSensorList(List.of(vibrationSensorSink));

        vibrationSensorSink.setVibrationSensorEntity(vibrationSensorEntitySink);

        var vibrationSensorEntityChair = new VibrationSensorEntity();
        vibrationSensorEntityChair.setDescription("Chair");
        vibrationSensorEntityChair.setRoom(livingRoom);
        vibrationSensorEntityChair.setVibrationSensorList(List.of(vibrationSensorChair));

        vibrationSensorChair.setVibrationSensorEntity(vibrationSensorEntityChair);


        var vibrationSensorEntityBed = new VibrationSensorEntity();
        vibrationSensorEntityBed.setDescription("Bed");
        vibrationSensorEntityBed.setRoom(bedRoom);
        vibrationSensorEntityBed.setVibrationSensorList(List.of(vibrationSensorBed));

        vibrationSensorBed.setVibrationSensorEntity(vibrationSensorEntityBed);



        hallwayRoom.setCo .setConnectionList(List.of(restroomDoor, toiletDoor, virtualDoor1, frontDoor));
        hallwayRoom.setMotionSensorList(List.of(motionSensorHallway1, motionSensorHallway2));
        hallwayRoom.setContactSensorEntityList(List.of(contactSensorEntityFridge));
        hallwayRoom.setElectricSensorList(List.of(electricSensorPlug1, electricSensorPlug2));


        restroom.setConnectionList(List.of(restroomDoor, toiletDoor, virtualDoor1, frontDoor));
        restroom.setMotionSensorList(List.of(motionSensorRestroom1, motionSensorRestroom2));
        restroom.setVibrationSensorEntityList(List.of(vibrationSensorEntitySink));



        toiletRoom.setConnectionList(List.of(toiletDoor));
        toiletRoom.setMotionSensorList(List.of(motionSensorToilet1, motionSensorToilet2));


        livingRoom.setConnectionList(List.of(window, virtualDoor1, virtualDoor2));
        livingRoom.setMotionSensorList(List.of(motionSensorLivingroom1, motionSensorLivingroom2));
        livingRoom.setVibrationSensorEntityList(List.of(vibrationSensorEntityChair));



        bedRoom.setConnectionList(List.of(virtualDoor2));
        bedRoom.setMotionSensorList(List.of(motionSensorBedroom1, motionSensorBedroom2));
        bedRoom.setVibrationSensorEntityList(List.of(vibrationSensorEntityBed));


        outsideRoom.setConnectionList(List.of(frontDoor, window));

        //connections

        frontDoor.setContactSensorList(List.of(contactSensorFrontdoor));
        window.setContactSensorList(List.of(contactSensorWindow));
        restroomDoor.setContactSensorList(List.of(contactSensorRestroomdoor));
        toiletDoor.setContactSensorList(List.of(contactSensorToiletDoor));


        outsideRoom.setConnectionList(List.of(frontDoor));

        frontDoor.setRoomFrom(outsideRoom);
        frontDoor.setRoomTo(hallwayRoom);

        this.roomList = List.of(hallwayRoom, outsideRoom, livingRoom, bedRoom, toiletRoom, restroom);
        this.connectionList = List.of(frontDoor, toiletDoor, restroomDoor, window, virtualDoor1, virtualDoor2);
        this.motionSensorList = List.of(motionSensorToilet1, motionSensorToilet2, motionSensorLivingroom1, motionSensorLivingroom2, motionSensorBedroom1, motionSensorBedroom2, motionSensorRestroom1, motionSensorRestroom2, motionSensorHallway2, motionSensorHallway1);
        this.contactSensorList = List.of(contactSensorFrontdoor, contactSensorWindow, contactSensorRestroomdoor, contactSensorToiletDoor, contactSensorFridge);
        this.vibrationSensorList = List.of(vibrationSensorBed, vibrationSensorSink, vibrationSensorChair);
        this.electricSensorList = List.of(electricSensorPlug1, electricSensorPlug2);
*/

    }


}

