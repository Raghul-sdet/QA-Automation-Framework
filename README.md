# 🚀 QA Automation Framework

## 📌 Overview
A robust, data-driven hybrid automation framework built from scratch to demonstrate end-to-end testing capabilities. This framework seamlessly integrates frontend UI automation with backend database validation to ensure complete data integrity across application layers.

## 🛠️ Tech Stack & Tools
* **Core Language:** Java
* **UI Automation:** Selenium WebDriver
* **Test Engine & Assertions:** TestNG
* **Data-Driven Approach:** Apache POI (Excel Data Provider)
* **Backend Validation:** JDBC with H2 In-Memory Database (Oracle Compatibility Mode)
* **Reporting:** Extent HTML Reports
* **Build Management:** Maven

## 🎯 Core Features
* **Dynamic Database Validation:** Intercepts frontend UI actions and verifies them directly against backend records using Oracle SQL queries.
* **Page Object Model (POM):** Ensures code reusability, modularity, and clean architecture.
* **Zero-Install Virtual DB:** Utilizes H2 Database in Oracle mode for seamless, memory-efficient test data generation without heavy server installations.
* **Professional Reporting:** Auto-generates detailed `Automation_Report.html` with execution metrics.

## ⚙️ How to Run Locally
1. **Clone the repository:** `git clone https://github.com/Raghul-sdet/QA-Automation-Framework.git`
2. **Import Project:** Open Eclipse and import as an 'Existing Maven Project'.
3. **Update Dependencies:** Right-click on `pom.xml` -> Maven -> Update Project.
4. **Database Test:** Run `DatabaseHelper.java` as a Java Application to test the virtual backend setup.
5. **Execute Suite:** Run `LoginTest.java` (or your TestNG suite file) to trigger the full automation flow.

## 👨‍💻 Author
**Raghul**
*QA Automation Engineer*
📩 Contact: raghul.sdet@gmail.com
