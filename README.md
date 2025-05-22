# DVDClub

A full-stack web application for managing a DVD club, built with Spring Boot (Java), Angular (TypeScript), and PostgreSQL.

## Features

- User authentication and role-based access (e.g., Admin, Customer)
- DVD catalog with search and filtering
- Rental management (borrow, return, late fees)
- Admin dashboard for managing Marketplaces, DVDs and all information regarding them, like films, actors etc.
- Email notifications for account creation and overdue DVD returns

## Technologies Used

**Frontend:** Angular  
**Backend:** Spring Boot (Java), JavaMail (for sending emails)  
**Database:** PostgreSQL  
**Build Tools:** Maven, Node.js  

---

## Project Structure

DVDClub/  
├── DVDClub-backend/ # Spring Boot application  
│ ├── src/main/java/... # Java source files  
│ └── src/main/resources/  
├── DVDClub-frontend/ # Angular application  
│ ├── src/app/  
│ └── angular.json  
└── README.md  

---

## Setup Instructions

### Prerequisites

- Java 17+
- Node.js 18+
- PostgreSQL
- Maven
- Angular CLI

### 1. Clone the repository

```bash
git clone https://github.com/igorr00/DVDClub.git
cd DVDClub
```
2. Backend Setup (Spring Boot)
Configure your database in src/main/resources/application.properties:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/dvd-club
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password
```
Run the backend:
```bash
cd DVDClub-backend
./mvnw spring-boot:run
```

3. Frontend Setup (Angular)

```bash
cd DVDClub-frontend
npm install
ng serve
```
Visit http://localhost:4200 to see the app.

## Email Notifications

The system uses JavaMail (via Spring Boot) to send transactional emails to users for:

- Account creation confirmation
- Reminders for overdue DVD returns

To configure email:

In `application.properties`, set your SMTP server settings:

```properties
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=igor.miskic00@gmail.com
spring.mail.password=kceapznhebytbuai
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

---

## Author
Igor Miskic  
GitHub: @igorr00  
LinkedIn: https://www.linkedin.com/in/igor-miškić-497182283
