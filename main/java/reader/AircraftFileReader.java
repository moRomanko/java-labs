package reader;

import entity.Aircraft;
import factory.AircraftFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AircraftFileReader {

    private static final Logger logger =
            (Logger) LogManager.getLogger();

    public List<Aircraft> read(String fileName) {

        List<Aircraft> aircrafts =
                new ArrayList<>();

        AircraftFactory factory =
                new AircraftFactory();

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(fileName))) {

            String line;

            while ((line = reader.readLine())
                    != null) {

                try {

                    String[] data =
                            line.split(";");

                    aircrafts.add(
                            factory.createAircraft(data));

                } catch (Exception e) {

                    logger.warn(
                            "Некорректные данные: {}",
                            line);
                }
            }

        } catch (IOException e) {

            logger.error("Ошибка чтения файла", e);
        }

        return aircrafts;
    }
}