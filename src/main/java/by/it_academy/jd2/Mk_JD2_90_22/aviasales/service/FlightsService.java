package by.it_academy.jd2.Mk_JD2_90_22.aviasales.service;

import by.it_academy.jd2.Mk_JD2_90_22.aviasales.dao.Flight;
import by.it_academy.jd2.Mk_JD2_90_22.aviasales.dao.FlightsPoolDao;
import by.it_academy.jd2.Mk_JD2_90_22.aviasales.dao.IAirportDao;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FlightsService {

    private IAirportDao flightDao = new FlightsPoolDao();
    private List<Flight> flights = flightDao.getAll();
    private static LocalDate dateOfDeparture;
    private static LocalDate dateOfArrival;
    private static String airportOfDeparture;
    private static String airportOfArrival;
    private static String empty = "";

    public List<Flight> getFlights() {
        return flights;
    }

    public LocalDate getDateOfDeparture() {
        return dateOfDeparture;
    }

    public static void setDateOfDeparture(String date) {
        if (date.equals(empty)) {
            dateOfDeparture = null;
        } else {
            dateOfDeparture = toDate(date);
        }
    }

    public LocalDate getDateOfArrival() {
        return dateOfArrival;
    }

    public static void setDateOfArrival(String date) {
        if (date.equals(empty)) {
            dateOfArrival = null;
        } else {
            dateOfArrival = toDate(date);
        }
    }

    public String getAirportOfDeparture() {
        return airportOfDeparture;
    }

    public static void setAirportOfDeparture(String airportFromUser) {
        if (airportFromUser.equals(empty)) {
            airportOfDeparture = null;
        } else {
            airportOfDeparture = airportFromUser;
        }
    }

    public String getAirportOfArrival() {
        return airportOfArrival;
    }

    public static void setAirportOfArrival(String airportFromUser) {
        if (airportFromUser.equals(empty)) {
            airportOfArrival = null;
        } else {
            airportOfArrival = airportFromUser;
        }
    }

    public List<Flight> filteredList() {
        if (dateOfDeparture == null &&
                dateOfArrival == null &&
                airportOfDeparture == null &&
                airportOfArrival == null
        ) {
            return flights;
        }
        List<Flight> filtered = new ArrayList<>();
        boolean booleanDateOfDeparture = false;
        boolean booleanDateOfArrival = false;
        boolean booleanAirportOfDeparture = false;
        boolean booleanAirportOfArrival = false;

        for (Flight flight : flights) {

            if (flight.getDateOfDeparture().equals(dateOfDeparture) || dateOfDeparture == null) {
                booleanDateOfDeparture = true;
            }
            if (flight.getDateOfArrival().equals(dateOfArrival) || dateOfArrival == null) {
                booleanDateOfArrival = true;
            }
            if (flight.getAirportOfDeparture().equals(airportOfDeparture) || airportOfDeparture == null) {
                booleanAirportOfDeparture = true;
            }
            if (flight.getAirportOfArrival().equals(airportOfArrival) || airportOfArrival == null) {
                booleanAirportOfArrival = true;
            }

            if (booleanAirportOfArrival && booleanAirportOfDeparture && booleanDateOfDeparture && booleanDateOfArrival) {
                filtered.add(flight);
            }
        }
        return filtered;
    }
    private static LocalDate toDate(String stringDate) {
        if (stringDate != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
            return LocalDate.parse(stringDate, formatter);
        } else {
            return null;
        }
    }
}
