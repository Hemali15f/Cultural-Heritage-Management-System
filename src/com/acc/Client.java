package com.acc;

import com.acc.dao.DonationDao;
import com.acc.dao.EventDao;
import com.acc.dao.HeritageSiteDao;
import com.acc.dao.VisitorDao;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        HeritageSiteDao siteDao = new HeritageSiteDao();
        EventDao eventDao = new EventDao();
        VisitorDao visitorDao = new VisitorDao();
        DonationDao donationDao = new DonationDao();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n.-.-.-.-.- Heritage Management System .-.-.-.-.- ");
            System.out.println("1. Add Heritage Site");
            System.out.println("2. View All Heritage Sites");
            System.out.println("3. Add Visitor");
            System.out.println("4. Add Donation");
            System.out.println("5. Update Heritage Site");
            System.out.println("6. Delete Heritage Site");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    // Add a heritage site
                    System.out.print("Enter heritage site name: ");
                    String siteName = scanner.nextLine();
                    System.out.print("Enter heritage site location: ");
                    String siteLocation = scanner.nextLine();
                    System.out.print("Enter heritage site description: ");
                    String siteDescription = scanner.nextLine();
                    HeritageSite site = new HeritageSite(0, siteName, siteLocation, siteDescription);
                    siteDao.add(site);
                    System.out.println("Heritage site added successfully.");
                    break;
                case 2:
                    // View all heritage sites
                    System.out.println("List of heritage sites:");
                    for (HeritageSite s : siteDao.findAll()) {
                        System.out.println(s);
                    }
                    break;
                case 3:
                    // Add a visitor
                    System.out.print("Enter visitor name: ");
                    String visitorName = scanner.nextLine();
                    System.out.print("Enter visitor email: ");
                    String visitorEmail = scanner.nextLine();
                    System.out.print("Enter visitor phone: ");
                    String visitorPhone = scanner.nextLine();
                    Visitor visitor = new Visitor(0, visitorName, visitorEmail, visitorPhone);
                    visitorDao.add(visitor);
                    System.out.println("Visitor added successfully.");
                    break;
                case 4:
                    // Add a donation
                    System.out.print("Enter visitor ID: ");
                    int visitorId = scanner.nextInt();
                    System.out.print("Enter site ID: ");
                    int siteId = scanner.nextInt();
                    System.out.print("Enter donation amount: ");
                    double amount = scanner.nextDouble();
                    Donation donation = new Donation(0, visitorId, siteId, amount);
                    donationDao.add(donation);
                    System.out.println("Donation added successfully.");
                    break;
                case 5:
                    // Update a heritage site
                    System.out.print("Enter site ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new name for the site: ");
                    String newSiteName = scanner.nextLine();
                    System.out.print("Enter new location for the site: ");
                    String newLocation = scanner.nextLine();
                    System.out.print("Enter new description for the site: ");
                    String newDescription = scanner.nextLine();
                    HeritageSite updatedSite = new HeritageSite(updateId, newSiteName, newLocation, newDescription);
                    siteDao.update(updatedSite);
                    System.out.println("Heritage site updated successfully.");
                    break;
                case 6:
                    // Delete a heritage site
                    System.out.print("Enter site ID to delete: ");
                    int deleteId = scanner.nextInt();
                    siteDao.delete(deleteId);
                    System.out.println("Heritage site deleted successfully.");
                    break;
                case 7:
                    // Exit the program
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);
    }
}
