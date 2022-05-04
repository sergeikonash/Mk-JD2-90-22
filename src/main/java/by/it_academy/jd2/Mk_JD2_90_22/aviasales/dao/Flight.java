package by.it_academy.jd2.Mk_JD2_90_22.aviasales.dao;

public class Flight {

    private String flightNumber;
    private String dateOfDeparture;
    private String dateOfArrival;
    private String airportOfDeparture;
    private String airportOfArrival;

    public Flight(String flightNumber, String dateOfDeparture, String dateOfArrival, String airportOfDeparture, String airportOfArrival) {
        this.dateOfDeparture = dateOfDeparture;
        this.dateOfArrival = dateOfArrival;
        this.airportOfDeparture = airportOfDeparture;
        this.airportOfArrival = airportOfArrival;
        this.flightNumber = flightNumber;
    }

    public String getDateOfDeparture() {
        return dateOfDeparture;
    }

    public void setDateOfDeparture(String dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
    }

    public String getDateOfArrival() {
        return dateOfArrival;
    }

    public void setDateOfArrival(String dateOfArrival) {
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
