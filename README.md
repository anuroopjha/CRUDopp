## Overview

This project is an API Automation Framework built with Java and RestAssured. It performs CRUD operations on a sample API and generates test reports using Allure and Extent.

## Features

* **CRUD Operations**: Automated tests for Create, Read, Update, and Delete APIs.
* **Data-Driven Testing**: Uses Cucumber with Scenario Outlines and Examples.
* **Parallel Execution**: Tests run faster using TestNG.
* **Detailed Reports**: Generates reports in both Allure and Extent formats.

## Technologies

* **Java 11+**
* **RestAssured** – For making API calls
* **Cucumber** – For writing human-readable test cases
* **TestNG** – For test execution
* **Maven** – For build and dependency management
* **Allure / Extent Reports** – For report generation

## Getting Started

### Prerequisites

* Java 11 or later
* Maven
* Allure CLI (for report viewing)

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/anuroopjha/CRUDopp.git
   cd CRUDopp
   ```

2. Import the project in IntelliJ or Eclipse as a Maven project.

3. Run the tests:

   ```bash
   mvn clean test
   ```

### View Reports

* **Allure Report**
  Serve it locally:

  ```bash
  allure serve allure-results
  ```

  Or generate HTML:

  ```bash
  allure generate allure-results --clean -o target/allure-report
  ```

* **Extent Report**
  Open this file in browser after tests:

  ```
  target/ExtentReport.html
  ```

## Sample Test Result

```
Total Scenarios: 4
Passed: 4
Failed: 0
Execution Time: 10 seconds
```
