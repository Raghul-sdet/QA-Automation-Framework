# 🚀 QA Automation Framework

## 📌 Overview
This is a robust, data-driven hybrid automation framework built from scratch. It demonstrates end-to-end testing capabilities, seamlessly integrating UI automation with backend database validation to ensure data integrity.

## 🛠️ Tech Stack & Master Skills
* **Core Language:** Java
* **UI Automation:** Selenium WebDriver
* **Test Engine & Assertions:** TestNG
* **Data-Driven Approach:** Apache POI (Excel Data Provider)
* **Backend Validation:** JDBC with H2 In-Memory Database (Oracle Mode)
* **Reporting:** Extent HTML Reports
* **Build Management:** Maven

## 🎯 Core Features
1. **Dynamic Database Validation:** Intercepts UI actions and verifies them directly against backend records using SQL queries.
2. **Page Object Model (POM):** Ensures code reusability and clean architecture.
3. **Zero-Install Virtual DB:** Utilizes H2 Database in Oracle compatibility mode for seamless, memory-efficient test data generation without heavy server installations.
4. **Professional Reporting:** Generates detailed `Automation_Report.html` with pass/fail metrics.

## ⚙️ How to Run Locally
1. Clone the repository: `git clone https://github.com/raghul-sdet/Enterprise-QA-Automation-Framework.git`
2. Import as a Maven Project in Eclipse/IntelliJ.
3. Update Maven dependencies (`pom.xml`).
4. Run `DatabaseHelper.java` to test the virtual backend setup.
5. Execute `LoginTest.java` as a TestNG Suite to trigger the full automation flow.
