package entity;

import java.util.ArrayList;
import java.util.List;

public class Airline {

    private List<Aircraft> aircrafts = new ArrayList<>();

    public void addAircraft(Aircraft aircraft) {
        aircrafts.add(aircraft);
    }

    public List<Aircraft> getAircrafts() {
        return aircrafts;
    }
}