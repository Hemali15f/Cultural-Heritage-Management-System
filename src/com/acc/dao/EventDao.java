package com.acc.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.acc.Event;
import com.acc.util.DBConnection;

public class EventDao {

    public List<Event> findAll() {
        List<Event> events = new ArrayList<>();
        String query = "SELECT * FROM event";
        try (Connection con = DBConnection.getDBConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                events.add(new Event(rs.getInt("eventId"), rs.getString("name"), rs.getString("date"), rs.getString("location")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return events;
    }

    public Event findOne(int id) {
        Event event = null;
        String query = "SELECT * FROM event WHERE eventId = ?";
        try (Connection con = DBConnection.getDBConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                event = new Event(rs.getInt("eventId"), rs.getString("name"), rs.getString("date"), rs.getString("location"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return event;
    }

    public void add(Event event) {
        String query = "INSERT INTO event (name, date, location) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getDBConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setString(1, event.getName());
            stmt.setString(2, event.getDate());
            stmt.setString(3, event.getLocation());
            stmt.executeUpdate();
            System.out.println("Event added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Event event) {
        String query = "UPDATE event SET name=?, date=?, location=? WHERE eventId=?";
        try (Connection con = DBConnection.getDBConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setString(1, event.getName());
            stmt.setString(2, event.getDate());
            stmt.setString(3, event.getLocation());
            stmt.setInt(4, event.getEventId());
            stmt.executeUpdate();
            System.out.println("Event updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String query = "DELETE FROM event WHERE eventId=?";
        try (Connection con = DBConnection.getDBConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Event deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

