package com.acc.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.acc.Donation;
import com.acc.util.DBConnection;
public class DonationDao {
    public List<Donation> findAll() {
        List<Donation> donations = new ArrayList<>();
        String query = "SELECT * FROM donation";
        try (Connection con = DBConnection.getDBConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                donations.add(new Donation(rs.getInt("donationId"), rs.getInt("visitorId"), rs.getInt("siteId"), rs.getDouble("amount")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return donations;
    }
    public Donation findOne(int id) {
        Donation donation = null;
        String query = "SELECT * FROM donation WHERE donationId = ?";
        try (Connection con = DBConnection.getDBConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                donation = new Donation(rs.getInt("donationId"), rs.getInt("visitorId"), rs.getInt("siteId"), rs.getDouble("amount"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return donation;
    }

    public void add(Donation donation) {
        String query = "INSERT INTO donation (visitorId, siteId, amount) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getDBConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setInt(1, donation.getVisitorId());
            stmt.setInt(2, donation.getSiteId());
            stmt.setDouble(3, donation.getAmount());
            stmt.executeUpdate();
            System.out.println("Donation added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(Donation donation) {
        String query = "UPDATE donation SET visitorId=?, siteId=?, amount=? WHERE donationId=?";
        try (Connection con = DBConnection.getDBConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setInt(1, donation.getVisitorId());
            stmt.setInt(2, donation.getSiteId());
            stmt.setDouble(3, donation.getAmount());
            stmt.setInt(4, donation.getDonationId());
            stmt.executeUpdate();
            System.out.println("Donation updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String query = "DELETE FROM donation WHERE donationId=?";
        try (Connection con = DBConnection.getDBConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Donation deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
