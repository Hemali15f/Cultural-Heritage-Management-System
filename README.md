The Cultural Heritage Management System is a Java-based desktop application designed to digitize and streamline the management of cultural heritage data. It enables handling of visitors, heritage sites, donations, and events through an intuitive interface and database-backed operations.

🛠️ Tech Stack
Language: Java (JDK 11+)

IDE: Eclipse

Database: MySQL

Connectivity: JDBC

📌 Key Features
Add, view, and manage heritage sites, events, visitors, and donations

Modular Java classes representing each entity

JDBC-based MySQL database interaction

Clear separation of logic with DAO (Data Access Object) pattern

Configurable and extensible for future use

🚀 How to Run the Project
Install Required Tools

Java JDK (11 or later)

Eclipse IDE

MySQL Server (with phpMyAdmin or CLI)

Import the Project

Open Eclipse → File → Import → Existing Projects into Workspace

Choose the extracted folder

Setup Database

Create a MySQL database (e.g., heritage_db)

Create the required tables as expected by the DAO classes (or share your SQL file if needed)

Configure DB Connection

Edit DBConnection.java with your database URL, username, and password

Run the Program

Right-click Client.java or main file → Run As → Java Application

📌 Example Entities
HeritageSite: siteId, name, location, description

Visitor: visitorId, name, contact, visitDate

Donation: donorName, amount, purpose

Event: eventName, date, description

📄 Notes
Project is modularized with module-info.java

DAO layer encapsulates all SQL queries for each entity

GUI is not included; this is a console or backend-oriented system
