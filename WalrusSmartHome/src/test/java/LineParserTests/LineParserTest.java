package LineParserTests;

import org.junit.jupiter.api.Test;
import WalrusSmartHomeApp.services.LineParser;

import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LineParserTest {

    @Test
    void parseMotionSensorData(){
        String line = "info  2022-10-15 19:57:58: MQTT publish: topic 'zigbee2mqtt/motion restroom', payload '{\"occupancy\":true}'";
        var expectedResult = new HashMap<String, String>();
        expectedResult.put("date", "2022-10-15");
        expectedResult.put("time", "19:57:58:");
        expectedResult.put("MQTT", "Yes");
        expectedResult.put("sensor_type", "'zigbee2mqtt/motion");
        expectedResult.put("sensor_identification", "restroom',");
        expectedResult.put("data", "true");
        expectedResult.put("sensor", "motion");

        var lineParser = new LineParser();
        assertEquals(lineParser.parseLine(line).get(), expectedResult);

    }

    @Test
    void parseContactSensorData(){
        String line = "info  2022-10-15 19:57:58: MQTT publish: topic 'zigbee2mqtt/contact fridge', payload '{\"battery\":100,\"contact\":true,\"temperature\":28,\"voltage\":3015}'";
        var expectedResult = new HashMap<String, String>();
        expectedResult.put("date", "2022-10-15");
        expectedResult.put("time", "19:57:58:");
        expectedResult.put("MQTT", "Yes");
        expectedResult.put("sensor_type", "'zigbee2mqtt/contact");
        expectedResult.put("sensor_identification", "fridge',");
        expectedResult.put("data", "true");
        expectedResult.put("sensor", "contact");
        expectedResult.put("battery", "100");
        expectedResult.put("temperature", "28");

        var lineParser = new LineParser();
        assertEquals(lineParser.parseLine(line).get(), expectedResult);

    }

    @Test
    void parseVibrationSensorData(){
        String line = "info  2022-10-15 19:57:58: MQTT publish: topic 'zigbee2mqtt/acceler restroom', payload '{\"angle\":18,\"angle_x\":5,\"angle_x_absolute\":85,\"angle_y\":18,\"angle_y_absolute\":72,\"angle_z\":71,\"battery\":100,\"strength\":27,\"temperature\":28,\"vibration\":false,\"voltage\":3005}'";
        var expectedResult = new HashMap<String, String>();
        expectedResult.put("date", "2022-10-15");
        expectedResult.put("time", "19:57:58:");
        expectedResult.put("MQTT", "Yes");
        expectedResult.put("sensor_type", "'zigbee2mqtt/acceler");
        expectedResult.put("sensor_identification", "restroom',");
        expectedResult.put("data", "false");
        expectedResult.put("sensor", "acceleration");
        expectedResult.put("battery", "100");
        expectedResult.put("temperature", "28");

        expectedResult.put("angle", "18");
        expectedResult.put("angleX", "5");
        expectedResult.put("angleY", "18");
        expectedResult.put("angleZ", "71");
        expectedResult.put("angleXAbsolute", "85");
        expectedResult.put("angleYAbsolute", "72");


        var lineParser = new LineParser();
        assertEquals(lineParser.parseLine(line).get(), expectedResult);

    }

    @Test
    void parseElectricSensorData(){
        String line = "info  2022-10-15 21:18:37: MQTT publish: topic 'zigbee2mqtt/electric hotplate', payload '{\"child_lock\":\"UNLOCK\",\"current\":0,\"energy\":0.23,\"indicator_mode\":\"off/on\",\"power\":0,\"state\":\"ON\",\"voltage\":238}'";
        var expectedResult = new HashMap<String, String>();
        expectedResult.put("date", "2022-10-15");
        expectedResult.put("time", "21:18:37:");
        expectedResult.put("MQTT", "Yes");
        expectedResult.put("sensor_type", "'zigbee2mqtt/electric");
        expectedResult.put("sensor_identification", "hotplate',");
        expectedResult.put("sensor", "electric");



        expectedResult.put("current", "0");
        expectedResult.put("energy", "0.23");
        expectedResult.put("power", "0");
        expectedResult.put("voltage", "238");



        var lineParser = new LineParser();
        assertEquals(lineParser.parseLine(line).get(), expectedResult);
        int kokot = 69;
    }





}
