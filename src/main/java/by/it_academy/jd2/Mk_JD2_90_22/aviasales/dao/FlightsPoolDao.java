package by.it_academy.jd2.Mk_JD2_90_22.aviasales.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FlightsPoolDao implements IAirportDao {

    private DataSource ds;

    public FlightsPoolDao() {
        ComboPooledDataSource pool = new ComboPooledDataSource();
        try {
            pool.setDriverClass("org.postgresql.Driver");
        } catch (PropertyVetoException e) {
            throw new RuntimeException("Проверь имя драйвера!!!!", e);
        }
        pool.setJdbcUrl("jdbc:postgresql://localhost:5432/demo");
        pool.setUser("postgres");
        pool.setPassword("postgres");

        this.ds = pool;
    }

    public List<Flight> getAll(){
        List<Flight> flights = new ArrayList<>();

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT\n" +
                             "    flight_id,\n" +
                             "    flight_no,\n" +
                             "    scheduled_departure,\n" +
                             "    scheduled_arrival,\n" +
                             "    departure_airport,\n" +
                             "    arrival_airport,\n" +
                             "    status,\n" +
                             "    aircraft_code,\n" +
                             "    actual_departure,\n" +
                             "    actual_arrival\n" +
                             "FROM\n" +
                             "    bookings.flights\n" +
                             "ORDER BY scheduled_departure;"
             );
        ) {
            while (resultSet.next()){
                flights.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return flights;
    }

    public Flight get(String flightNumber){
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT\n" +
                             "    flight_id,\n" +
                             "    flight_no,\n" +
                             "    scheduled_departure,\n" +
                             "    scheduled_arrival,\n" +
                             "    departure_airport,\n" +
                             "    arrival_airport,\n" +
                             "    status,\n" +
                             "    aircraft_code,\n" +
                             "    actual_departure,\n" +
                             "    actual_arrival\n" +
                             "FROM\n" +
                             "    bookings.flights\n" +
                             "WHERE flight_no = '" + flightNumber + "';"
             );
        ) {
            while (resultSet.next()){
                return map(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    private Connection getConnection() throws SQLException {
        return this.ds.getConnection();
    }

    private Flight map(ResultSet rs) throws SQLException {
        return new Flight(
                rs.getInt("flight_id"),
                rs.getString("flight_no"),
                toDate(rs.getString("scheduled_departure")),
                toDate(rs.getString("scheduled_arrival")),
                rs.getString("departure_airport"),
                rs.getString("arrival_airport"),
                rs.getString("status"),
                rs.getString("aircraft_code"),
                toZonedDateTime(rs.getString("actual_departure")),
                toZonedDateTime(rs.getString("actual_arrival"))
        );
    }

    @Override
    public void close() throws Exception {
        DataSources.destroy(this.ds);
    }

    private LocalDate toDate(String stringDate) {
        LocalDateTime formatter = LocalDateTime.parse(stringDate.replaceAll(" ", "T").substring(0, 19));
//        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
//        DateTime dateTime = DateTime.parse(dateInString, formatter);
        return formatter.toLocalDate();
    }

    private ZonedDateTime toZonedDateTime(String stringDate) {
        if (stringDate != null) {
            stringDate = stringDate.replaceAll(" ", "T") + ":00";
            ZonedDateTime zonedDateTime = ZonedDateTime.parse(stringDate, DateTimeFormatter.ISO_DATE_TIME);
            return zonedDateTime;
        }
        return null;
    }
}
