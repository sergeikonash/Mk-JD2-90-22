package by.it_academy.jd2.Mk_JD2_90_22.aviasales.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Flight {

    private String flightNumber;
    private LocalDate dateOfDeparture;
    private LocalDate dateOfArrival;
    private String airportOfDeparture;
    private String airportOfArrival;

    public Flight(String flightNumber, LocalDate dateOfDeparture, LocalDate dateOfArrival, String airportOfDeparture, String airportOfArrival) {
        this.dateOfDeparture = dateOfDeparture;
        this.dateOfArrival = dateOfArrival;
        this.airportOfDeparture = airportOfDeparture;
        this.airportOfArrival = airportOfArrival;
        this.flightNumber = flightNumber;
    }

    public LocalDate getDateOfDeparture() {
        return dateOfDeparture;
    }

    public void setDateOfDeparture(LocalDate dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
    }

    public LocalDate getDateOfArrival() {
        return dateOfArrival;
    }

    public void setDateOfArrival(LocalDate dateOfArrival) {
        this.dateOfArrival = dateOfArrival;
    }

    public String getAirportOfDeparture() {
        return airportOfDeparture;
    }

    public void setAirportOfDeparture(String airportOfDeparture) {
        this.airportOfDeparture = airportOfDeparture;
    }

    public String getAirportOfArrival() {
        return airportOfArrival;
    }

    public void setAirportOfArrival(String airportOfArrival) {
        this.airportOfArrival = airportOfArrival;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "dateOfDeparture='" + dateOfDeparture + '\'' +
                ", dateOfArrival='" + dateOfArrival + '\'' +
                ", airportOfDeparture='" + airportOfDeparture + '\'' +
                ", airportOfArrival='" + airportOfArrival + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                '}';
    }
}
