# MotorPHEmployeeApp

## Overview

MotorPH Employee App is a Java Swing-based desktop application developed for MO-IT103 – Computer Programming 2. The system provides employee record management, payroll computation, and data maintenance functionalities using CSV file integration.

The application was developed incrementally through project milestones and integrates GUI development, employee record handling, salary computation, and record maintenance into a single unified system.

---

## Features

### Feature 1 – GUI Development and Interface Refinement

* Java Swing graphical user interface
* Employee Number input field
* Employee Name input field
* Pay Coverage input field
* Event-driven programming using ActionListeners
* Exception handling and input validation
* User-friendly interface design

### Feature 2 – Employee Record Management

* Load employee records from CSV files
* Display records using JTable
* View employee details
* Add new employee records
* Automatic table refresh after data updates
* Employee Number duplication checking
* Validation for required fields

### Feature 3 – Salary Computation

* Gross Pay computation
* SSS deduction computation
* PhilHealth deduction computation
* Pag-IBIG deduction computation
* Withholding Tax computation
* Total deductions computation
* Net Pay computation
* Salary result display through GUI
* CSV file update after computation

### Feature 4 – Update and Delete Records

* Select employee records from JTable
* Update employee information
* Delete employee records
* Confirmation dialogs using JOptionPane
* Automatic table refresh
* Validation before update and deletion
* CSV file synchronization

---

## Technologies Used

* Java
* Java Swing
* JTable
* CSV File Handling
* NetBeans IDE
* Object-Oriented Programming

---

## Project Structure

```text
MotorPHEmployeeApp/
├── nbproject/
├── src/
│   ├── MotorPHGUI.java
│   ├── MotorPH_Payroll.java
│   └── SalaryComputationModule.java
├── attendance.csv
├── employees.csv
├── build.xml
└── manifest.mf
```

---

## Validation and Error Handling

The application includes:

* Required field validation
* Numeric input validation
* Duplicate Employee Number checking
* CSV file read/write error handling
* Record selection validation
* Update and delete confirmation dialogs

---

## How to Run

1. Open the project in NetBeans IDE.
2. Build the project.
3. Run the application.
4. Load employee records.
5. Manage employee information.
6. Compute salaries.
7. Update or delete records as needed.

---

## Author

Mhonic Panuringan

