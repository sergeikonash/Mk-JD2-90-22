package by.it_academy.jd2.Mk_JD2_90_22.aviasales.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
                             "    flight_no,\n" +
                             "    scheduled_departure,\n" +
                             "    scheduled_arrival,\n" +
                             "    departure_airport,\n" +
                             "    arrival_airport\n" +
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
                             "    flight_no,\n" +
                             "    scheduled_departure,\n" +
                             "    scheduled_arrival,\n" +
                             "    departure_airport,\n" +
                             "    arrival_airport\n" +
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
                rs.getString("flight_no"),
                rs.getString("scheduled_departure"),
                rs.getString("scheduled_arrival"),
                rs.getString("departure_airport"),
                rs.getString("arrival_airport")
        );
    }

    @Override
    public void close() throws Exception {
        DataSources.destroy(this.ds);
    }
}