package WalrusSmartHomeApp;

import WalrusSmartHomeApp.events.Event;
import WalrusSmartHomeApp.events.EventFactory;
import WalrusSmartHomeApp.events.EventHandler;
import WalrusSmartHomeApp.house_model.House;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import WalrusSmartHomeApp.services.LineParser;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Optional;

@SpringBootApplication
public class WalrusSmartHomeApp {
    public static void main(String[] args){
        ConfigurableApplicationContext appContext = SpringApplication.run(WalrusSmartHomeApp.class, args);
        House house = new House();
        LineParser lineParser = new LineParser();
        EventFactory eventFactory = new EventFactory();
        String line;
        String fileLocation = "/Users/hrdlifil/Desktop/lol.txt";
        EventHandler eventHandler = new EventHandler();

        try (InputStream is = Files.newInputStream(Paths.get(fileLocation.trim()));
             InputStreamReader reader = new InputStreamReader(is, "UTF-8");
             BufferedReader lineReader = new BufferedReader(reader);){

            while (true) {
                
                while ((line = lineReader.readLine()) != null) {
                    Optional<Map<String, String>> mapOpt = lineParser.parseLine(line);
                    if (mapOpt.isPresent()) {
                        Map<String, String> map = mapOpt.get();
                        Optional<Event> eventOpt = eventFactory.createEvent(map, house);
                        if (eventOpt.isPresent()) {
                            eventHandler.handleEvent(eventOpt.get());
                        }
                    }
                }

            }

        } catch (Exception exception) {
            System.out.println("Thrown from Parcing without file detection");
            exception.printStackTrace();
        }
    }
}
