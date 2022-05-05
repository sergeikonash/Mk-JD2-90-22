package by.it_academy.jd2.Mk_JD2_90_22.aviasales.service;

import by.it_academy.jd2.Mk_JD2_90_22.aviasales.dao.Flight;
import by.it_academy.jd2.Mk_JD2_90_22.aviasales.dao.FlightsPoolDao;
import by.it_academy.jd2.Mk_JD2_90_22.aviasales.dao.IAirportDao;

import java.time.LocalDate;
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
        if (date == null || date.equals(empty)) {
            dateOfDeparture = null;
        } else {
            dateOfDeparture = toDate(date);
        }
    }

    public LocalDate getDateOfArrival() {
        return dateOfArrival;
    }

    public static void setDateOfArrival(String date) {
        if (date == null || date.equals(empty)) {
            dateOfArrival = null;
        } else {
            dateOfArrival = toDate(date);
        }
    }

    public String getAirportOfDeparture() {
        return airportOfDeparture;
    }

    public static void setAirportOfDeparture(String airportFromUser) {
        if (airportFromUser == null || airportFromUser.equals(empty)) {
            airportOfDeparture = null;
        } else {
            airportOfDeparture = airportFromUser;
        }
    }

    public String getAirportOfArrival() {
        return airportOfArrival;
    }

    public static void setAirportOfArrival(String airportFromUser) {
        if (airportFromUser == null || airportFromUser.equals(empty)) {
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

        for (Flight flight : flights) {
            boolean booleanDateOfDeparture = false;
            boolean booleanDateOfArrival = false;
            boolean booleanAirportOfDeparture = false;
            boolean booleanAirportOfArrival = false;

            if (dateOfDeparture == null || flight.getDateOfDeparture().equals(dateOfDeparture)) {
                booleanDateOfDeparture = true;
            }
            if (dateOfArrival == null || flight.getDateOfArrival().equals(dateOfArrival)) {
                booleanDateOfArrival = true;
            }
            if (airportOfDeparture == null || flight.getAirportOfDeparture().equals(airportOfDeparture)) {
                booleanAirportOfDeparture = true;
            }
            if (airportOfArrival == null || flight.getAirportOfArrival().equals(airportOfArrival)) {
                booleanAirportOfArrival = true;
            }

            if (booleanAirportOfArrival && booleanAirportOfDeparture && booleanDateOfDeparture && booleanDateOfArrival) {
                filtered.add(flight);
            }
        }
        return filtered;
    }
    private static LocalDate toDate(String stringDate) {
        if (stringDate != null && stringDate != empty) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return LocalDate.parse(stringDate, formatter);
        } else {
            return null;
        }
    }

    public List<String> getAirports() {
        List<String> listAirports = new ArrayList<>();
        for (Flight flight : flights) {
            if (!listAirports.contains(flight.getAirportOfDeparture())) {
                listAirports.add(flight.getAirportOfDeparture());
            }
        }
        return listAirports;
    }
}
