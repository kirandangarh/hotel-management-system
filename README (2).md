# Hotel Management System

A **Java Swing + MySQL** based desktop application that provides hotel management functionalities such as room booking, customer details management, and billing system. This project helps automate hotel operations efficiently.

## 🚀 Features
- User-friendly **Java Swing GUI**
- Manage hotel customers, rooms, and staff
- Room booking and checkout system
- Database integration with **MySQL**
- Secure login system for hotel staff
- Invoice/bill generation

## 🛠️ Tech Stack
- **Programming Language:** Java (Swing, AWT)
- **Database:** MySQL
- **IDE:** NetBeans / Eclipse / IntelliJ (any Java IDE)
- **JDBC:** For database connectivity

## 📂 Project Structure
```
hotel-management-system/
│-- src/
│   ├── hotel/management/system/
│   │   ├── Login.java
│   │   ├── Dashboard.java
│   │   ├── AddCustomer.java
│   │   ├── Room.java
│   │   ├── Checkout.java
│   │   └── ... (other pages)
│-- db/
│   ├── hotelmanagementsystem.sql
│-- README.md
```

## ⚙️ Setup Instructions

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/Hotel_Management_System.git
   cd Hotel_Management_System
   ```

2. **Import the project**
   - Open your preferred Java IDE (NetBeans, Eclipse, IntelliJ).
   - Import the project folder.

3. **Setup MySQL Database**
   - Start MySQL server.
   - Create a new database, e.g., `hotelmanagementsystem`.
   - Import the SQL file:
     ```sql
     source db/hotelmanagementsystem.sql;
     ```
   - Update **database credentials** in your Java code (username/password).

4. **Run the Project**
   - Compile and run `HotelManagementSystem.java`.
   - Login with test credentials (e.g., `admin/admin`).

## 🤝 Contribution
Contributions are welcome! Feel free to fork this project and submit a pull request.

## 📜 License
This project is licensed under the MIT License.
