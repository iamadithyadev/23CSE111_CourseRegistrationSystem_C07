# 🎓 Course Registration System

**Course:** 23CSE111 – Object Oriented Programming  
**Program:** S2 B.Tech CSE | Amrita School of Computing, Amritapuri  
**Case Study:** Phase I, II & III | Team ID: C07

---

## 👥 Team Members

| Roll No | Name |
|----------|----------------|
| AM.SC.U4CSE25261 | Adithyadev |
| AM.SC.U4CSE25265 | Nived Krishna |
| AM.SC.U4CSE25260 | Dhanesh |
| AM.SC.U4CSE25266 | Abhishek |

---

## 📌 Problem Description

Managing course registration manually in educational institutions is time-consuming and prone to errors such as duplicate entries, incorrect seat allocation, and poor record management. This project implements a Course Registration System using Java to automate and streamline the process.

The system supports three types of users: Admin, Student, and Instructor. The Admin can add, update, and remove courses, as well as assign instructors. Students can register for courses, drop courses, and view their registered courses based on seat availability. Instructors can view the courses assigned to them.

The system ensures proper validation by preventing duplicate registrations, checking seat limits before enrollment, and maintaining registration records with status tracking (ACTIVE/CANCELLED).

---

## ⚙️ Features

- User login system
- Course creation and removal by Admin
- Instructor assignment
- Student course registration and drop
- Seat availability validation
- Duplicate registration prevention
- View registered courses
- Registration status tracking

---

## ▶️ How to Run

### Prerequisites
- Java JDK 8 or above
- Eclipse / IntelliJ / Terminal

### Steps

```bash
# Compile all Java files
javac *.java

# Run program
java Main
```

---

## 🔑 Default Login Credentials

| Role | Username | Password |
|------|----------|----------|
| Admin | admin01 | adminpass |
| Student | iamAD | AD01 |
| Instructor | inst01 | pramod123 |

---

## 📚 Class Overview

### User.java
- Base class for all users
- Handles login authentication

### Student.java
- Registers and drops courses
- Stores student details and registrations

### Instructor.java
- Views assigned courses

### Admin.java
- Adds, removes, and updates courses
- Assigns instructors to courses

### Course.java
- Stores course details
- Manages seat availability

### CourseCatalog.java
- Maintains course list
- Provides course search functionality

### Registration.java
- Tracks student registrations
- Maintains registration status

---

## 📷 Sample Input / Output

### 🔐 Login

#### Input
```text
Student login
Username: iamAD
Password: AD01
```

#### Output
```text
Student login: true
```

---

### 📚 Add Course

#### Input
```text
Course ID: 23CSE111
Course Name: Object Oriented Programming
Credits: 4
Seats: 3
```

#### Output
```text
[Admin] Course added: Course{ID='23CSE111', Name='Object Oriented Programming', Credits=4, Seats=3, Instructor='Not Assigned'}
```

---

### 📝 Register Course

#### Input
```text
Student registers for course: CS101
```

#### Output
```text
Registration entry created: REG001
[SUCCESS] Adithya Dev registered for course: Object Oriented Programming
```

---

### ❌ Duplicate Registration

#### Output
```text
[FAILURE] Already registered for course: 23CSE111
```

---

### 🚫 No Seats Available

#### Output
```text
[FAILURE] No seats available for course: Database Management Systems
```

---

### 📖 View Registered Courses

#### Output
```text
Course{ID='23CSE111', Name='Object Oriented Programming', Credits=4, Seats=2, Instructor='Pramod'}
```

---

### 🗑️ Drop Course

#### Output
```text
[Drop Successful] Adithyadev dropped course: 23CSE111
```

---

### 👨‍🏫 Instructor Views Assigned Courses

#### Input
```text
Instructor views assigned courses
```

#### Output
```text
Course{ID='23CSE111', Name='Object Oriented Programming', Credits=4, Seats=2, Instructor='Pramod'}

Course{ID='23CSE102', Name='Data Structures and Algorithms', Credits=4, Seats=0, Instructor='Pramod'}
```

## 📂 Project Structure

```text
/Phase1        → Phase 1 documentation
/Phase2        → Phase 2 documentation
/Phase3        → Phase 3 documentation
/src           → Java source code
/output        → Output screenshots
README.md      → Documentation
```

---

## 🛠️ Tools / Technologies Used

| Concept | Usage |
|----------|-------------------------------|
| OOP (Inheritance) | User → Student/Admin/Instructor |
| Encapsulation | Private fields + getters/setters |
| Abstraction | Base User class |
| ArrayList | Store courses and registrations |
| Validation Checks | Prevent duplicate registration and invalid operations |
| Java Collections | Manage dynamic data 

---

## 💡 Notes

- Console-based application
- Passwords stored in plain text for simplicity
- Designed for learning Object-Oriented Programming concepts

---

## ✅ Conclusion

This project demonstrates how a real-world course registration system can be implemented using Java and Object-Oriented Programming principles. It provides a structured and efficient way to manage users, courses, and registrations while reducing manual errors and improving data handling.
