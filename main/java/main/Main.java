package main;

import comparator.FlightRangeComparator;
import entity.Aircraft;
import entity.Airline;
import reader.AircraftFileReader;
import service.AirlineService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger =
            LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        logger.info("Программа запущена");

        Airline airline = new Airline();
        AircraftFileReader reader = new AircraftFileReader();
        AirlineService service = new AirlineService();

        try {

            logger.info("Загрузка информации о самолётах в авиакомпании...");
            reader.read("src\\main\\resources\\inputExampe.txt").forEach(airline::addAircraft);

            logger.info("Самолётов в авиакомпании: {}", airline.getAircrafts().size());

            int totalPassengers = service.calculateTotalCapacity(airline);
            logger.info("Общая вместимость: {}", totalPassengers);

            double totalCargo = service.calculateTotalCargoCapacity(airline);
            logger.info("Общая грузоподъемность: {}", totalCargo);

            logger.info("Сортировка самолетов компании по дальности полета...");
            airline.getAircrafts().sort(new FlightRangeComparator());

            logger.info("Список самолётов после сортировки:");
            for (Aircraft aircraft : airline.getAircrafts()) {
                logger.info(aircraft);
            }

            logger.info("Поиск самолётов в компании, соответствующих диапазону [2000, 3000] параметров потребления горючего...");

            var result = service.findByFuelConsumption(airline, 2000, 3000);

            if (result.isEmpty()) {
                logger.warn("В кампании отсутствуют самолёты, соответствующие заданному диапазону параметров потребления горючего");

            } else {
                logger.info("Найдено {} таковых самолётов", result.size());
                result.forEach(logger::info);
            }

            logger.info("Успешное завершение программы");

        } catch (Exception e) {
            logger.error("Возникла ошибка", e);
        }
    }
}