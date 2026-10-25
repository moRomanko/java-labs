package reader;

import entity.Aircraft;
import entity.BusinessJet;
import entity.CargoPlane;
import entity.PassengerPlane;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AircraftFileReaderTest {

    @Test
    void readShouldReturnAircraftListFromValidFile() throws IOException {

        File tempFile = File.createTempFile("aircraft", ".txt");

        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write(
                    "PASSENGER;Boeing737;180;20;3500;2400;18\n");
            writer.write(
                    "CARGO;An124;10;120;5000;7000;1500\n");
        }

        AircraftFileReader reader = new AircraftFileReader();

        List<Aircraft> aircrafts =
                reader.read(tempFile.getAbsolutePath());

        assertEquals(2, aircrafts.size());

        assertInstanceOf(
                PassengerPlane.class,
                aircrafts.get(0));

        assertInstanceOf(
                CargoPlane.class,
                aircrafts.get(1));
    }

    @Test
    void readShouldSkipIncorrectLines() throws IOException {

        File tempFile = File.createTempFile("aircraft", ".txt");

        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write(
                    "PASSENGER;Boeing737;180;20;3500;2400;18\n");

            writer.write(
                    "INVALID_LINE\n");

            writer.write(
                    "CARGO;An124;10;120;5000;7000;1500\n");
        }

        AircraftFileReader reader = new AircraftFileReader();

        List<Aircraft> aircrafts =
                reader.read(tempFile.getAbsolutePath());

        assertEquals(2, aircrafts.size());
    }

    @Test
    void readShouldReturnEmptyListWhenFileDoesNotExist() {

        AircraftFileReader reader =
                new AircraftFileReader();

        List<Aircraft> aircrafts =
                reader.read("nonexistent_file.txt");

        assertNotNull(aircrafts);
        assertTrue(aircrafts.isEmpty());
    }

    @Test
    void readShouldCreateCorrectAircraftTypes()
            throws IOException {

        File tempFile =
                File.createTempFile("aircraft", ".txt");

        try (FileWriter writer =
                     new FileWriter(tempFile)) {

            writer.write(
                    "PASSENGER;Boeing737;180;20;3500;2400;18\n");

            writer.write(
                    "BUSINESS;Gulfstream;12;5;7000;1400;true\n");
        }

        AircraftFileReader reader =
                new AircraftFileReader();

        List<Aircraft> aircrafts =
                reader.read(tempFile.getAbsolutePath());

        assertInstanceOf(
                PassengerPlane.class,
                aircrafts.get(0));

        assertInstanceOf(
                BusinessJet.class,
                aircrafts.get(1));
    }
}