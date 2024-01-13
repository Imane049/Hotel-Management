package com.jsp.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.jsp.dto.Room;

public class RoomDao {
    private SessionFactory sessionFactory;

    // Constructor that takes a Hibernate SessionFactory
    public RoomDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // Method to add a new room
    public void addRoom(Room room) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(room);
            transaction.commit();
        }
    }

    // Method to get all rooms
    public List<Room> getAllRooms() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Room", Room.class).list();
        }
    }

    public Room getFirstAvailableRoom(String checkinDate, String checkoutDate, String roomTypeParam) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            List<Room> resultList = session.createQuery(
                    "SELECT r FROM Room r " +
                            "WHERE r.type = :type " +
                            "AND r.roomId NOT IN (" +
                            "    SELECT rv.room.roomId FROM Reservation rv " +
                            "    WHERE (rv.startDate BETWEEN :checkinDate AND :checkoutDate) OR " +
                            "          (rv.endDate BETWEEN :checkinDate AND :checkoutDate))", Room.class)
                    .setParameter("type", roomTypeParam)
                    .setParameter("checkinDate", checkinDate)
                    .setParameter("checkoutDate", checkoutDate)
                    .setMaxResults(1)
                    .list();

            transaction.commit();

            return resultList.isEmpty() ? null : resultList.get(0);
        }
    }

    // Additional methods (update, delete, etc.) can be added as needed
}
