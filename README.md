# 🎓 Course Registration System

**Course:** 23CSE111 – Object Oriented Programming
**Program:** S2 B.Tech CSE | Amrita School of Computing, Amritapuri
**Case Study:** Phase I, II & III | Team ID: C07
---

## 👥 Team Members

| Roll No          | Name          |
| ---------------- | ------------- |
| AM.SC.U4CSE25261 | Adithyadev   |
| AM.SC.U4CSE25265 | Nived Krishna |
| AM.SC.U4CSE25260 | Dhanesh       |
| AM.SC.U4CSE25266 | Abhishek      |

---

## 📌 Problem Description

Managing course registration manually in educational institutions is time-consuming and prone to errors such as duplicate entries, incorrect seat allocation, and poor record management. This project implements a Course Registration System using Java to automate and streamline the process.

The system supports three types of users: Admin, Student, and Instructor. The Admin can add, update, and remove courses, as well as assign instructors. Students can register for courses, drop courses, and view their registered courses based on seat availability. Instructors can view the courses assigned to them.

The system ensures proper validation by preventing duplicate registrations, checking seat limits before enrollment, and maintaining registration records with status tracking (ACTIVE/CANCELLED). This improves efficiency, accuracy, and organization in managing academic course data.

---

## ⚙️ Features

* User login system (Admin, Student, Instructor)
* Admin can add, update, and remove courses
* Assign instructors to courses
* Students can register and drop courses
* Seat availability checking
* Duplicate registration prevention
* View registered courses
* Registration status tracking (ACTIVE / CANCELLED)

---

## ▶️ How to Run

### Prerequisites

* Java JDK 8 or above
* Eclipse / IntelliJ / Terminal

### Steps

```bash
# Compile all Java files
javac *.java

# Run program
java Main
```

---

## 🔑 Default Login Credentials

| Role       | Username | Password  |
| ---------- | -------- | --------- |
| Admin      | admin01  | adminpass |
| Student    | iamAD    | AD01      |
| Instructor | inst01   | pramod123 |

---

## 📚 Class Overview

### User.java

* Base class for all users
* Handles login authentication

### Student.java

* Registers and drops courses
* Stores student details

### Instructor.java

* Views assigned courses

### Admin.java

* Adds, removes, updates courses
* Assigns instructors

### Course.java

* Stores course details
* Manages seat availability

### CourseCatalog.java

* Maintains list of courses
* Provides search functionality

### Registration.java

* Tracks course registrations
* Maintains status (ACTIVE / CANCELLED)

---

## 📷 Sample Output

### Login

```
Student login: true
Admin login: true
Instructor login: true
Invalid login: false
```

### Course Registration

```
[SUCCESS] Adithya Dev registered for course: Object Oriented Programming
[FAILURE] Already registered for course: CS101
```

### Drop Course

```
[Drop Successful] Adithya Dev dropped course: CS101
```

---

## 📂 Project Structure

```
/Phase1        → Phase 1 documentation  
/Phase2        → Phase 2 documentation  
/src           → Java source code  
/output        → Output screenshots  
README.md      → Documentation  
```

---

## 🛠️ Tools / Technologies Used

| Concept            | Usage                            |
| ------------------ | -------------------------------- |
| OOP (Inheritance)  | User → Student/Admin/Instructor  |
| Encapsulation      | Private fields + getters/setters |
| Abstraction        | Base User class                  |
| ArrayList          | Store courses and registrations  |
| Exception Handling | Handle runtime errors            |
| Java Collections   | Manage dynamic data              |

---

## 💡 Notes

* Console-based application
* Passwords stored in plain text (for simplicity)
* Designed for learning Object-Oriented Programming concepts

---
