package com.acc.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.acc.Visitor;
import com.acc.util.DBConnection;

public class VisitorDao {

    public List<Visitor> findAll() {
        List<Visitor> visitors = new ArrayList<>();
        String query = "SELECT * FROM visitor";
        try (Connection con = DBConnection.getDBConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                visitors.add(new Visitor(rs.getInt("visitorId"), rs.getString("name"), rs.getString("email"), rs.getString("phone")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return visitors;
    }

    public Visitor findOne(int id) {
        Visitor visitor = null;
        String query = "SELECT * FROM visitor WHERE visitorId = ?";
        try (Connection con = DBConnection.getDBConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                visitor = new Visitor(rs.getInt("visitorId"), rs.getString("name"), rs.getString("email"), rs.getString("phone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return visitor;
    }

    public void add(Visitor visitor) {
        String query = "INSERT INTO visitor (name, email, phone) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getDBConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setString(1, visitor.getName());
            stmt.setString(2, visitor.getEmail());
            stmt.setString(3, visitor.getPhone());
            stmt.executeUpdate();
            System.out.println("Visitor added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Visitor visitor) {
        String query = "UPDATE visitor SET name=?, email=?, phone=? WHERE visitorId=?";
        try (Connection con = DBConnection.getDBConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setString(1, visitor.getName());
            stmt.setString(2, visitor.getEmail());
            stmt.setString(3, visitor.getPhone());
            stmt.setInt(4, visitor.getVisitorId());
            stmt.executeUpdate();
            System.out.println("Visitor updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String query = "DELETE FROM visitor WHERE visitorId=?";
        try (Connection con = DBConnection.getDBConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Visitor deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
