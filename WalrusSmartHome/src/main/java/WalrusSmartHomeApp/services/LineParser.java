package WalrusSmartHomeApp.services;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class LineParser {

    public Optional<Map<String, String>> parseLine(String line){
        Map<String, String> toReturn = new LinkedHashMap<>();
        try {
            Scanner scanner = new Scanner(line);

            //int word = 2;
            while (scanner.hasNext()) {
                boolean isContact = false, isMotion = false, isAcceleration= false, isWater = false, isElectric = false;
                int count = 0;
                while (scanner.hasNext()) {
                    count++;
                    String toBePut;
                    if (count == 1 || count == 5 || count == 6 || count == 9) {
                        scanner.next();
                    } else if (count == 2) {
                        toBePut = scanner.next();
                        toReturn.put("date", toBePut);
                    } else if (count == 3) {
                        toBePut = scanner.next();
                        toReturn.put("time", toBePut);
                    } else if (count == 4) {
                        toBePut = scanner.next();
                        if (toBePut.equals("MQTT")) {
                            toReturn.put("MQTT", "Yes");
                        } else {
                            return Optional.empty();
                        }
                    } else if (count == 7) {
                        toBePut = scanner.next();
                        if (!toBePut.equals("\'zigbee2mqtt/bridge/state\',") && !toBePut.equals("\'zigbee2mqtt/bridge/config\',") && !toBePut.equals("\'zigbee2mqtt/bridge/log\',")) {
               /*jelikož jsem prošel prvním if, tak vím že se jedná o smysluplný signál ze senzoru a ted zjistim
                jastli jde o motion nebo contact*/
                            if (toBePut.contains("contact")) {
                                isContact = true;
                            } else if (toBePut.contains("motion")) {
                                isMotion = true;
                            } else if (toBePut.contains("acceler")) {
                                isAcceleration = true;
                            } else if (toBePut.contains("water")) {
                                isWater = true;
                            }else if (toBePut.contains("electric")){
                                isElectric = true;
                            }
                            toReturn.put("sensor_type", toBePut);
                        } else {
                            return Optional.empty();
                        }
                    } else if (count == 8) {
                        toBePut = scanner.next();
                        toReturn.put("sensor_identification", toBePut);
                    } else if (count == 10) {
                        this.writeDataIntoMap(toReturn, scanner, isContact, isMotion, isAcceleration, isWater, isElectric);

                    }
                }
            }
            return Optional.of(toReturn);
        } catch (Exception e) {
            System.out.println("Thrown from transform into map");
            e.printStackTrace();
            return Optional.empty();
        }

    }

    private void writeDataIntoMap(Map<String, String> toReturn,
                                  Scanner scanner,
                                  boolean isContact,
                                  boolean isMotion,
                                  boolean isAcceleration,
                                  boolean isWater,
                                  boolean isElectric) {
        String toBePut = scanner.next();
        // vim že senzor je kontakt takže budu kontrolovat hodnotu kontaktu
        if (isContact) {
            var x = toBePut.split(",");
            var battery = x[0].split(":")[1];
            var temperature = x[2].split(":")[1];
            toReturn.put("sensor", "contact");
            toReturn.put("battery", battery);
            toReturn.put("temperature", temperature);
            if (toBePut.contains("\"contact\":false")) {
                toReturn.put("data", "false");
            } else {
                toReturn.put("data", "true");
            }
            // tady už vím že není kontakt, takže musí být motion
        } else if (isMotion) {
            if (toBePut.contains("\"occupancy\":false")) {
                toReturn.put("data", "false");
                toReturn.put("sensor", "motion");
            } else {
                toReturn.put("data", "true");
                toReturn.put("sensor", "motion");
            }
        } else if (isAcceleration) {
            var x = toBePut.split(",");
            var angle = x[0].split(":")[1];
            var angleX = x[1].split(":")[1];
            var angleXAbsolute = x[2].split(":")[1];
            var angleY = x[3].split(":")[1];
            var angleYAbsolute = x[4].split(":")[1];
            var angleZ = x[5].split(":")[1];
            var battery = x[6].split(":")[1];
            var temperature = x[8].split(":")[1];
            var data = x[9].split(":")[1];
            toReturn.put("sensor", "acceleration");
            toReturn.put("data", data);
            toReturn.put("angle", angle);
            toReturn.put("angleX", angleX);
            toReturn.put("angleY", angleY);
            toReturn.put("angleZ", angleZ);
            toReturn.put("angleXAbsolute", angleXAbsolute);
            toReturn.put("angleYAbsolute", angleYAbsolute);
            toReturn.put("battery", battery);
            toReturn.put("temperature", temperature);


        }
        else if (isElectric) {
            toReturn.put("sensor", "electric");
            var x = toBePut.split(",");
            toReturn.put("current", x[1].split(":")[1]);
            toReturn.put("energy", x[2].split(":")[1]);
            toReturn.put("power", x[4].split(":")[1]);
            toReturn.put("voltage", x[6].split(":")[1].split("}")[0]);

        }
    }
}
