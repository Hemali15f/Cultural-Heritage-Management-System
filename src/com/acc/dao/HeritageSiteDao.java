package com.acc.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.acc.HeritageSite;
import com.acc.util.DBConnection;

public class HeritageSiteDao {
    public List<HeritageSite> findAll() {
        List<HeritageSite> sites = new ArrayList<>();
        String query = "SELECT * FROM heritage_site";
        try (Connection con = DBConnection.getDBConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                sites.add(new HeritageSite(rs.getInt("siteId"), rs.getString("name"), rs.getString("location"), rs.getString("description")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sites;
    }

    public HeritageSite findOne(int id) {
        HeritageSite site = null;
        String query = "SELECT * FROM heritage_site WHERE siteId = ?";
        try (Connection con = DBConnection.getDBConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                site = new HeritageSite(rs.getInt("siteId"), rs.getString("name"), rs.getString("location"), rs.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return site;
    }

    public void add(HeritageSite site) {
        String query = "INSERT INTO heritage_site (name, location, description) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getDBConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setString(1, site.getName());
            stmt.setString(2, site.getLocation());
            stmt.setString(3, site.getDescription());
            stmt.executeUpdate();
            System.out.println("Heritage site added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(HeritageSite site) {
        String query = "UPDATE heritage_site SET name=?, location=?, description=? WHERE siteId=?";
        try (Connection con = DBConnection.getDBConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setString(1, site.getName());
            stmt.setString(2, site.getLocation());
            stmt.setString(3, site.getDescription());
            stmt.setInt(4, site.getSiteId());
            stmt.executeUpdate();
            System.out.println("Heritage site updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String query = "DELETE FROM heritage_site WHERE siteId=?";
        try (Connection con = DBConnection.getDBConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Heritage site deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
