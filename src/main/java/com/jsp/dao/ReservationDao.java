package com.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsp.dto.Reservation;

public class ReservationDao {
    private Connection connection;

    // Constructor that takes a database connection
    public ReservationDao(Connection connection) {
        this.connection = connection;
    }

    // Method to add a new reservation
    public void addReservation(Reservation reservation) throws SQLException {
        String query = "INSERT INTO reservations (client_id, room_id, start_date, end_date, totalprice) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, reservation.getClientId());
            preparedStatement.setInt(2, reservation.getRoomId());
            preparedStatement.setDate(3, reservation.getStartDate());
            preparedStatement.setDate(4, reservation.getEndDate());
            preparedStatement.setInt(5, reservation.getTotalPrice());
            preparedStatement.executeUpdate();
        }
    }

    // Method to get all reservations
    public List<Reservation> getAllReservations() throws SQLException {
        List<Reservation> reservations = new ArrayList<>();
        String query = "SELECT * FROM reservations";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Reservation reservation = new Reservation();
                reservation.setId(resultSet.getInt("id"));
                reservation.setClientId(resultSet.getInt("client_id"));
                reservation.setRoomId(resultSet.getInt("room_id"));
                reservation.setStartDate(resultSet.getDate("start_date"));
                reservation.setEndDate(resultSet.getDate("end_date"));
                reservation.setTotalPrice(resultSet.getInt("totalprice"));
                reservations.add(reservation);
            }
        }
        return reservations;
    }

    // Additional methods (update, delete, etc.) can be added as needed
}
