package hashmap;

import java.util.HashMap;
import java.util.Map;

public class DesignUndergroundSystem1396 {

    class CheckIn{
        String stationName;
        Integer time;

        public CheckIn(String stationName, Integer time) {
            this.stationName = stationName;
            this.time = time;
        }
    }

    class Trip{
        int totalTime;
        int totalTrip;

        public Trip(int totalTime, int totalTrip) {
            this.totalTime = totalTime;
            this.totalTrip = totalTrip;
        }
    }

    private Map<Integer, CheckIn> checkInMap;
    private Map<String, Trip> tripMap;
    public DesignUndergroundSystem1396() {
        checkInMap = new HashMap<>();
        tripMap= new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckIn c = checkInMap.get(id);
        Trip trip = tripMap.getOrDefault(c.stationName+"_"+stationName, new Trip(0,0));
        trip.totalTime += (t - c.time);
        trip.totalTrip++;
        tripMap.put(c.stationName+"_"+stationName, trip);
    }

    public double getAverageTime(String startStation, String endStation) {
        Trip trip = tripMap.get(startStation+"_"+endStation);
        return (double) trip.totalTime / trip.totalTrip;
    }


    public static void main(String[] args) {
        DesignUndergroundSystem1396 prog = new DesignUndergroundSystem1396();
        prog.checkIn(45, "Leyton", 3);
        prog.checkIn(32, "Paradise", 8);
        prog.checkIn(27, "Leyton", 10);
        prog.checkOut(45, "Waterloo", 15);
        prog.checkOut(27, "Waterloo", 20);
        prog.checkOut(32, "Cambridge", 22);

        System.out.println(prog.getAverageTime("Paradise", "Cambridge"));
        System.out.println(prog.getAverageTime("Leyton", "Waterloo"));
        prog.checkIn(10, "Leyton", 24);
        System.out.println(prog.getAverageTime("Leyton", "Waterloo"));
        prog.checkOut(10, "Waterloo", 38);
        System.out.println(prog.getAverageTime("Leyton", "Waterloo"));

        prog.checkIn(10, "Leyton", 3);
        prog.checkOut(10, "Paradise", 8);
        System.out.println(prog.getAverageTime("Leyton", "Paradise"));
        prog.checkIn(5, "Leyton", 10);
        prog.checkOut(5, "Paradise", 16);
        System.out.println(prog.getAverageTime("Leyton", "Paradise"));
        prog.checkIn(2, "Leyton", 21);
        prog.checkOut(2, "Paradise", 30);
        System.out.println(prog.getAverageTime("Leyton", "Paradise"));
    }
}
