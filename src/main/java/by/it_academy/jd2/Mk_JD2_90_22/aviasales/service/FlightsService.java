package by.it_academy.jd2.Mk_JD2_90_22.aviasales.service;

import by.it_academy.jd2.Mk_JD2_90_22.aviasales.dao.Flight;
import by.it_academy.jd2.Mk_JD2_90_22.aviasales.dao.FlightsPoolDao;
import by.it_academy.jd2.Mk_JD2_90_22.aviasales.dao.IAirportDao;

import java.util.ArrayList;
import java.util.List;

public class FlightsService {

    private IAirportDao flightDao = new FlightsPoolDao();
    private List<Flight> flights = flightDao.getAll();
    private static String dateOfDeparture;
    private static String dateOfArrival;
    private static String airportOfDeparture;
    private static String airportOfArrival;

    public List<Flight> getFlights() {
        return flights;
    }

    public String getDateOfDeparture() {
        return dateOfDeparture;
    }

    public void setDateOfDeparture(String date) {
        dateOfDeparture = date;
    }

    public String getDateOfArrival() {
        return dateOfArrival;
    }

    public void setDateOfArrival(String date) {
        dateOfArrival = date;
    }

    public String getAirportOfDeparture() {
        return airportOfDeparture;
    }

    public void setAirportOfDeparture(String airportFromUser) {
        airportOfDeparture = airportFromUser;
    }

    public String getAirportOfArrival() {
        return airportOfArrival;
    }

    public void setAirportOfArrival(String airportFromUser) {
        airportOfArrival = airportFromUser;
    }

    public List<Flight> filteredList() {
        List<Flight> filtered = new ArrayList<>();

        for (Flight flight : flights) {
            if ((flight.getDateOfDeparture().substring(0, 10).equals(dateOfDeparture) || dateOfDeparture == null) &&
                    (flight.getDateOfArrival().substring(0, 10).equals(dateOfArrival) || dateOfArrival == null) &&
                    (flight.getAirportOfDeparture().equals(airportOfDeparture) || airportOfDeparture == null) &&
                    (flight.getAirportOfArrival().equals(airportOfArrival) || airportOfArrival == null)
            ) {
                filtered.add(flight);
            }
        }
//        for (Flight flight : flights) {
//            if (flight.getDateOfDeparture().substring(0, 10).equals(dateOfDeparture)) {
//                if (flight.getDateOfArrival().substring(0, 10).equals(dateOfArrival)) {
//                    if (flight.getAirportOfDeparture().equals(airportOfDeparture)) {
//                        if (flight.getAirportOfArrival().equals(airportOfArrival)) {
//                            filtered.add(flight);
//                        }
//                    }
//                }
//            }
//        }
        return filtered;
    }
}
