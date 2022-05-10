package by.it_academy.jd2.Mk_JD2_90_22.aviasales.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class Flight {

    private int flightId;
    private String flightNumber;
    private LocalDate dateOfDeparture;
    private LocalDate dateOfArrival;
    private String airportOfDeparture;
    private String airportOfArrival;
    private String status;
    private String aircraftCode;
    private ZonedDateTime actualDeparture;
    private ZonedDateTime actualArrival;

    public Flight(int flightId, String flightNumber, LocalDate dateOfDeparture, LocalDate dateOfArrival, String airportOfDeparture, String airportOfArrival, String status, String aircraftCode, ZonedDateTime actualDeparture, ZonedDateTime actualArrival) {
        this.flightId = flightId;
        this.flightNumber = flightNumber;
        this.dateOfDeparture = dateOfDeparture;
        this.dateOfArrival = dateOfArrival;
        this.airportOfDeparture = airportOfDeparture;
        this.airportOfArrival = airportOfArrival;
        this.status = status;
        this.aircraftCode = aircraftCode;
        this.actualDeparture = actualDeparture;
        this.actualArrival = actualArrival;
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

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAircraftCode() {
        return aircraftCode;
    }

    public void setAircraftCode(String aircraftCode) {
        this.aircraftCode = aircraftCode;
    }

    public ZonedDateTime getActualDeparture() {
        return actualDeparture;
    }

    public void setActualDeparture(ZonedDateTime actualDeparture) {
        this.actualDeparture = actualDeparture;
    }

    public ZonedDateTime getActualArrival() {
        return actualArrival;
    }

    public void setActualArrival(ZonedDateTime actualArrival) {
        this.actualArrival = actualArrival;
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
